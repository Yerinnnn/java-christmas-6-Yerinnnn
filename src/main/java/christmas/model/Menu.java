package christmas.model;

import java.util.Arrays;

public class Menu {
    String menu;
    int amount;

    public Menu(String input) {
        String[] split = input.split("-");
        this.menu = split[0];
        this.amount = Integer.parseInt(split[1]);
    }

    @Override
    public String toString() {
        return menu + " " + amount + "개";
    }
}
