package solutions.design;


// 3508: Implement Router

import java.util.*;

class Packet {
    int source;
    int dest;
    int timestamp;

    public Packet(int source, int dest, int timestamp) {
        this.source = source;
        this.dest = dest;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Packet p = (Packet) obj;
        return source == p.source && dest == p.dest && timestamp == p.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest, timestamp);
    }
}

public class Router {
    int memoryLimit = 0;
    Map<Packet, Integer> packetMap = new HashMap<>();
    Queue<Packet> packets = new LinkedList<>() {
    };

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (packetMap.containsKey(p)) {
            return false;
        } else {
            // memory limit excess
            if (packets.size() == memoryLimit) {
                packets.poll();
            }
            packets.offer(p);
            packetMap.put(p, 1);
            return true;
        }
    }

    public int[] forwardPacket() {
        // remove from storage
        Packet toForward = packets.poll();
        if (toForward == null) return new int[]{};
        packetMap.remove(toForward);
        return new int[]{toForward.source, toForward.dest, toForward.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        int packetCount = 0;
        for (Packet p: packets) {
           if (p.dest == destination && p.timestamp >= startTime && p.timestamp <= endTime) {
               packetCount++;
           }
        }
        return packetCount;
    }

    public static void main(String[] args) {
        Router r = new Router(2);
        r.addPacket(1,4,1);
        r.addPacket(5,4,1);
        r.addPacket(1,4,1);
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
