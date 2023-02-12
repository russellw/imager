import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

final class Extend {
  private static int x, y;
  private static int width, height;
  private static final Option[] OPTIONS =
      new Option[] {
        new Option("x position of existing content", "pixels", "x") {
          void accept(String arg) {
            x = Integer.parseInt(arg);
          }
        },
        new Option("y position of existing content", "pixels", "y") {
          void accept(String arg) {
            y = Integer.parseInt(arg);
          }
        },
        new Option("width", "pixels", "w", "width") {
          void accept(String arg) {
            width = Integer.parseInt(arg);
          }
        },
        new Option("height", "pixels", "h", "height") {
          void accept(String arg) {
            height = Integer.parseInt(arg);
          }
        },
      };

  public static void main(String[] args) throws IOException {
    Option.parse(OPTIONS, args);
    var in = ImageIO.read(new File(Option.positionalArgs.get(0)));
    if (width == 0) width = in.getWidth();
    if (height == 0) height = in.getHeight();
    var out = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    var g2 = out.createGraphics();
    g2.setBackground(Color.WHITE);
    g2.clearRect(0, 0, width, height);
    g2.drawImage(in, x, y, null);
    ImageIO.write(out, "png", new File("a.png"));
  }
}
