class Record extends AbstractRecord {
    private Object valueObject = 0;

    public Record(Object val) {
        valueObject = val;
    }

    public Object key() {
        if (value() instanceof Double) {
            return (Object) Math.round((double) value());
        } else {
            return value();
        }
    }

    public Object value() {
        return valueObject;
    }

    public Comparison compare(AbstractRecord another) {
        long k1 = (long) key(), k2 = (long) another.key();
        boolean b1 = k1 <= k2, b2 = k1 >= k2;
        if (b1 && b2)
            return Comparison.MATCHING;
        if (b1 && !b2)
            return Comparison.PREDECESSOR;
        if (!b1 && b2)
            return Comparison.SUCCESSOR;
        return Comparison.INCOMPARABLE;
    }

    public void show() {
        System.out.println(" [Key: " + key() + "] [Value: " + value() + "] ");
    }
}