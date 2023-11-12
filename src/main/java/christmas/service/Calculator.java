package christmas.service;

import christmas.model.Menu;
import christmas.model.MenuItem;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;

public class Calculator {

    private static final int CHRISTMAS_BASIC_DISCOUNT = 1000;
    private static final int CHRISTMAS_ADDITIONAL_DISCOUNT = 100;
    private static final int WEEKDAY_DISCOUNT = 2023;
    private static final int WEEKEND_DISCOUNT = 2023;
    private static final int SPECIAL_DAY_DISCOUNT = 1000;

    public int totalOrderAmount(OrderMenu orderMenu) {
        int totalPrice = 0;
        for (Menu menu : orderMenu.getOrder()) {
            totalPrice += (MenuItem.of(menu.getMenu())).getPrice() * menu.getAmount();
        }
        return totalPrice;
    }

    public int calculateChristmasDdayDiscount(VisitDate visitDate) {
        return CHRISTMAS_BASIC_DISCOUNT + (visitDate.getDate()-1) * CHRISTMAS_ADDITIONAL_DISCOUNT;
    }

    public int calculateWeekdayDiscount(OrderMenu orderMenu) {
        int dessertCount = 0;
        for (Menu menu : orderMenu.getOrder()) {
            if (MenuItem.of(menu.getMenu()).getType().equals("dessert")) {
                dessertCount += menu.getAmount();
            }
        }
        return dessertCount * WEEKDAY_DISCOUNT;
    }

    public int calculateWeekendDiscount(OrderMenu orderMenu) {
        int mainCount = 0;
        for (Menu menu : orderMenu.getOrder()) {
            if(MenuItem.of(menu.getMenu()).getType().equals("main")) {
                mainCount += menu.getAmount();
            }
        }
        return mainCount * WEEKEND_DISCOUNT;
    }

    public int calculateSpecialDayDiscount(int totalOrderAmount) {
        return SPECIAL_DAY_DISCOUNT;
    }
}
