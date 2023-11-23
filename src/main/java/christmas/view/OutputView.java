package christmas.view;

import christmas.model.OrderMenu;

import static christmas.message.OutputMessage.*;

public class OutputView {

    private static final String WON_FORMAT = "%,d";

    public void printStartMessage() {
        System.out.println(START_MESSAGE.get());
    }

    public void getVisitDateMessage() {
        System.out.println(GET_VISIT_DATE_MESSAGE.get());
    }

    public void getOrderMenuMessage() {
        System.out.println(GET_ORDER_MENU_MESSAGE.get());
    }

    public void printBenefitMessage(String visitDate) {
        System.out.println(visitDate + BENEFIT_MESSAGE.get());
        System.out.println();
    }

    public void printOrderMenu(OrderMenu orderMenu) {
        System.out.println(ORDER_MENU_MESSAGE.get());
        System.out.println(orderMenu.toString());
    }

    public void printTotalOrderAmount(int totalOrderAmount) {
        System.out.println(ORDER_AMOUNT_MESSAGE.get());
        System.out.println(formatResult(totalOrderAmount) + WON.get());
        System.out.println();
    }

    public void printPresentMenu(boolean service) {
        System.out.println(PRESENT_MENU_MESSAGE.get());
        if (service) {
            System.out.println(PRESENT_ONE_CHAMPAGNE.get());
        } else if (!(service)) {
            System.out.println(PRESENT_NOTHING.get());
        }
        System.out.println();
    }

    public void printDiscountResultMessage() {
        System.out.println(DISCOUNT_RESULT_MESSAGE.get());
    }

    public void printChristmasDiscount(int christmasDiscount) {
        System.out.println(DISCOUNT_CHRISTMAS_D_DAY.get() + formatResult(christmasDiscount));
    }

    public void printWeekdayDiscount(int weekdayDiscount) {
        System.out.println(DISCOUNT_WEEKDAY.get() + formatResult(weekdayDiscount));
    }

    public void printWeekendDiscount(int weekendDiscount) {
        System.out.println(DISCOUNT_WEEKEND.get() + formatResult(weekendDiscount));
    }

    public void printSpecialDiscount(int specialDiscount) {
        System.out.println(DISCOUNT_SPECIAL_DAY.get() + formatResult(specialDiscount));
    }

    public void printPresentlDiscount() {
        System.out.println(DISCOUNT_PRESENT.get());
    }

    public void printTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println();
        System.out.println(DISCOUNT_AMOUNT_MESSAGE.get());
        System.out.println(formatResult(totalDiscountAmount) + WON.get());
        System.out.println();
    }

    public void printTotalPaymentAmount(int totalPaymentAmount) {
        System.out.println(PAYMENT_AMOUNT_MESSAGE.get());
        System.out.println(formatResult(totalPaymentAmount) + WON.get());
        System.out.println();
    }

    public void printBadge(String badge) {
        System.out.println(BADGE_MESSAGE.get());
        System.out.println(badge);
    }

    private String formatResult(int input) {
        return String.format(WON_FORMAT, input);
    }
}