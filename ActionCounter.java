package org.example;

import java.util.ArrayList;

public class ActionCounter {
    public ActionCounter(){
    }
    public void call(int timestamp){
        Counter.addCounter(new Counter(timestamp));
    }
    public int getActions(int timestamp){
        return Counter.getCounters(timestamp);
    }
    static class Counter{
        private static final ArrayList<Counter> list = new ArrayList<>();  
        private final int timestamp;
        public Counter(int timestamp) {
            this.timestamp = timestamp;
        }
        public static void addCounter(Counter counter){
            list.add(counter);
        }
        public static int getCounters(int timestamp){
            int count =0;
            for (Counter counter : list) {
                if (counter.timestamp <= timestamp && counter.timestamp > (timestamp - 300))
                    count++;
            }
            return count;
        }
    }
}
