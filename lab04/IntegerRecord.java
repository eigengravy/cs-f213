
class IntegerRecord extends AbstractRecord {
  private Object valueObject = 0;

  public IntegerRecord(Object val) {
    valueObject = val;
  }

  public Object key() {
    return value();
  }

  public Object value() {
    return valueObject;
  }

  public Comparison compare(AbstractRecord another) {
    long k1 = (long) (int) key(), k2 = 0;
    if (another instanceof DoubleRecord) {
      k2 = (long) (another.key());
    } else if (another instanceof IntegerRecord) {
      k2 = (long) (int) another.key();
    }
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
