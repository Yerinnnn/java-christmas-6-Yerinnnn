package christmas.service;

import christmas.model.Menu;
import christmas.model.MenuItem;
import christmas.model.OrderMenu;

public class Calculator {

    public int totalOrderAmount(OrderMenu orderMenu) {
        int totalPrice = 0;
        for (Menu menu : orderMenu.getOrder()) {
            totalPrice += (MenuItem.of(menu.getMenu())).getPrice() * menu.getAmount();
        }
        return totalPrice;
    }
}
