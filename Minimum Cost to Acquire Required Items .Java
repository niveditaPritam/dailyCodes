class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long costA = (long) cost1 * need1 + (long) cost2 * need2;

        long costB = (long) costBoth * Math.max(need1, need2);

        long common = Math.min(need1, need2);

        long costC = (long) common * costBoth;

        if (need1 > need2) {
            costC += (long) (need1 - need2) * cost1;
        } else {
            costC += (long) (need2 - need1) * cost2;
        }

        return Math.min(costA, Math.min(costB, costC));
    }
}
