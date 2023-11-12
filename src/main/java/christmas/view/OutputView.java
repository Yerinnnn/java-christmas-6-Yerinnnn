package christmas.view;

public class OutputView {
    private final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String GET_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final String GET_ORDER_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final String BENEFIT_MESSAGE = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private final String ORDER_AMOUNT_MESSAGE= "<할인 전 총주문 금액>";
    private final String PRESENT_MENU_MESSAGE= "<증정 메뉴>";
    private final String DISCOUNT_RESULT_MESSAGE = "<혜택 내역>";
    private final String DISCOUNT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private final String PAYMENT_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private final String BADGE_MESSAGE = "<12월 이벤트 배지>";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void getVisitDateMessage() {
        System.out.println(GET_VISIT_DATE_MESSAGE);
    }

    public void getOrderMenuMessage() {
        System.out.println(GET_ORDER_MENU_MESSAGE);
    }

    public void printBenefitMessage() {
        System.out.println(BENEFIT_MESSAGE);
    }

    public void printOrderMenu() {
        System.out.println(ORDER_MENU_MESSAGE);
    }

    public void printTotalOrderAmount() {
        System.out.println(ORDER_AMOUNT_MESSAGE);
    }

    public void printPresentMenu() {
        System.out.println(PRESENT_MENU_MESSAGE);
    }

    public void printDiscountResult() {
        System.out.println(DISCOUNT_RESULT_MESSAGE);
    }

    public void printTotalDiscountAmount() {
        System.out.println(DISCOUNT_AMOUNT_MESSAGE);
    }

    public void printTotalPaymentAmount() {
        System.out.println(PAYMENT_AMOUNT_MESSAGE);
    }

    public void printBadge() {
        System.out.println(BADGE_MESSAGE);
    }

}
