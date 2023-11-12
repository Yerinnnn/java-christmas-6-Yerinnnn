package christmas.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),
    T_BONE_STEAK("티본스테이크", 55_000),
    BARBCUE_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),
    CHOCOLATE_CALE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private static final Map<String, String> MENU_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(MenuItem::getMenuName, MenuItem::name))
    );

    String menuName;
    int price;

    MenuItem(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public static MenuItem of(final String menuName) {
        return MenuItem.valueOf(MENU_MAP.get(menuName));
    }
}
