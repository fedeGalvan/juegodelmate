package jueguito;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sonido {

    private Map<String, byte[]> sonidos;
    
    public Sonido() {
        this.sonidos = new HashMap<String, byte[]>();
    }

    public void setSound(String nombre, String archivo) {
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(Sonido.class.getClassLoader().getResource(archivo).toURI()));
            sonidos.put(nombre, fileContent);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar el archivo de sonido: " + archivo);
        }
    }

    
    public void tocarSonido(String sonido) {
        try {
            byte[] sonidoEnBytes = sonidos.get(sonido);
            InputStream myInputStream = new ByteArrayInputStream(sonidoEnBytes);
            AudioInputStream ais = AudioSystem.getAudioInputStream(myInputStream);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            clip.start();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}