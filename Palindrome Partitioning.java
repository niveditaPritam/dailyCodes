class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partitionHelper(String s, int start, List<String> currentList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                currentList.add(sub);
                partitionHelper(s, i + 1, currentList, result);
                currentList.remove(currentList.size() - 1); // Backtrack
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

        
