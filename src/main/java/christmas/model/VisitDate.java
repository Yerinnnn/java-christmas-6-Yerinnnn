package christmas.model;

import java.time.LocalDate;

public class VisitDate {
    LocalDate date;

    public VisitDate(String input) {
        int visitDate = Integer.parseInt(input);
        this.date = LocalDate.of(2023, 12, visitDate);
        System.out.println(this.date);
    }
}
