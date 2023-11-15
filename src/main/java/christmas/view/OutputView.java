package christmas.view;

import christmas.model.OrderMenu;

public class OutputView {

    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String GET_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String GET_ORDER_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String BENEFIT_MESSAGE = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String ORDER_AMOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String WON = "원";
    private static final String PRESENT_MENU_MESSAGE = "<증정 메뉴>";
    private static final String PRESENT_ONE_CHAMPAGNE = "샴페인 1개";
    private static final String PRESENT_NOTHING = "없음";
    private static final String DISCOUNT_RESULT_MESSAGE = "<혜택 내역>";
    private static final String DISCOUNT_CHRISTMAS_DDAY = "크리스마스 디데이 할인: -";
    private static final String DISCOUNT_WEEKDAY = "평일 할인: -";
    private static final String DISCOUNT_WEEKEND = "주말 할인: -";
    private static final String DISCOUNT_SPECIALDAY = "특별 할인: -";
    private static final String DISCOUNT_PRESENT = "증정 이벤트: -25,000";
    private static final String DISCOUNT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String PAYMENT_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = "<12월 이벤트 배지>";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void getVisitDateMessage() {
        System.out.println(GET_VISIT_DATE_MESSAGE);
    }

    public void getOrderMenuMessage() {
        System.out.println(GET_ORDER_MENU_MESSAGE);
    }

    public void printBenefitMessage(String visitDate) {
        System.out.println(visitDate + BENEFIT_MESSAGE);
        System.out.println();
    }

    public void printOrderMenu(OrderMenu orderMenu) {
        System.out.println(ORDER_MENU_MESSAGE);
        System.out.println(orderMenu.toString());
    }

    public void printTotalOrderAmount(int totalOrderAmount) {
        System.out.println(ORDER_AMOUNT_MESSAGE);
        System.out.println(String.format("%,d", totalOrderAmount) + WON);
        System.out.println();
    }

    public void printPresentMenu(boolean service) {
        System.out.println(PRESENT_MENU_MESSAGE);
        if (service) {
            System.out.println(PRESENT_ONE_CHAMPAGNE);
        } else if (!(service)) {
            System.out.println(PRESENT_NOTHING);
        }
        System.out.println();
    }

    public void printDiscountResultMessage() {
        System.out.println(DISCOUNT_RESULT_MESSAGE);
    }

    public void printChristmasDiscount(int christmasDiscount) {
        System.out.println(DISCOUNT_CHRISTMAS_DDAY + String.format("%,d", christmasDiscount));
    }

    public void printWeekdayDiscount(int weekdayDiscount) {
        System.out.println(DISCOUNT_WEEKDAY + String.format("%,d", weekdayDiscount));
    }

    public void printWeekendDiscount(int weekendDiscount) {
        System.out.println(DISCOUNT_WEEKEND + String.format("%,d", weekendDiscount));
    }

    public void printSpecialDiscount(int specialDiscount) {
        System.out.println(DISCOUNT_SPECIALDAY + String.format("%,d", specialDiscount));
    }

    public void printPresentlDiscount() {
        System.out.println(DISCOUNT_PRESENT);
    }

    public void printTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println();
        System.out.println(DISCOUNT_AMOUNT_MESSAGE);
        System.out.println("-" + String.format("%,d", totalDiscountAmount));
        System.out.println();
    }

    public void printTotalPaymentAmount(int totalPaymentAmount) {
        System.out.println(PAYMENT_AMOUNT_MESSAGE);
        System.out.println(String.format("%,d", totalPaymentAmount) + WON);
        System.out.println();
    }

    public void printBadge(String badge) {
        System.out.println(BADGE_MESSAGE);
        System.out.println(badge);
    }

}