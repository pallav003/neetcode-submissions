class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        int[] b = new int[26];
        if(s2.length() < s1.length()) return false;
        for(int i = 0; i< s1.length();i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        } 

        if(Arrays.equals(a,b)) return true;
        int left = 0;
        for(int i = s1.length(); i< s2.length();i++,left++) {
           b[s2.charAt(left)-'a']--;
           b[s2.charAt(i)-'a']++;

           if(Arrays.equals(a,b)) return true;
        }   

        
        return false;
    }
}
