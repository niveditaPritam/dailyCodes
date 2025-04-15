class Solution {
    public int sumNumbers(TreeNode root) {
         return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currentSum;
        }

        return sumNumbersHelper(root.left, currentSum) + sumNumbersHelper(root.right, currentSum);
    }
}
        
