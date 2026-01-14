class Solution {

    static class Event {
        double x;
        double y1, y2;
        int type; 

        Event(double x, double y1, double y2, int type) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        for (int i = 0; i < 60; i++) { 
            double mid = (low + high) / 2;
            double below = area(squares, mid, true);
            double above = area(squares, mid, false);

            if (below < above) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private double area(int[][] squares, double y, boolean below) {
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            double x1 = s[0];
            double x2 = s[0] + s[2];
            double y1 = s[1];
            double y2 = s[1] + s[2];

            if (below) {
                if (y1 >= y) continue;
                double top = Math.min(y, y2);
                events.add(new Event(x1, y1, top, +1));
                events.add(new Event(x2, y1, top, -1));
            } else {
                if (y2 <= y) continue;
                double bottom = Math.max(y, y1);
                events.add(new Event(x1, bottom, y2, +1));
                events.add(new Event(x2, bottom, y2, -1));
            }
        }

        events.sort(Comparator.comparingDouble(e -> e.x));

        TreeMap<Double, Integer> map = new TreeMap<>();
        double prevX = 0, res = 0;

        for (Event e : events) {
            double curX = e.x;
            res += (curX - prevX) * coveredY(map);
            map.put(e.y1, map.getOrDefault(e.y1, 0) + e.type);
            map.put(e.y2, map.getOrDefault(e.y2, 0) - e.type);
            prevX = curX;
        }
        return res;
    }

    private double coveredY(TreeMap<Double, Integer> map) {
        double total = 0;
        int count = 0;
        double prev = 0;

        for (Map.Entry<Double, Integer> e : map.entrySet()) {
            double y = e.getKey();
            if (count > 0) {
                total += y - prev;
            }
            count += e.getValue();
            prev = y;
        }
        return total;
    }
}
