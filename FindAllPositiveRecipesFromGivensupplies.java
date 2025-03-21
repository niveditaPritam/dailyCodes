import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> recipeIngredients = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; ++i) {
            for (String ingredient : ingredients.get(i)) {
                recipeIngredients.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }

        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Queue<String> q = new LinkedList<>(Arrays.asList(supplies));

        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            String ingredient = q.poll();

            for (String recipe : recipeIngredients.getOrDefault(ingredient, Collections.emptyList())) {
                if (inDegree.merge(recipe, -1, Integer::sum) == 0) {
                    result.add(recipe);
                    q.add(recipe);
                }
            }
        }
        return result;
    }
}
