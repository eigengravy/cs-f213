class DictionaryApp {
  // Provides only a main method for instantiating and demonstrating a dictionary
  public static void main(String args[]) {
    int size;
    int count;
    size = Integer.parseInt(args[0]);
    count = Integer.parseInt(args[1]);
    System.out.println("Reading " + count + " elements into a dictionary of size " + size);
    MyDictionary d = new MyDictionary(size);
    String[] elems = java.util.Arrays.copyOfRange(args, 2, args.length);
    for (int i = 0; i < count; i++) {
      d.Insert(Integer.parseInt(elems[i]));
    }
    d.Show();
    d.Sort();
    d.Show();
    System.out.println("Index of 5: " + d.Find(5));
    System.out.println("Index of 10: " + d.Find(10));
    d.Replace(5, 10);
    d.Show();
    System.out.println("Index of 10: " + d.Find(10));
    d.Remove(4);
    d.Show();
  }
}
