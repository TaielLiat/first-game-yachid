package intento200000000000;

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

public class Sonidos {

    private Map<String, byte[]> sonidos;

    public Sonidos() {
        this.sonidos = new HashMap<String, byte[]>();
    }

    public void agregarSonido(String nombre, String archivo) {
        try {
            byte[] fileContent = Files
                    .readAllBytes(Paths.get(Sonidos.class.getClassLoader().getResource(archivo).toURI()));
            sonidos.put(nombre, fileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void repetirSonido(String sonido) {
        tocarSonido(sonido, true);
    }

    public void tocarSonido(String sonido) {
        tocarSonido(sonido, false);
    }

    private void tocarSonido(String sonido, boolean repetir) {
        try {
            byte[] sonidoEnBytes = sonidos.get(sonido);
            InputStream myInputStream = new ByteArrayInputStream(sonidoEnBytes);
            AudioInputStream ais = AudioSystem.getAudioInputStream(myInputStream);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            if (repetir) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
