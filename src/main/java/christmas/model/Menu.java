package christmas.model;

import static christmas.message.ErrorMessage.*;

public class Menu {

    private static final String ONLY_NUMERIC = "\\d+";

    private static final String BEVERAGE = "beverage";

    MenuItem menu;
    int amount;

    public Menu(String input) {
        String[] split = input.split("-");
        validateExist(split[0]);
        validateCountIsNumeric(split[1]);
        validateMenuCount(split[1]);
        this.menu = MenuItem.of(split[0]);
        this.amount = Integer.parseInt(split[1]);
    }

    private void validateExist(String input) {
        try {
            isExist(input);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(MENU_EXIST_ERROR.get());
        }
    }

    private void isExist(String input) {
        MenuItem.of(input).getMenuName().matches(input);
    }

    private void validateCountIsNumeric(String count) {
        if (!count.matches(ONLY_NUMERIC)) throw new IllegalArgumentException(MENU_COUNT_NUMERIC_ERROR.get());
    }

    private void validateMenuCount(String input) {
        int count = Integer.parseInt(input);
        if (count < 1) throw new IllegalArgumentException(MENU_COUNT_ERROR.get());
    }

    public boolean isBeverage() {
        return this.menu.getType().matches(BEVERAGE);
    }

    public String getMenuName() {
        return menu.getMenuName();
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return menu.getMenuName() + " " + amount + "개";
    }
}