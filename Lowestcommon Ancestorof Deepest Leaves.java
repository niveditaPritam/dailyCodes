class Solution {
    private TreeNode lcaDeepestLeaves;
    private int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = 0;

        lcaDeepestLeaves = null;
        findDeepest(root, 0);
        return lcaDeepestLeaves;
    }

    private int findDeepest(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int leftDepth = findDeepest(node.left, depth + 1);
        int rightDepth = findDeepest(node.right, depth + 1);

        int currentDepth = Math.max(leftDepth, rightDepth);

        if (currentDepth >= maxDepth) {
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
                lcaDeepestLeaves = node;
            } else if (leftDepth == maxDepth && rightDepth == maxDepth) {
                lcaDeepestLeaves = node;
            }
        }

        return currentDepth;
    }
}

        
    
