package christmas.model;

public enum ErrorMessage {

    MENU_EXIST_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_COUNT_NUMERIC_ERROR("[ERROR] 메뉴의 개수를 숫자로 입력해 주세요."),
    MENU_COUNT_ERROR("[ERROR] 메뉴의 개수를 1 이상 입력해 주세요."),
    ORDER_FORMAT_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_DUPLICATION_ERROR("[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요."),
    ORDER_LIMIT_ERROR("[ERROR] 총 메뉴의 개수가 20개를 초과하였습니다. 20개 이하로 다시 입력해 주세요."),
    ORDER_ONLY_BEVERAGE_ERROR("[ERROR] 음료만은 주문할 수 없습니다. 다시 입력해 주세요."),

    VISIT_DATE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
