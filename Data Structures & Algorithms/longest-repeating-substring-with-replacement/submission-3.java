class Solution {
    public int characterReplacement(String s, int k) {
     Map<Character,Integer> map = new HashMap<>();

     int left = 0, right = 0, maxlen = 0, maxFreq = 0;

     for(;right< s.length(); right++) {
        map.merge(s.charAt(right), 1, Integer::sum);
        maxFreq= Math.max(map.get(s.charAt(right)), maxFreq);
            while(right-left+1 - maxFreq > k) {
            map.merge(s.charAt(left), -1, Integer::sum);
            if(map.get(s.charAt(left)) == 0) {
                map.remove(s.charAt(left));
            }
            left++;
        }
        System.out.println(map + " "+ left);
        maxlen = Math.max(right-left+1, maxlen);
     }
     return maxlen;    
    }
}
