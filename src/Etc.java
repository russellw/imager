@SuppressWarnings("unused")
final class Etc {
  static String ext(String file) {
    var i = file.lastIndexOf('.');
    if (i < 0) return "";
    return file.substring(i + 1);
  }

  static void dbg(Object a) {
    System.out.printf("%s: %s\n", Thread.currentThread().getStackTrace()[2], a);
  }
}
