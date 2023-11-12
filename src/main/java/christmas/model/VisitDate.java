package christmas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitDate {
    LocalDate date;

    public VisitDate(String input) {
        int visitDate = Integer.parseInt(input);
        this.date = LocalDate.of(2023, 12, visitDate);
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("M월 d일"));
    }
}
