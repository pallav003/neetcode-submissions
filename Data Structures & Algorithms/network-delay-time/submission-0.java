class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] arr : times) {
    if (!map.containsKey(arr[0])) {
        map.put(arr[0], new ArrayList<>());
    }
    map.get(arr[0]).add(new int[]{arr[1], arr[2]});
}
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0,k});
        boolean[] visited = new boolean[n + 1];
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int distance = curr[0], source = curr[1];
            if (visited[source]) continue;
            visited[source] = true;

            if(map.containsKey(source)) {
                for(int[] edge : map.get(source)) {
                    int newSource = edge[0], newDistance = edge[1];
                    if (distance + newDistance < dist[newSource]){
                        dist[newSource] = distance + newDistance;
                        pq.offer(new int[] {dist[newSource],newSource});
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Unreachable node
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
