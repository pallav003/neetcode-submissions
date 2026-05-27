class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int output = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        for (int right = 0; right < s.length();right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
            
            while(right-left+1 - maxFreq > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            output = Math.max(right-left+1,output);
        }
        return output;
    }
}
