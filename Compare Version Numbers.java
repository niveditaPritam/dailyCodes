   String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        // Find the maximum length between both versions
        int n = Math.max(v1.length, v2.length);

        // Compare each revision
        for (int i = 0; i < n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }

        // All revisions are equal
        return 0;
