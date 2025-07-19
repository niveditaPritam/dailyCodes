class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> lst = new ArrayList<>();
        Arrays.sort(folder);
        for (String s : folder) {
            if (lst.isEmpty() || !s.startsWith(lst.get(lst.size() - 1) + "/")) {
                lst.add(s);
            }
        }
        return lst;
    }
}
