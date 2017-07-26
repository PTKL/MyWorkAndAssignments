import java.io.*;


public class MyFile {
  void writeOn() throws IOException
  {
    FileWriter output = null;
    try 
    {
      output = new FileWriter("test.txt");
      output.write("some text written on a file");
    }
    finally
    {
      if (output != null)
      {
        output.close();
      }
    }
  }
  
  void saveArray(String[] v, String filename) throws IOException
  {
    FileWriter output = null;
    try 
    {
      output = new FileWriter(filename);
      for (int i=0; i<v.length; i++)
      {
        output.write(v[i]);  
      }
    }
    finally
    {
      if (output != null)
      {
        output.close();
      }
    }
  }
  
  void readPrint() throws IOException
  {
    FileReader input = null;
    try
    {
      input = new FileReader("test.txt");
      int c;
      while ((c = input.read()) != -1)
      {
        System.out.print(c);
      } 
    }
    finally
    {
      if (input != null)
      {
        input.close();
      }
    }
  }
  
  String[] loadArray(String filename) throws IOException
  {
    FileReader input = null;
    String[] arr = null;
    BufferedReader buff = null;
    try
    {
      File f = new File (filename);
      input = new FileReader(filename);
      buff = new BufferedReader(input);
      
      
      arr = new String[(int) f.length()];
      String c;
      while ((c = buff.readLine()) != null)
      {
        for (int i=0; i<f.length(); i++)
        {
          arr[i] = c;
        }
      } 
    }
    finally
    {
      if (input != null)
      {
        input.close();
        buff.close();
      }
    }
    return arr;
  }
}
