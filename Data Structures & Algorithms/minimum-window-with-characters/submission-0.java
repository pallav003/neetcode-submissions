class Solution {
   public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int matched = 0;
        int start = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            if (freqMap.containsKey(c)
                    && freqMap.get(c) == windowFreq.get(c)) {
                matched++;
            }

            while (matched == freqMap.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (freqMap.containsKey(leftChar)
                        && windowFreq.get(leftChar) < freqMap.get(leftChar)) {
                    matched--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + minLen);
    }
}
