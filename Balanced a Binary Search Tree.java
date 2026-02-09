class Solution {

    List<Integer> inorder = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);

        return buildBalancedBST(0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    private TreeNode buildBalancedBST(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(inorder.get(mid));

        node.left = buildBalancedBST(left, mid - 1);
        node.right = buildBalancedBST(mid + 1, right);

        return node;
    }
}
