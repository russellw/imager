import java.io.File;
import java.io.IOException;
import javax.imageio.*;

final class ShrinkContents {
  private static double factor = 2.0;
  private static final Option[] OPTIONS =
      new Option[] {
        new Option("shrink factor", "amount", "f", "factor") {
          void accept(String arg) {
            factor = Double.parseDouble(arg);
          }
        },
      };

  public static void main(String[] args) throws IOException {
    var in = ImageIO.read(new File(Option.positionalArgs.get(0)));
  }
}
