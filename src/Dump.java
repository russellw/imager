import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import javax.imageio.ImageIO;

final class Dump {
  private static final Option[] OPTIONS = {};

  private static void dump(String file) throws IOException {
    switch (Etc.ext(file)) {
      case "png", "jpg", "jpeg" -> {
        var in = ImageIO.read(new File(file));
        System.out.printf("%s,%d,%d\n", file, in.getWidth(), in.getHeight());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Option.parse(OPTIONS, args);
    if (Option.positionalArgs.isEmpty()) Option.positionalArgs.add(".");
    for (var file : Option.positionalArgs) {
      var path = Path.of(file);
      if (Files.isDirectory(path)) {
        Files.walkFileTree(
            path,
            new SimpleFileVisitor<>() {
              public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                  throws IOException {
                dump(file.toString());
                return FileVisitResult.CONTINUE;
              }
            });
        continue;
      }
      if (file.endsWith(".lst")) {
        for (var s : Files.readAllLines(path, StandardCharsets.UTF_8)) dump(s);
        continue;
      }
      dump(file);
    }
  }
}
