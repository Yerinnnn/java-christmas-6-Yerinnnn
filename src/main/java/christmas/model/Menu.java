package christmas.model;

public class Menu {
    MenuItem menu;
    int amount;

    public Menu(String input) {
        String[] split = input.split("-");
        validate(split[0]);
        validateCountIsNumeric(split[1]);
        validateMenuCount(split[1]);
        this.menu = MenuItem.of(split[0]);
        this.amount = Integer.parseInt(split[1]);
    }

    private void validate(String input) {
//        System.out.println("input: " + input + ", MenuItem.of(input): " + MenuItem.of(input) + ", MenuItem.of(input).getMenuName(): " + MenuItem.of(input).getMenuName());
        try {
            MenuItem.of(input).getMenuName().matches(input);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateCountIsNumeric(String count) {
        if (!count.matches("\\d+")) throw new IllegalArgumentException("[ERROR] 메뉴의 개수를 숫자로 입력해 주세요.");
    }

    private void validateMenuCount(String input) {
        int count = Integer.parseInt(input);
        if (count < 1) throw new IllegalArgumentException("[ERROR] 메뉴의 개수를 1 이상 입력해 주세요.");
    }

    public MenuItem getMenu() {
        return menu;
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