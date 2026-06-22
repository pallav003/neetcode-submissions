class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     PriorityQueue<Integer> pq = new PriorityQueue<>();

     for(int i = 0; i< arr.length; i ++) {
        int value = Math.abs(arr[i] -x);
        // System.out.println(pq);
        if(pq.size()==k) {
           if (value < Math.abs(pq.peek()-x)) {
            pq.poll();
            pq.add(arr[i]);
           }
        }
        else {
            pq.add(arr[i]);
        }
        
     }   

     List<Integer> out = new ArrayList<>();

     while(!pq.isEmpty()) {
        out.add(pq.poll());
     }
     return out;
    }
} 