class LRUCache {
    private final LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity,0.75f,true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key,value);
        if(cache.size() > capacity) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
    }
}
