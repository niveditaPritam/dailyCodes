class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int prevDeviceCount = 0;

        for (String row : bank) {
            int currentDeviceCount = 0;

            for (char cell : row.toCharArray()) {
                currentDeviceCount += cell & 1;
            }

            if (currentDeviceCount > 0) {
                totalBeams += prevDeviceCount * currentDeviceCount;
                prevDeviceCount = currentDeviceCount;
            }
        }

        return totalBeams;    
    }
}
