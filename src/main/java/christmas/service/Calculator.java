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
    private static final int BADGE_SANTA_DISCOUNT_AMOUNT = 20000;
    private static final int BADGE_TREE_DISCOUNT_AMOUNT = 10000;
    private static final int BADGE_STAR_DISCOUNT_AMOUNT = 5000;

    private static final String DESSERT = "dessert";
    private static final String MAIN = "main";

    public int christmasDdayDiscount(VisitDate visitDate) {
        return CHRISTMAS_BASIC_DISCOUNT + (visitDate.getDate() - 1) * CHRISTMAS_ADDITIONAL_DISCOUNT;
    }

    public int weekdayDiscount(OrderMenu orderMenu) {
        return orderMenu.countDessertMenus() * WEEKDAY_DISCOUNT;
    }

    public int weekendDiscount(OrderMenu orderMenu) {
        return orderMenu.countMainMenus() * WEEKEND_DISCOUNT;
    }

    public String badgeEvent(int totalDiscountAmount) {
        if (totalDiscountAmount >= BADGE_SANTA_DISCOUNT_AMOUNT) {
            return "산타";
        } else if (totalDiscountAmount >= BADGE_TREE_DISCOUNT_AMOUNT) {
            return "트리";
        } else if (totalDiscountAmount >= BADGE_STAR_DISCOUNT_AMOUNT) {
            return "별";
        }
        return "없음";
    }
}
