class Router {
    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            source = s; destination = d; timestamp = t;
        }
    }

    private Deque<Packet> queue; 
    private Set<String> seen;    
    private int size;            
    private Map<Integer, TreeMap<Integer, Integer>> destToPrefix; 

    public Router(int memoryLimit) {
        queue = new ArrayDeque<>();
        seen = new HashSet<>();
        size = memoryLimit;
        destToPrefix = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) return false;

        if (queue.size() == size) {
            Packet old = queue.pollFirst();
            seen.remove(old.source + "#" + old.destination + "#" + old.timestamp);
            updatePrefix(old.destination, old.timestamp, -1);
        }

        Packet p = new Packet(source, destination, timestamp);
        queue.offerLast(p);
        seen.add(key);
        updatePrefix(destination, timestamp, 1);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[] {};

        Packet p = queue.pollFirst();
        seen.remove(p.source + "#" + p.destination + "#" + p.timestamp);
        updatePrefix(p.destination, p.timestamp, -1);
        return new int[] { p.source, p.destination, p.timestamp };
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destToPrefix.containsKey(destination)) return 0;

        TreeMap<Integer, Integer> prefix = destToPrefix.get(destination);

        Map.Entry<Integer, Integer> endEntry = prefix.floorEntry(endTime);
        int endCount = (endEntry == null) ? 0 : endEntry.getValue();

        Map.Entry<Integer, Integer> startEntry = prefix.floorEntry(startTime - 1);
        int startCount = (startEntry == null) ? 0 : startEntry.getValue();

        return endCount - startCount;
    }

    private void updatePrefix(int dest, int time, int delta) {
        destToPrefix.putIfAbsent(dest, new TreeMap<>());
        TreeMap<Integer, Integer> prefix = destToPrefix.get(dest);

        int newCount = delta;
        Map.Entry<Integer, Integer> prev = prefix.floorEntry(time);
        if (prev != null) newCount += prev.getValue();

        prefix.put(time, newCount);

        NavigableMap<Integer, Integer> tail = prefix.tailMap(time, false);
        List<Integer> keys = new ArrayList<>(tail.keySet());
        for (int k : keys) {
            prefix.put(k, prefix.get(k) + delta);
        }
    }
}
