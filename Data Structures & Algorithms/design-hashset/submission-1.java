class MyHashSet {
    int size = 769;

    LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[size];
        for(int i  = 0; i<size;i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int index = hash(key);
        if(!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }
    
    public void remove(int key) {
         int index = hash(key);
        buckets[index].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */