package solutions.design;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class HitCounter {
    private int total;
    private Deque<Pair<Integer, Integer>> hits;
    public HitCounter() {
        this.total = 0;
        this.hits = new LinkedList<Pair<Integer, Integer>>();
    }

    public void hit(int timestamp) {
        if (this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp) {
            // insert new timestamp with count = 1
            this.hits.add(new Pair<Integer, Integer>(timestamp, 1));
        } else {
            // update the count of latest timestamp by 1
            int prevCount = this.hits.getLast().getValue();
            this.hits.removeLast();
            this.hits.add(new Pair<Integer, Integer>(timestamp, prevCount + 1));
        }
        this.total++;

    }

    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.getFirst().getKey();
            if (diff >= 300) {
                // Decrement total by the count of the oldest timestamp
                this.total -= this.hits.getFirst().getValue();
                this.hits.removeFirst();
            }
            else break;
        }
        return this.total;
    }

    public static void main(String[] args) {
        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        System.out.println(obj.getHits(4));
        System.out.println(obj.getHits(4));
        obj.hit(300);
        System.out.println(obj.getHits(300));
        System.out.println(obj.getHits(301));
        System.out.println(obj.getHits(301));
    }
}