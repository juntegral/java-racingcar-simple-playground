import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> findWinners() {
        int highestPosition = getHighestPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addIfWinner(winners, car, highestPosition);
        }
        return winners;
    }

    private void addIfWinner(final List<Car> winners, final Car car, final int highestPosition) {
        if (car.isSamePosition(highestPosition)) {
            winners.add(car);
        }
    }

    private int getHighestPosition() {
        int highest = 0;
        for (Car car : cars) {
            highest = Math.max(highest, car.getPosition());
        }
        return highest;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll(final NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate()); // indent 1 유지
        }
    }
}