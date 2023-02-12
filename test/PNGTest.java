import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

class PNGTest {
  public static void main(String[] args) throws IOException {
    var im = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
    var g2 = im.createGraphics();
    ImageIO.write(im, "png", new File("a.png"));
  }
}
