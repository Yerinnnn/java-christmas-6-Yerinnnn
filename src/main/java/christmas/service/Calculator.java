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

    public int totalOrderAmount(OrderMenu orderMenu) {
        int totalPrice = 0;
        for (Menu menu : orderMenu.getOrder()) {
            totalPrice += (MenuItem.of(menu.getMenuName())).getPrice() * menu.getAmount();
        }
        return totalPrice;
    }

    public int christmasDdayDiscount(VisitDate visitDate) {
        return CHRISTMAS_BASIC_DISCOUNT + (visitDate.getDate()-1) * CHRISTMAS_ADDITIONAL_DISCOUNT;
    }

    public int weekdayDiscount(OrderMenu orderMenu) {
        int dessertCount = 0;
        for (Menu menu : orderMenu.getOrder()) {
            if (MenuItem.of(menu.getMenuName()).getType().equals("dessert")) {
                dessertCount += menu.getAmount();
            }
        }
        return dessertCount * WEEKDAY_DISCOUNT;
    }

    public int weekendDiscount(OrderMenu orderMenu) {
        int mainCount = 0;
        for (Menu menu : orderMenu.getOrder()) {
            if(MenuItem.of(menu.getMenuName()).getType().equals("main")) {
                mainCount += menu.getAmount();
            }
        }
        return mainCount * WEEKEND_DISCOUNT;
    }

    public String badgeEvent(int totalDiscountAmount) {
        if (totalDiscountAmount >= 20000) {
            return "산타";
        } else if (totalDiscountAmount >= 10000) {
            return "트리";
        } else if (totalDiscountAmount >= 5000) {
            return "별";
        }
        return "없음";
    }
}
