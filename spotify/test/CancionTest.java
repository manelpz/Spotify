import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CancionTest {

    @Test
    void testCambiarGenero() {

        // Arrange
        Cancion cancion = new Cancion(
            1, "Song 1", 180, 0,
            "Artista", "Album", "Rock"
        );

        // Act
        cancion.cambiarGenero("Pop");

        // Assert
        assertEquals("Pop", cancion.genero);
    }
}