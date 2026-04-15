import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {


    public List<Audio> getAudios() throws Exception {

        List<Audio> lista = new ArrayList<>();

        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM audio";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Audio a = new Audio(
                rs.getInt("idAudio"),
                rs.getString("titulo"),
                rs.getInt("duracion"),
                rs.getInt("reproducciones")
            );
            lista.add(a);
        }

        return lista;
    }

  
    public void insertarAudio(String titulo, int duracion) throws Exception {
        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO audio (titulo, duracion, reproducciones) VALUES (?, ?, 0)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, titulo);
        ps.setInt(2, duracion);

        ps.executeUpdate();
    }

  
    public void reproducirAudio(int idAudio) throws Exception {
        Connection conn = DBConnection.getConnection();

        String sql = "UPDATE audio SET reproducciones = reproducciones + 1 WHERE idAudio = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, idAudio);

        ps.executeUpdate(   );
    }

    
    public void crearPlaylist(String nombre) throws Exception {
        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO playlist (nombre) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, nombre);

        ps.executeUpdate();
    }

   
    public void agregarAudioAPlaylist(int playlistId, int audioId) throws Exception {
        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO playlist_audio (playlist_id, audio_id) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, playlistId);
        ps.setInt(2, audioId);

        ps.executeUpdate(); 
    }

 
    public List<Audio> getAudiosDePlaylist(int playlistId) throws Exception {
        List<Audio> lista = new ArrayList<>();
        Connection conn = DBConnection.getConnection();

        String sql = "SELECT a.* FROM audio a " +
                    "INNER JOIN playlist_audio pa ON a.idAudio = pa.audio_id " +
                    "WHERE pa.playlist_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, playlistId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Audio a = new Audio(
                rs.getInt("idAudio"),
                rs.getString("titulo"),
                rs.getInt("duracion"),
                rs.getInt("reproducciones")
            );

            lista.add(a);
        }

        return lista;
    }
}
