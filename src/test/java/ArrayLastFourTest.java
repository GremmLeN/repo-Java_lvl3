import lesson6.lesson6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


public class ArrayLastFourTest {

    private lesson6 lesson6;

    @BeforeEach
    public void init() {
        lesson6 = new lesson6();
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test14 (int[] in, int[] out) {
        Assertions.assertArrayEquals(lesson6.afterLastFour(in), out);
    }
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 4,1,7},new int[] {1,7}),
                Arguments.of(new int[]{1, 4,4,7},new int[] {7}),
                Arguments.of(new int[]{1, 4},new int[0]));
    }
}