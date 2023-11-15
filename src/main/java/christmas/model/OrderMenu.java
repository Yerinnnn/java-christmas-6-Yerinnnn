package christmas.model;

import java.util.ArrayList;
import java.util.List;

import static christmas.message.ErrorMessage.*;

public class OrderMenu {

    private static final String ORDER_MENU_FORMAT = "([가-힣A-Z]+-\\d+,)*[가-힣A-Z]+-\\d+";


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
        if (!input.matches(ORDER_MENU_FORMAT)) throw new IllegalArgumentException(ORDER_FORMAT_ERROR.get());
    }

    private void isSameMenu() {
        List<String> orderMenus = new ArrayList<>();
        for (Menu menu : order) {
            orderMenus.add(menu.getMenuName());
        }
        if (orderMenus.size() != orderMenus.stream().distinct().count()) throw new IllegalArgumentException(MENU_DUPLICATION_ERROR.get());
    }

    private void validateOrderLimit() {
        for (Menu menu : order) {
            totalOrderCount += menu.getAmount();
        }
        if (totalOrderCount > 20) throw new IllegalArgumentException(ORDER_LIMIT_ERROR.get());
    }

    private void isOrderOnlyBeverage() {
        if (order.stream().filter(menu -> menu.isBeverage()).count() == totalOrderCount) {
            throw new IllegalArgumentException(ORDER_ONLY_BEVERAGE_ERROR.get());
        }
    }

    public List<Menu> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        StringBuilder orderMenu = new StringBuilder("");
        for (Menu menu : order) {
            orderMenu.append(menu.toString() + "\n");
        }
        return orderMenu.toString();
    }
}
