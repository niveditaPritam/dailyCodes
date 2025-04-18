class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val); 
        preorderHelper(root.left, result); 
        preorderHelper(root.right, result);
        
    }
}
