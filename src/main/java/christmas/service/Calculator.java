package christmas.service;

import christmas.model.Menu;
import christmas.model.MenuItem;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;

public class Calculator {

    private static final int CHRISTMAS_BASIC_DISCOUNT = 1000;
    private static final int CHRISTMAS_ADDITIONAL_DISCOUNT = 100;

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
}
