package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>();
        assertThat(numbers1).isEmpty();

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        var actual = App.take(numbers2, 2);
        assertThat(actual).isEqualTo(Arrays.asList(1, 2));

        var actual2 = App.take(numbers2, 8);
        assertThat(actual2).isEqualTo(Arrays.asList(1, 2, 3, 4));
        // END
    }
}
