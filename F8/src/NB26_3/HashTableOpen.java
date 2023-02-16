package NB26_3;

public class HashTableOpen<K, V> {

    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Entry<K, V>[] entries;
    private int size;

    private final Entry<K, V> DELETED;

    @SuppressWarnings("unchecked")
    public HashTableOpen (int initValue) {
        if (!isPrime(initValue)) {
            initValue = getNextPrime(initValue);
        }
        entries = new Entry[initValue];
        size = 0;
        DELETED = new Entry<>(null, null);
    }
    public HashTableOpen () {
        this(13);
    }
    public V put(K key, V value) {
        int index = getIndex(key);
        return put(key, value, index, 2);
    }
    private V put(K key, V value, int index, int k) {
        if (entries[index] == null && entries[index] != DELETED) {
            entries[index] = new Entry<>(key, value);
            size++;
        } else {
            if (key.equals(entries[index].key)) {
                V oldValue = entries[index].value;
                entries[index].value = value;
                return oldValue;
            } else {
                index = (index + k) % entries.length;
                return put(key, value, index, k + 2);
            }
        }
        if (size > entries.length / 2) {
            reHash();
        }
        return null;
    }
    public V remove(K key) {
        int index = getIndex(key);
        int k = 2;
        return remove(key, index, k);
    }

    private V remove(K key, int index, int k) {
        if (entries[index] == null) {
            return null;
        }
        if (key.equals(entries[index].key)) {
            V returnValue = entries[index].value;
            entries[index] = DELETED;
            return returnValue;
        }
        index = (index + k) % entries.length;
        return remove(key, index,k + 2);
    }
    public V get(K key) {
        int index = getIndex(key);
        return get(key, index, 2);
    }

    private V get(K key, int index, int k) {
        if (entries[index] == null || entries[index] == DELETED) {
            return null;
        }
        if (key.equals(entries[index].key)) {
            return entries[index].value;
        }
        index = (index + k) % entries.length;
        return get(key, index, k + 2);
    }

    @SuppressWarnings("unchecked")
    private void reHash() {
        size = 0;
        Entry<K, V>[] temp = entries;
        int newSize = getNextPrime(2 * entries.length);
        entries = new Entry[newSize];
        for (Entry<K, V> e : temp) {
            if (e != DELETED && e != null) {
                put(e.key, e.value);
            }
        }
    }
    private int getIndex(K key) {
        int index = key.hashCode() % entries.length;
        if (index < 0) index += entries.length;
        return index;
    }
    private boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    private  int getNextPrime(int number) {
        for (int i = number + 1; ; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entries.length; i++) {
           if (entries[i] != null && entries[i] != DELETED) {                // modifiera && entries[i] != DELETED beroende på om dummies ska med eller inte
               sb.append("array position: ").append(i).append(" ::: ");
               sb.append("key: ").append(entries[i].key).append(", ");
               sb.append("value: ").append(entries[i].value).append("\n");
           }
        }
        sb.append("number of entries: ").append(size).append("\n");
        sb.append("array Length: ").append(entries.length);
        return sb.toString();
    }
}
