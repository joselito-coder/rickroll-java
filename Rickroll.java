import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// Use the Mouse class as thread as this will disable the user from moving their mouse
class Mouse extends Thread {
    @Override
    public void run() {
        try {
            Robot robot = new Robot();
            while (true) {
                // TimeUnit.MILLISECONDS.sleep(100);
                robot.mouseMove(0, 0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Rickroll {
    // This is a function which will press the k key
    // The k key is used to play Youtube videos, as some of the browsers do not autoplay the video
    public static void pressK() {
        try {
            Robot kb = new Robot();
            kb.keyPress(KeyEvent.VK_K);
            TimeUnit.MILLISECONDS.sleep(400);
            kb.keyRelease(KeyEvent.VK_K);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                // Disable their mouse while watching
                Mouse m = new Mouse();
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                m.start();
                TimeUnit.SECONDS.sleep(20);
                pressK();
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=Tg4u7ko333U"));
                TimeUnit.SECONDS.sleep(40);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
