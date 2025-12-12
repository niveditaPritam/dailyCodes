class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        for (List<String> event : events) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(event.get(2));
                offlineUntil[id] = timestamp + 60;
            }
            else {
             String text = event.get(2);

                if (text.equals("ALL")) {
                    for (int u = 0; u < numberOfUsers; u++) {
                        mentions[u]++;
                    }
                }
                else if (text.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; u++) {
                        if (timestamp >= offlineUntil[u]) {
                            mentions[u]++;
                        }
                    }
                }
                else {
                    String[] parts = text.split(" ");
                    for (String p : parts) {
                        if (p.startsWith("id")) {
                            int id = Integer.parseInt(p.substring(2));
                            mentions[id]++;  
                        }
                    }
                }    
            }
        }

        return mentions;
    }
}
