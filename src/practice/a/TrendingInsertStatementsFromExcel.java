package practice.a;

import java.util.Scanner;

public class TrendingInsertStatementsFromExcel {
  static final String TRENDING_RESULT_QUERY_TEMPLATE = "\tINSERT INTO trending_query_result (ID,UUID,CUSTOMER_ID,USER_ID,QUERY_ID,RESULT_COUNT,CREATED,STATUS) "
	  + "VALUES(ID_TRENDING_QUERY_DETAIL.nextval,PORTAL_PCK.get_uuid(),462824,442854537,645565,%s,to_date('%s', 'MM/dd/yyyy hh24:mi:ss'),'SUCCESS');";
  public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNextLine()) {
	  String result = scanner.next();
	  String date = scanner.next();
	  date += " "+scanner.next();
	  System.out.println(String.format(TRENDING_RESULT_QUERY_TEMPLATE, result, date));
	}
  }
}
