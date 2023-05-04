import java.util.*;
import java.io.*;

public class StringParsing {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Потрібен параметр виклика: ім'я файла");
      return;
    }
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(args[0]));
      String line = reader.readLine();
      while (line != null) {
        System.out.println("Введений рядок: " + line);
        StringTokenizer tokenizer = new StringTokenizer(line);
        System.out.print("Рядок складається з: ");
        while (tokenizer.hasMoreTokens()) {
          String token = tokenizer.nextToken();
          try {
            double num = Double.parseDouble(token);
            System.out.print(num + " - це число = " + num + ".0");
          } catch (NumberFormatException e) {
            System.out.print(token);
          }
          if (tokenizer.hasMoreTokens()) {
            System.out.print(", ");
          }
        }
        System.out.println();
        line = reader.readLine();
      }
    } catch (FileNotFoundException e) {
      System.out.println("Файл не знайдений");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
