private int rabinKarp(String source, String target) {
        int n = source.length();
        int m = target.length();
        if (m > n) return -1;
        long power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * BASE) % MOD;
        }
        long targetHash = 0;
        for (int i = 0; i < m; i++) {
            targetHash = (targetHash * BASE + target.charAt(i)) % MOD;
        }
        long windowHash = 0;
        for (int i = 0; i < n; i++) {
            windowHash = (windowHash * BASE + source.charAt(i)) % MOD;
            if (i < m - 1) continue;
            if (i >= m) {
                windowHash =
                    (windowHash - source.charAt(i - m) * power) % MOD;
                if (windowHash < 0) {
                    windowHash += MOD;
                }
            }
            if (windowHash == targetHash) {
                int start = i - m + 1;
                if (source.substring(start, start + m).equals(target)) {
                    return start;
                }
            }
        }
        return -1;
    }
