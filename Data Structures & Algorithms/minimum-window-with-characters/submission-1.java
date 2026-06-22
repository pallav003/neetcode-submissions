class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> targetMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            targetMap.merge(c,1,Integer::sum);
        }

        int left = 0;
        int right = 0;
        int matched = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        Map<Character,Integer> sourceMap = new HashMap<>();
        int size = targetMap.size();
        while(right<s.length()) {
            char currChar = s.charAt(right);
            sourceMap.merge(currChar,1, Integer::sum);
            if(targetMap.containsKey(currChar) && targetMap.get(currChar) == 
            sourceMap.get(currChar)) {
               matched++;
            }

            while(matched == size) {
               if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                sourceMap.merge(leftChar,-1, Integer::sum);
                if (targetMap.containsKey(leftChar) && sourceMap.get(leftChar)<
                targetMap.get(leftChar)) {
                    matched--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    }
}
