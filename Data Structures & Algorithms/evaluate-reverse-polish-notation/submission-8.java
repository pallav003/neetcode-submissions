class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if(token.equals("+")) {
              int first = stack.pop();
              int second = stack.pop();
              stack.push(first+second);
            }
            else if(token.equals("-")) {
                int first = stack.pop();
              int second = stack.pop();
              stack.push(second-first);
            }
            else if(token.equals("*")) {
                int first = stack.pop();
              int second = stack.pop();
              stack.push(first*second);
            }
            else if (token.equals("/")) {
                    int first = stack.pop();
              int second = stack.pop();
              if (first == 0 || second ==0) {
                stack.push(0);
              }
              else {
              stack.push(second/first);
              }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
            
        }
        return stack.pop();
    }
}
