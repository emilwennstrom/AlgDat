package NB26;

import java.util.Iterator;

public class HashTableBucket<K, V> {

    private static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K k, V v){
            key = k;
            value = v;
        }
    }

    private SingleLinkedList<Entry<K, V>>[] table;
    private int numberOfEntries;

    @SuppressWarnings("unchecked")

    public HashTableBucket(int size) {
        table = new SingleLinkedList[size];
        numberOfEntries = 0;
    }


    public V put(K key, V value) {
        if (numberOfEntries > (table.length * 3) / 4) {
            reHash();
        }
        int index = getHashCode(key);
        if (table[index] == null) {                             // Om den platsen är null är den tom, då är det bara att lägga till inlägget.
            table[index] = new SingleLinkedList<>();            // en länkad lista skapas och läggs till på den platsen.
            table[index].add(new Entry<>(key, value));          // lägger till första inlägget i den länkade listan
        } else {                                                // Om platsen i arrayen inte är tom
            V oldValue;
            for (Entry<K, V> e : table[index]) {                // Gå igenom den länkade listan på den platsen
                if (e.key.equals(key)) {                        // Om samma värde ska läggas till i listan
                    oldValue = e.value;                         // Byt ut det mot det nya
                    e.value = value;
                    return oldValue;                            // returnera gamla värdet
                }
            }
            table[index].add(0, new Entry<>(key, value)); // Om inget värde matchar, lägg till först i listan.
        }
        numberOfEntries++;
        return null;
    }

    public V get(K key) {
        int index = getHashCode(key);
        if (table[index] != null) {
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getHashCode(key);
        if (table[index] != null) {
            Iterator<Entry<K, V>> itr = table[index].iterator();
            Entry<K, V> e;
            while (itr.hasNext()){
                e = itr.next();
                if (e.key == key) {
                    itr.remove();
                    numberOfEntries--;
                    return e.value;
                }
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append("ArrayIndex: ").append(i).append("\n");
                for (Entry<K, V> e : table[i]) {
                    sb.append("Key: ").append(e.key).append(", ");
                    sb.append("Value: ").append(e.value).append("\n");
                }
            }
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")

    private void reHash() {
        numberOfEntries = 0;
        SingleLinkedList<Entry<K, V>>[] temp = table;
        table = new SingleLinkedList[table.length * 2];
        for (SingleLinkedList<Entry<K, V>> entries : temp) {
            if (entries != null) {
                for (Entry<K, V> e : entries) {
                    put(e.key, e.value);
                }
            }
        }
    }

    public int getNumberOfEntries(){
        return numberOfEntries;
    }


    private int getHashCode(K key) {
        int index = key.hashCode() % table.length;          //Tar fram index från nyckelns hashcode. % längden på arrayen för att inte hamna utanför.
        if (index < 0) index += table.length;               // hashCode kan returnera ett negativt värde så om det är så adderas längden på tabellen
        return index;
    }



}
