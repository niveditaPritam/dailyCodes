class Solution {

    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);

        findMaxProduct(root);

        return (int)(maxProduct % MOD);
    }

    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    private long findMaxProduct(TreeNode node) {
        if (node == null) return 0;

        long left = findMaxProduct(node.left);
        long right = findMaxProduct(node.right);

        long subTreeSum = node.val + left + right;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
