class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() < -asteroid) {
                    // Top asteroid explodes
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}