import java.io.*;
import java.net.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class DeTag extends HTMLEditorKit.ParserCallback {
  StringBuffer txt;
  Reader reader;

  // empty default constructor
  public DeTag() {}

  // more convienient constructor
  public DeTag(Reader r) {
    setReader(r);
  }

  public void setReader(Reader r) { reader = r; }

  public void parse() throws IOException {
    txt = new StringBuffer();
    ParserDelegator parserDelegator = new ParserDelegator();
    parserDelegator.parse(reader, this, true);
  }

  public void handleText(char[] text, int pos) {
    txt.append(text);
  }

  public String toString() {
    return txt.toString();
  }

  public static void main (String[] argv) {
    try {
      // the HTML to convert
      URL toRead;
      if(argv.length==1)
        toRead = new URL(argv[0]);
      else
        toRead = new URL("http://p2p.wrox.com");

      BufferedReader in = new BufferedReader(
        new InputStreamReader(toRead.openStream()));
      DeTag d = new deTag(in);
      d.parse();
      in.close();
      System.out.println(d.toString());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
