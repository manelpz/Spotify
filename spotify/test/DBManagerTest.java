import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class DBManagerTest {

    @Test
    void testInsertarYObtenerAudio() throws Exception {

        // Arrange
        DBManager db = new DBManager();

        String titulo = "Test Song";
        int duracion = 200;

        // Act
        db.insertarAudio(titulo, duracion);

        List<Audio> lista = db.getAudios();

        // Assert
        boolean existe = false;

        for (Audio a : lista) {
            if (a.titulo.equals(titulo)) {
                existe = true;
                break;
            }
        }

        assertTrue(existe);
    }

    @Test
    void testReproducirAudio() throws Exception {

        // Arrange
        DBManager db = new DBManager();

        // Act
        db.insertarAudio("Song Repro", 100);

        List<Audio> lista = db.getAudios();
        Audio audio = lista.get(lista.size() - 1); 
        int antes = audio.reproducciones;
        db.reproducirAudio(audio.idAudio);
        List<Audio> lista2 = db.getAudios();

        Audio actualizado = lista2.stream()
            .filter(a -> a.idAudio == audio.idAudio)
            .findFirst()
            .get();

        // Assert
        assertEquals(antes + 1, actualizado.reproducciones);
    }
}