package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class OrderMenu {

    private static final String ORDER_MENU_FORMAT = "([가-힣A-Z]+-\\d+,)*[가-힣A-Z]+-\\d+";
    private static final String ERROR_FORMAT = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ERROR_DUPLICATION = "[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요.";
    private static final String ERROR_ORDER_LIMIT = "[ERROR] 총 메뉴의 개수가 20개를 초과하였습니다. 20개 이하로 다시 입력해 주세요.";
    private static final String ERROR_ONLY_BEVERAGE = "[ERROR] 음료만은 주문할 수 없습니다. 다시 입력해 주세요.";
    private static final String BEVERAGE = "beverage";

    List<Menu> order = new ArrayList<>();
    private int totalOrderCount;

    public OrderMenu(String input) {
        validateOrderFormat(input);
        String[] split = input.split(",");
        for (String eachMenu : split) {
            Menu menu = new Menu(eachMenu);
            order.add(menu);
        }

        isSameMenu();
        validateOrderLimit();
        isOrderOnlyBeverage();
    }

    private void validateOrderFormat(String input) {
        if (!input.matches(ORDER_MENU_FORMAT)) throw new IllegalArgumentException(ERROR_FORMAT);
    }

    private void isSameMenu() {
        List<String> orderMenus = new ArrayList<>();
        for (Menu menu : order) {
            orderMenus.add(menu.getMenuName());
        }
        if (orderMenus.size() != orderMenus.stream().distinct().count()) throw new IllegalArgumentException(ERROR_DUPLICATION);
    }

    private void validateOrderLimit() {
        for (Menu menu : order) {
            totalOrderCount += menu.getAmount();
        }
        if (totalOrderCount > 20) throw new IllegalArgumentException(ERROR_ORDER_LIMIT);
    }

    private void isOrderOnlyBeverage() {
        if (order.stream().filter(menu -> menu.getMenu().getType().matches(BEVERAGE)).distinct().count() == totalOrderCount) {
            throw new IllegalArgumentException(ERROR_ONLY_BEVERAGE);
        }
    }

    public List<Menu> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        String orderMenu = "";
        for (Menu menu : order) {
            orderMenu += menu.toString() + "\n";
        }
        return orderMenu;
    }
}
