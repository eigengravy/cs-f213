abstract class AbstractRecord {
  abstract public Object key();

  abstract public Object value();

  abstract public Comparison compare(AbstractRecord another);

  abstract public void show();
}
