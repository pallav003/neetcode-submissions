class Solution {
    public int evalRPN(String[] tokens) {
    
        Stack<Integer>stack = new Stack<>();
        for (String s : tokens){
            if (s.equals("+") ||
            s.equals("-") ||
            s.equals("/") ||
            s.equals("*") ) {
                int a = stack.pop();
                int b = stack.pop();
                switch(s) {
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(b-a);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        if (b == 0) {
                            stack.push(0);
                        }
                        else {
                        stack.push(b/a);
                        }
                        break;            
                }                
            }
            else {
            stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
        
    }
}
