package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitDate {
    LocalDate visitDate;
    int date;
    private static final LocalDate CHRISTMAS = LocalDate.of(2032, 12, 25);

    public VisitDate(String input) {
        this.date = Integer.parseInt(input);
        this.visitDate = LocalDate.of(2023, 12, date);
    }

    public int getDate() {
        return date;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return visitDate.format(DateTimeFormatter.ofPattern("M월 d일"));
    }

    public boolean isChristmasDday() {
        return this.visitDate.isAfter(LocalDate.of(2023, 12, 1)) && this.visitDate.isBefore(LocalDate.of(2023, 12, 26));
    }

    public boolean isWeekday() {
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public boolean isSpecialDay() {
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY || visitDate.isEqual(CHRISTMAS);
    }
}
