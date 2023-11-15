package christmas.message;

public enum OutputMessage {

    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    GET_VISIT_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    GET_ORDER_MENU_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    BENEFIT_MESSAGE("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_MESSAGE("<주문 메뉴>"),
    ORDER_AMOUNT_MESSAGE("<할인 전 총주문 금액>"),
    WON("원"),
    PRESENT_MENU_MESSAGE("<증정 메뉴>"),
    PRESENT_ONE_CHAMPAGNE("샴페인 1개"),
    PRESENT_NOTHING("없음"),
    DISCOUNT_RESULT_MESSAGE("<혜택 내역>"),
    DISCOUNT_CHRISTMAS_D_DAY("크리스마스 디데이 할인: -"),
    DISCOUNT_WEEKDAY("평일 할인: -"),
    DISCOUNT_WEEKEND("주말 할인: -"),
    DISCOUNT_SPECIAL_DAY("특별 할인: -"),
    DISCOUNT_PRESENT("증정 이벤트: -25,000"),
    DISCOUNT_AMOUNT_MESSAGE("<총혜택 금액>"),
    PAYMENT_AMOUNT_MESSAGE("<할인 후 예상 결제 금액>"),
    BADGE_MESSAGE("<12월 이벤트 배지>");

    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
