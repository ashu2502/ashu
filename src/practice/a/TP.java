package practice.a;

import java.util.Collections;
import java.util.List;

public class TP {
    public static void main(String[] args) {
        /*Queue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("Anu");
        stringQueue.add("bought");
        stringQueue.add("Apple");
        stringQueue.add("PineApple");
        stringQueue.add("Apple");
        stringQueue.remove("Apple");
        stringQueue.add("Orange");
        stringQueue.add("Mango");
        stringQueue.poll();
        System.out.println(stringQueue);*/
        System.out.print(false&&false||true);
    }

    static List getPage(int pageNum, int pageSize, List nums) {
        System.out.println("Printing Page "+ pageNum);
        if(pageNum*pageSize>nums.size()) {
            return Collections.EMPTY_LIST;
        }
        return (((pageNum+1)*pageSize<nums.size())?nums.subList(pageNum*pageSize, (pageNum+1)*pageSize):nums.subList(pageNum*pageSize, nums.size()));
    }


    private static long getRandom123DigitNumber() {
        return System.currentTimeMillis()%1000;
    }
}
