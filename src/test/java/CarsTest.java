import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 단독 우승한다.")
    void 단독_우승자_찾기() {
        // given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        pobi.move(4);
        crong.move(3);

        Cars cars = new Cars(Arrays.asList(pobi, crong));

        // when
        List<Car> winners = cars.findWinners();

        // then: 포비 단독 우승 확인
        assertThat(winners).containsExactly(pobi);
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러 대일 경우 공동 우승한다.")
    void 공동_우승자_찾기() {
        // given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car loopy = new Car("loopy");

        pobi.move(4);
        crong.move(4);
        loopy.move(3);

        Cars cars = new Cars(Arrays.asList(pobi, crong, loopy));

        // when
        List<Car> winners = cars.findWinners();

        // then: 포비, 크롱 공동 우승 확인
        assertThat(winners).containsExactly(pobi, crong);
    }
}