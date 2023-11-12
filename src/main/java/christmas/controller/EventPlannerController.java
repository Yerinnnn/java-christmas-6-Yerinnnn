package christmas.controller;

import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.service.Calculator;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    private final OutputView outputView;
    private final InputView inputView;
    private final EventService eventService;
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int PRESENT_DISCOUNT = 25000;

    private VisitDate visitDate;
    private OrderMenu orderMenu;
    private Calculator calculator;
    private int totalOrderAmount;
    private int christmasDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int totalDiscountAmount;

    public EventPlannerController(OutputView outputView, InputView inputView, Calculator calculator, EventService eventService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.calculator = calculator;
        this.eventService = eventService;
    }

    public void startEventPlanner() {
        startMessage();
        getVisitDateFromUser();
        getOrderMenuFromUser();
        outputView.printBenefitMessage(visitDate.toString());
        printOrderMenu();
        printTotalOrderAmount();
        printPresentMenu();
        outputView.printDiscountResultMessage();
        printDiscountResult();
        printTotalDiscountAmount();
        printTotalPaymentAmount();
        printBadge();
    }

    private void startMessage() {
        outputView.printStartMessage();
    }

    private void getVisitDateFromUser() {
        outputView.getVisitDateMessage();
        String input = inputView.getVisitDate();
        visitDate = new VisitDate(input);
    }

    private void getOrderMenuFromUser() {
        outputView.getOrderMenuMessage();
        String input = inputView.getOrderMenu();
        orderMenu = new OrderMenu(input);
    }

    private void printOrderMenu() {
        outputView.printOrderMenu(orderMenu);
    }

    private void printTotalOrderAmount() {
        totalOrderAmount = calculator.totalOrderAmount(orderMenu);
        outputView.printTotalOrderAmount(totalOrderAmount);
    }

    private void printPresentMenu() {
        outputView.printPresentMenu(eventService.presentMenu(totalOrderAmount));
    }

    private void printDiscountResult() {
        if (visitDate.isChristmasDday()) {
            christmasDiscount = calculator.christmasDdayDiscount(visitDate);
            outputView.printChristmasDiscount(christmasDiscount);
            totalDiscountAmount += christmasDiscount;

        }
        if (visitDate.isWeekday()) {
            weekdayDiscount = calculator.weekdayDiscount(orderMenu);
            outputView.printWeekdayDiscount(weekdayDiscount);
            totalDiscountAmount += weekdayDiscount;
        }
        if (visitDate.isWeekend()) {
            weekendDiscount = calculator.weekendDiscount(orderMenu);
            outputView.printWeekendDiscount(weekendDiscount);
            totalDiscountAmount += weekendDiscount;
        }
        if (visitDate.isSpecialDay()) {
            outputView.printSpecialDiscount(SPECIAL_DISCOUNT);
            totalDiscountAmount += SPECIAL_DISCOUNT;
        }
        if (eventService.presentMenu(totalOrderAmount)) {
            outputView.printPresentlDiscount();
            totalDiscountAmount += PRESENT_DISCOUNT;
        }
    }

    private void printTotalDiscountAmount() {
        outputView.printTotalDiscountAmount(totalDiscountAmount);
    }

    private void printTotalPaymentAmount() {
        int totalPaymentAmount = totalOrderAmount - totalDiscountAmount;
        outputView.printTotalPaymentAmount(totalPaymentAmount);
    }

    private void printBadge() {
        String badge = calculator.badgeEvent(totalDiscountAmount);
        outputView.printBadge(badge);
    }
}
