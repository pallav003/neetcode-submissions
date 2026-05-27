class Solution {
   public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int output = 0;
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                output++;
                dfs(i, adjacencyList, visited);
            }

        }
        return output;
    }

    private void dfs(int i, List<List<Integer>> adjacencyList, boolean[] visited) {
        visited[i] = true;
        for (int node : adjacencyList.get(i)) {
            if (visited[node]) continue;
            dfs(node, adjacencyList, visited);
        }
    }
}
