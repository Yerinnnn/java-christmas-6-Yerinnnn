package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static christmas.message.ErrorMessage.*;

public class VisitDate {

    private static final String VISIT_DATE_FORMAT = "M월 d일";
    private static final LocalDate CHRISTMAS = LocalDate.of(2032, 12, 25);
    private static final String ONLY_NUMERIC = "\\d+";

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    LocalDate visitDate;
    int date;

    public VisitDate(String input) {
        validateEmpty(input);
        validateIsNumeric(input);
        validateRange(input);
        this.date = Integer.parseInt(input);
        this.visitDate = LocalDate.of(2023, 12, date);
    }

    private void validateEmpty(String input) {
        if (input.isEmpty() || input.matches(" ")) throw new IllegalArgumentException(VISIT_DATE_ERROR.get());
    }

    private void validateIsNumeric(String input) {
        if (!input.matches(ONLY_NUMERIC)) throw new IllegalArgumentException(VISIT_DATE_ERROR.get());
    }

    private void validateRange(String input) {
        int date = Integer.parseInt(input);
        if (date < MIN_DATE || date > MAX_DATE) throw new IllegalArgumentException(VISIT_DATE_ERROR.get());
    }

    public int getDate() {
        return date;
    }

    @Override
    public String toString() {
        return visitDate.format(DateTimeFormatter.ofPattern(VISIT_DATE_FORMAT));
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
