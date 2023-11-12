package christmas.controller;

import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.service.Calculator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {

    private final OutputView outputView;
    private final InputView inputView;
    private int totalOrderAmount;

    VisitDate visitDate;
    OrderMenu orderMenu;
    Calculator calculator;

    public EventPlannerController(OutputView outputView, InputView inputView, Calculator calculator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.calculator = calculator;
    }

    public void startEventPlanner() {
        startMessage();
        getVisitDateFromUser();
        getOrderMenuFromUser();
        outputView.printBenefitMessage(visitDate.toString());
        printOrderMenu();
        printTotalOrderAmount();
        printPresentMenu();
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
        String input = inputView.getVisitDate();
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
        if (totalOrderAmount >= 120000) {
            outputView.printPresentMenu(true);
        } else if (totalOrderAmount < 120000) {
            outputView.printPresentMenu(false);
        }
    }
}
