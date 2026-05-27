class Solution {
    public int lengthOfLongestSubstring(String s) {
  HashSet<Character> characterSet = new HashSet<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (characterSet.contains(s.charAt(right))) {
                characterSet.remove(s.charAt(left));
                left++;
            }
            characterSet.add(s.charAt(right));
            result = Math.max(result, right - left + 1);


        }
        return result;
    }
}
