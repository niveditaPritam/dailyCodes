class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] result = new long[n - k + 1];
        
        Map<Integer, Integer> freq = new HashMap<>();  
        TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();
        
        Runnable updateFreqMap = () -> {}; 
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int oldFreq = freq.getOrDefault(num, 0);
            int newFreq = oldFreq + 1;
            freq.put(num, newFreq);
            
            if (oldFreq > 0) {
                TreeSet<Integer> oldSet = freqMap.get(oldFreq);
                oldSet.remove(num);
                if (oldSet.isEmpty()) freqMap.remove(oldFreq);
            }
            freqMap.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(num);
            
            if (i >= k) {
                int left = nums[i - k];
                int oldF = freq.get(left);
                freq.put(left, oldF - 1);
                
                TreeSet<Integer> set = freqMap.get(oldF);
                set.remove(left);
                if (set.isEmpty()) freqMap.remove(oldF);
                
                if (oldF - 1 > 0)
                    freqMap.computeIfAbsent(oldF - 1, f -> new TreeSet<>()).add(left);
                else
                    freq.remove(left);
            }
            
            if (i >= k - 1) {
                int count = 0;
                long sum = 0;
                for (int freqKey : freqMap.descendingKeySet()) {
                    for (int val : freqMap.get(freqKey).descendingSet()) {
                        sum += (long) val * freqKey;
                        count++;
                        if (count == x) break;
                    }
                    if (count == x) break;
                }
                result[i - k + 1] = sum;
            }
        }
        return result;
    }
}
