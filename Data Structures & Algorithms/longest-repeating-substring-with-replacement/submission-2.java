class Solution {
    public int characterReplacement(String s, int k) {
     int left = 0;
     int max = 0;
     int output=0;
     Map<Character,Integer> map = new HashMap<>();
     for(int right = 0; right<s.length();right++) {
        char currChar = s.charAt(right);
        map.put(currChar,
         map.getOrDefault(currChar, 0) + 1);
        max = Math.max(max, map.get(currChar));

        while(right-left+1 - max > k) {
            map.put(s.charAt(left),map.get(s.charAt(left)) - 1);
            left++;
        }
        output = Math.max(right-left+1, output);
     }
     return output;

    }
}
