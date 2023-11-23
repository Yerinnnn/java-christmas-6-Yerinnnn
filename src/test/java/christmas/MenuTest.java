package christmas;

import christmas.model.Menu;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuTest {

    @DisplayName("고객이 메뉴판에 없는 메뉴를 입력하는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"로제파스타-1,펩시콜라-1,치즈케이크-2"})
    void isExistTest(String input) {
        assertThatThrownBy(() -> new OrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 숫자가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-a,티본스테이크-ㄷ,샴페인-%"})
    void isCountIsNumericTest(String input) {
        assertThatThrownBy(() -> new OrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 1 미만일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-0,티본스테이크-0,샴페인-0"})
    void menuCountTest(String input) {
        assertThatThrownBy(() -> new OrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 형식이 예시와 다른 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프- 2,티본스테이크+1,샴페인=3"})
    void orderFormatTest(String input) {
        assertThatThrownBy(() -> new OrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 메뉴를 입력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-2,양송이수프-1,샴페인-3"})
    void isSameMenuTest(String input) {
        assertThatThrownBy(() -> new OrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 메뉴의 갯수가 20개를 초과할 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-20,티본스테이크-1,샴페인-3"})
    void orderLimitTest(String input) {
        assertThatThrownBy(() -> new OrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문할 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"레드와인-1,샴페인-3"})
    void isOrderOnlyBeverageTest(String input) {
        assertThatThrownBy(() -> new OrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
