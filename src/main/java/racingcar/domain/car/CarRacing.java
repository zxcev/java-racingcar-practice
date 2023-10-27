package racingcar.domain.car;

import racingcar.domain.car.dto.response.CarRacingDto;
import racingcar.domain.move.MoveCommand;

public final class CarRacing extends Car {

    public CarRacing(final String carName) {
        super(carName);
    }

    public void moveBy(final MoveCommand command) {
        if (MoveCommand.GO == command) {
            coordinate.increase();
        }
    }

    public CarFinished toFinished() {
        return new CarFinished(carName, coordinate);
    }

    public CarRacingDto toDto() {
        return new CarRacingDto(carName.carName(), coordinate.getCoordinate());
    }
}