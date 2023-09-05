
public class Dictionary {
    private Record[] records;
    private int size;
    private int length;



    private Ordering ordering;

    Dictionary(int size) {
        this.size = size;
        this.ordering = Ordering.NONE;
        this.length = 0;
        this.records = new Record[size];
    }

    Dictionary(int size, Ordering ordering) {
        this.size = size;
        this.ordering = ordering;
        this.length = 0;
        this.records = new Record[size];
    }

    public Double get(int key) {
        for (int i = 0; i < length; i++) {
            if (records[i].getKey() == key) {
                return records[i].getValue();
            }
        }
        return null;
    }

    public Record put(Record record) {
        for (int idx = 0; idx < length; idx++) {
            if (records[idx].getKey() == record.getKey()) {
                Record replaced = records[idx];
                records[idx] = record;
                return replaced;
            }
        }
        if (!isFull()) {
            records[length++] = record;
        }
        return null;
    }

    public Record remove(int key) {
        for (int idx = 0; idx < length; idx++) {
            if (records[idx].getKey() == key) {
                Record removed = records[idx];
                for (int i = idx + 1; i < length; i++) {
                    records[i - 1] = records[i];
                }
                length--;
                return removed;
            }
        }
        return null;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == size;
    }

    public Record[] records() {
        return records;
    }

    public int[] keys() {
        int[] keys = new int[length];
        for (int idx = 0; idx < length; idx++) {
            keys[idx] = records[idx].getKey();
        }
        return keys;
    }
}
