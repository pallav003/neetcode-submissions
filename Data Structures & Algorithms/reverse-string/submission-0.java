class Solution {
    public void reverseString(char[] s) {
         reverse(0,s.length-1,s);
    }

    public static char[] reverse(int start, int end, char[] s) {
        while(start<=end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
        return s;
    }
}