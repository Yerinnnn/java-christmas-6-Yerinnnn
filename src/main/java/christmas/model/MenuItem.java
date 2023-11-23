package christmas.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6_000, "appetizer"),
    TAPAS("타파스", 5_500, "appetizer"),
    CAESAR_SALAD("시저샐러드", 8_000, "appetizer"),
    T_BONE_STEAK("티본스테이크", 55_000, "main"),
    BARBCUE_RIBS("바비큐립", 54_000, "main"),
    SEAFOOD_PASTA("해산물파스타", 35_000, "main"),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, "main"),
    CHOCOLATE_CALE("초코케이크", 15_000, "dessert"),
    ICE_CREAM("아이스크림", 5_000, "dessert"),
    ZERO_COKE("제로콜라", 3_000, "beverage"),
    RED_WINE("레드와인", 60_000, "beverage"),
    CHAMPAGNE("샴페인", 25_000, "beverage");

    private static final Map<String, String> MENU_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(MenuItem::getMenuName, MenuItem::name))
    );

    String menuName;
    int price;
    String type;

    MenuItem(String menuName, int price, String type) {
        this.menuName = menuName;
        this.price = price;
        this.type = type;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public static MenuItem of(final String menuName) {
        return MenuItem.valueOf(MENU_MAP.get(menuName));
    }
}
