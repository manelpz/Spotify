import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AudioTest {

    @Test
    void testReproducir() {

        // Arrange
        Audio audio = new Audio(1, "Song 1", 180, 0);

        // Act
        audio.reproducir();

        // Assert
        assertEquals(1, audio.reproducciones);
    }
}