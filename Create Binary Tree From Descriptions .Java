class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];
            
            map.putIfAbsent(parent, new TreeNode(parent));
            
            map.putIfAbsent(child, new TreeNode(child));
            
            if (isLeft == 1) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
            
            children.add(child);
        }
        
        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                return map.get(key);
            }
        }
        
        return null; // should not reach here
    }
}
