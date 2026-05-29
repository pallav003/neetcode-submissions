
class MyHashMap {
    class Data {
        Integer key;
        Integer value;
        public Data(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    LinkedList<Data>[] buckets;
    int size=769;
    public MyHashMap() {
        buckets = new LinkedList[size];
        for(int i = 0; i< size;i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public int hash(int key) {
        return key%size;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        for(Data d : buckets[index]) {
            if (d.key == key) {
                d.value = value;
                return;
            }
        }
        buckets[index].add(new Data(key,value));

    }
    
    public int get(int key) {
        int index = hash(key);
        for(Data d : buckets[index]) {
            if (d.key == key) {
                return d.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);

    Iterator<Data> itr = buckets[index].iterator();

    while (itr.hasNext()) {
        if (itr.next().key == key) {
            itr.remove();
            return;
        }
    }   
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */