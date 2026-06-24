class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String s : operations) {
            if(s.equalsIgnoreCase("+")) {
                int top = stack.pop();
                int newTop = stack.peek() + top;
                stack.push(top);stack.push(newTop);
            }
            else if(s.equalsIgnoreCase("C")) {
                stack.pop();
            }
            else if(s.equalsIgnoreCase("D")) {
                int top = stack.peek() * 2;
                stack.push(top);
            }
            else{
            stack.push(Integer.parseInt(s));
            }
        }
        int out = 0;
        for(int i : stack) {
            out+=i;
        }   
        return out;
    }
}