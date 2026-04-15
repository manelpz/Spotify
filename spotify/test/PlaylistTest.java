import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void testAgregarAudio() {

        //Arrange
        Playlist playlist = new Playlist(1, "Rock");
        Audio audio = new Audio(1, "Song 1", 180, 0);

        //Act
        playlist.agregarAudio(audio);

        //Assert
        assertEquals(1, playlist.audios.size());
        assertEquals("Song 1", playlist.audios.get(0).titulo);
    }
}
