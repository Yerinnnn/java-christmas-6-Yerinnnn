package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class OrderMenu {

    List<Menu> order = new ArrayList<>();

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
        if (!input.matches("([가-힣A-Z]+-\\d+,)*[가-힣A-Z]+-\\d+")) throw new IllegalArgumentException("[ERROR] 형식이 올바르지 않습니다. 다시 입력해 주세요.");
    }

    private void isSameMenu() {
        List<String> orderMenus = null;
        for (Menu menu : order) {
            orderMenus.add(menu.getMenuName());
        }
        if (orderMenus.size() != orderMenus.stream().distinct().count()) throw new IllegalArgumentException("[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요.");
    }

    private void validateOrderLimit() {
        int totalOrderCount = 0;
        for (Menu menu : order) {
            totalOrderCount += menu.getAmount();
        }
        if (totalOrderCount > 20) throw new IllegalArgumentException("[ERROR] 총 메뉴의 개수가 20개를 초과하였습니다. 20개 이하로 다시 입력해 주세요.");
    }

    private void isOrderOnlyBeverage() {
        for (Menu menu : order) {
            if (menu.getMenu().getType().matches("beverage")) throw new IllegalArgumentException("[ERROR] 음료만은 주문할 수 없습니다. 다시 입력해 주세요.");
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
