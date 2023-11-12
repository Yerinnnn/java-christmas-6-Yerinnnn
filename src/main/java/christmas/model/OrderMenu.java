package christmas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMenu {

    List<Menu> order = new ArrayList<>();

    public OrderMenu(String input) {
        String[] split = input.split(",");

        for (String eachMenu : split) {
            Menu menu = new Menu(eachMenu);
            order.add(menu);
        }
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
