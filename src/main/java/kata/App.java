package kata;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

class App {

  public static void main(String[] args) throws IOException {
    Attributes stuff = new App().stuff();
    System.out.println(stuff.getValue("Main-Class"));
    System.out.println("Hello world");
  }

  public Attributes stuff() throws IOException {
    var inputStream = this.getClass().getResourceAsStream("/META-INF/MANIFEST.MF");
    var manifest = new Manifest(inputStream);
    return manifest.getMainAttributes();
  }
}
