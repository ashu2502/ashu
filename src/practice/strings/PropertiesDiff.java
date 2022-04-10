package practice.strings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;

public class PropertiesDiff {

  public static void main(String[] args) {
    try {
      FileReader reader = new FileReader("C:\\Users\\athakur\\qualys\\qualys-platform_mine.properties");
      FileReader reader2 = new FileReader("C:\\Users\\athakur\\qualys\\qualys-platform.properties");

      Properties properties = new Properties();
      properties.load(reader);

      Properties properties2 = new Properties();
      properties2.load(reader2);

      SortedMap<String, String> myMap = new TreeMap(properties);
      SortedMap<String, String> newMap = new TreeMap(properties2);

      System.out.println("Displaying missing props");
      for(Entry<String, String> prop : newMap.entrySet()) {
        String propKey = prop.getKey();
        if(!myMap.containsKey(propKey)) {
          System.out.println(propKey + " : " + prop.getValue() + "\n");
        }
      }

      System.out.println("Displaying missing props on POD1");
      for(Entry<String, String> prop : myMap.entrySet()) {
        String propKey = prop.getKey();
        if(!newMap.containsKey(propKey)) {
          System.out.println(propKey + " : " + prop.getValue() + "\n");
        }
      }

      System.out.println("Displaying changed props");
      for(Entry<String, String> prop : newMap.entrySet()) {
        String propKey = prop.getKey();
        if(myMap.containsKey(propKey) && !myMap.get(propKey).equalsIgnoreCase(prop.getValue())) {
          System.out.println("Mine : " + propKey + " : " + myMap.get(propKey) + "\n");
          System.out.println("New : " + propKey + " : " + prop.getValue() + "\n");
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("IO exception");
    }
  }
}
