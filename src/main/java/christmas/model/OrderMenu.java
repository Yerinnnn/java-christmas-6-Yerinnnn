package christmas.model;

import java.util.ArrayList;
import java.util.List;

import static christmas.message.ErrorMessage.*;

public class OrderMenu {

    private static final String ORDER_MENU_FORMAT = "([가-힣A-Z]+-\\d+,)*[가-힣A-Z]+-\\d+";

    private static final String MAIN = "main";
    private static final String DESSERT = "dessert";
    private static final String BEVERAGE = "beverage";
    private static final int MAX_ORDER_COUNT = 20;

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

    @Override
    public String toString() {
        StringBuilder orderMenu = new StringBuilder("");
        for (Menu menu : order) {
            orderMenu.append(menu.toString() + "\n");
        }
        return orderMenu.toString();
    }

    /**
     * validate method
     */

    private void validateOrderFormat(String input) {
        if (!input.matches(ORDER_MENU_FORMAT)) throw new IllegalArgumentException(ORDER_FORMAT_ERROR.get());
    }

    private void isSameMenu() {
        if (order.size() != order.stream().map(eachMenu -> eachMenu.menu.toString()).distinct().count()) throw new IllegalArgumentException(MENU_DUPLICATION_ERROR.get());
    }

    private void validateOrderLimit() {
        for (Menu menu : order) {
            totalOrderCount += menu.amount;
        }
        if (totalOrderCount > MAX_ORDER_COUNT) throw new IllegalArgumentException(ORDER_LIMIT_ERROR.get());
    }

    private void isOrderOnlyBeverage() {
        if (countBeverageMenus() == totalOrderCount) {
            throw new IllegalArgumentException(ORDER_ONLY_BEVERAGE_ERROR.get());
        }
    }

    /**
     * calculate method
     */

    public int totalOrderAmount() {
        return order.stream().map(menu -> menu.amount * menu.price).mapToInt(i -> i).sum();
    }

    public int countMainMenus() {
        int mainCount = 0;
        for (Menu menu : order) {
            if (menu.type.equals(MAIN)) {
                mainCount += menu.amount;
            }
        }
        return mainCount;
    }

    public int countDessertMenus() {
        int dessertCount = 0;
        for (Menu menu : order) {
            if (menu.type.equals(DESSERT)) {
                dessertCount += menu.amount;
            }
        }
        return dessertCount;
    }

    private int countBeverageMenus() {
        int beverageCount = 0;
        for (Menu menu : order) {
            if (menu.type.equals(BEVERAGE)) {
                beverageCount += menu.amount;
            }
        }
        return beverageCount;
    }
}
