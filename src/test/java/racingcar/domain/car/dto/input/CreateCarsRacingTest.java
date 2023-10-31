package racingcar.domain.car.dto.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.car.DuplicateCarNameException;
import racingcar.exception.car.NoCarsException;

final class CreateCarsRacingTest {

    @DisplayName("중복 없는 차 이름으로 CreateCars 생성 가능")
    @Test
    void CreateCarsRacing_withUniqueNames_shouldCreateInstance() {
        // given
        final String carName1 = "a";
        final String carName2 = "b";
        final String carName3 = "c";
        final List<String> carNames = List.of(carName1, carName2, carName3);

        // when
        final CreateCarsRacing createCarsRacing = new CreateCarsRacing(carNames);

        // then
        assertThat(createCarsRacing.carNames().size()).isEqualTo(3);
        assertThat(createCarsRacing.carNames().get(0)).isEqualTo(carName1);
        assertThat(createCarsRacing.carNames().get(1)).isEqualTo(carName2);
        assertThat(createCarsRacing.carNames().get(2)).isEqualTo(carName3);
    }

    @DisplayName("입력된 차 이름이 하나도 없으면 생성하면 예외 발생")
    @Test
    void CreateCarsRacing_withEmptyList_shouldThrowException() {
        // given
        final List<String> carNames = List.of();

        // when
        // then
        assertThatThrownBy(
                () -> new CreateCarsRacing(carNames)
        )
                .isInstanceOf(NoCarsException.class)
                .hasMessage(NoCarsException.NO_CARS_EXCEPTION_MESSAGE);
    }

    @DisplayName("중복된 이름을 가진 CreateCars를 생성하면 예외 발생")
    @Test
    void CreateCarsRacing_withDuplicateNames_shouldThrowException() {
        // given
        final String carName1 = "a";
        final String carName2 = "a";
        final String carName3 = "b";
        final List<String> carNames = List.of(carName1, carName2, carName3);

        // when
        // then
        assertThatThrownBy(
                () -> new CreateCarsRacing(carNames)
        )
                .isInstanceOf(DuplicateCarNameException.class)
                .hasMessage(DuplicateCarNameException.DUPLICATE_CAR_NAME_EXCEPTION_MESSAGE);
    }
}