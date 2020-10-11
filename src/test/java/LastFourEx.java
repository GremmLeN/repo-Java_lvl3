import lesson6.lesson6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LastFourEx {
    @Test
    public void lastFourEx() throws RuntimeException{
        int[] arr = {1, 1, 2, 3};
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            lesson6.afterLastFour(arr);
        });
        assertNotNull(thrown.getMessage());

    }
}