package practice.a;

import org.joda.time.DateTime;

public class DateTimeClass {

  public static void main(String[] args) {
    DateTime dateTime = new DateTime();
    System.out.println(dateTime);
    System.out.println(dateTime.getMillis());
  }

}
