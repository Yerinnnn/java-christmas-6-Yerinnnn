package christmas;

import christmas.model.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class VisitDateTest {

    @DisplayName("1 이상 31 이하의 숫자가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "40", "-1"})
    void isRangeTest(String input) {
        assertThatThrownBy(() -> new VisitDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자 또는 특수문자, 띄어쓰기가 입력된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "4a0", "ㅇ1"})
    void isNumericTest(String input) {
        assertThatThrownBy(() -> new VisitDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
