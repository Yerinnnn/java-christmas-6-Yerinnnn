package christmas;

import christmas.controller.EventPlannerController;
import christmas.service.Calculator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        EventPlannerController eventPlannerController = new EventPlannerController(
                new OutputView(),
                new InputView(),
                new Calculator()
        );
        eventPlannerController.startEventPlanner();
    }
}
