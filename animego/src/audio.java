import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class audio implements LineListener {

public boolean Playback_done;

    public audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    }

    @Override
    public void update(LineEvent event) {
        if (LineEvent.Type.START == event.getType()) {
            System.out.println("Playback started.");
        } else if (LineEvent.Type.STOP == event.getType()) {
            Playback_done = true;
            System.out.println("Playback completed.");
        }
    }
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("C:\\Users\\tkard\\Desktop\\java audio");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
    AudioFormat audioFormat = audioStream.getFormat();
    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);



}
