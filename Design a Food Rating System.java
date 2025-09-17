public class FoodRatings {
    private static class Entry {
        String name;
        int rating;
        Entry(String n, int r) { 
            name = n; rating = r; 
        }
    }

    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, PriorityQueue<Entry>> cuisineToPQ = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String f = foods[i], c = cuisines[i];
            int r = ratings[i];
            foodToCuisine.put(f, c);
            foodToRating.put(f, r);
            cuisineToPQ.putIfAbsent(c, new PriorityQueue<>((a, b) -> {
                if (a.rating != b.rating) return b.rating - a.rating; 
                return a.name.compareTo(b.name);                     
            }));
            cuisineToPQ.get(c).add(new Entry(f, r));
        }
    }

    public void changeRating(String food, int newRating) {
        String c = foodToCuisine.get(food);
        foodToRating.put(food, newRating);               
        cuisineToPQ.get(c).add(new Entry(food, newRating)); 
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Entry> pq = cuisineToPQ.get(cuisine);
        while (!pq.isEmpty()) {
            Entry top = pq.peek();
            int current = foodToRating.get(top.name);
            if (current == top.rating) return top.name; 
            pq.poll(); 
        }
        return ""; 
    }
}
