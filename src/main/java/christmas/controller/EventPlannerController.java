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
    private final Calculator calculator;
    private int totalOrderAmount;
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
        try {
            outputView.getVisitDateMessage();
            String input = inputView.getVisitDate();
            visitDate = new VisitDate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getVisitDateFromUser();
        }
    }

    private void getOrderMenuFromUser() {
        try {
            outputView.getOrderMenuMessage();
            String input = inputView.getOrderMenu();
            orderMenu = new OrderMenu(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getOrderMenuFromUser();
        }
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
        if (totalOrderAmount >= 10000) {
            christmasDdayDiscount();
            weekdayDiscount();
            weekendDiscount();
            specialDayDiscount();
            presentMenuDiscount();
        } else if (totalOrderAmount < 10000) {
            System.out.println("없음");
        }
    }

    private void christmasDdayDiscount() {
        if (visitDate.isChristmasDday()) {
            int christmasDiscount = calculator.christmasDdayDiscount(visitDate);
            outputView.printChristmasDiscount(christmasDiscount);
            totalDiscountAmount += christmasDiscount;
        }
    }

    private void weekdayDiscount() {
        if (visitDate.isWeekday()) {
            int weekdayDiscount = calculator.weekdayDiscount(orderMenu);
            outputView.printWeekdayDiscount(weekdayDiscount);
            totalDiscountAmount += weekdayDiscount;
        }
    }

    private void weekendDiscount() {
        if (visitDate.isWeekend()) {
            int weekendDiscount = calculator.weekendDiscount(orderMenu);
            outputView.printWeekendDiscount(weekendDiscount);
            totalDiscountAmount += weekendDiscount;
        }
    }

    private void specialDayDiscount() {
        if (visitDate.isSpecialDay()) {
            outputView.printSpecialDiscount(SPECIAL_DISCOUNT);
            totalDiscountAmount += SPECIAL_DISCOUNT;
        }
    }

    private void presentMenuDiscount() {
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
