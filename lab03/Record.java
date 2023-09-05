public class Record {
    private int key;
    private double value;

    Record(double value) {
        this.key = (int) Math.round(value);
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }
}