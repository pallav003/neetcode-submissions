class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        for(;right<s.length();right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(right-left+1, maxLen);
            set.add(s.charAt(right));
        }

        return maxLen;
    }
}
