package christmas.model;

public class Menu {
    MenuItem menu;
    int amount;

    public Menu(String input) {
        String[] split = input.split("-");
        this.menu = MenuItem.of(split[0]);
        this.amount = Integer.parseInt(split[1]);
    }

    public String getMenu() {
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