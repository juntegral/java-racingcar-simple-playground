import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        List<Car> carList = createCars(input.split(","));
        Cars cars = new Cars(carList);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        play(cars, tryCount);
        printFinalWinners(cars.findWinners());
    }

    private List<Car> createCars(String[] names) {
        List<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(name));
        }
        return list;
    }

    private void play(Cars cars, int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            moveAndPrint(cars);
        }
    }

    private void moveAndPrint(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(random.nextInt(10));
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printFinalWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}