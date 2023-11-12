package christmas.controller;

import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {

    private final OutputView outputView;
    private final InputView inputView;

    VisitDate visitDate;
    OrderMenu orderMenu;

    public EventPlannerController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startEventPlanner() {
        startMessage();
        getVisitDateFromUser();
        getOrderMenuFromUser();
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
}
