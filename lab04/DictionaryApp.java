import java.util.Scanner;

class DictionaryApp {
  public static void main(String args[]) {
    int size;
    int count;
    Scanner myScanner = new Scanner(System.in);

    System.out.print("Size of Dictionary: ");
    size = myScanner.nextInt();

    System.out.print("Count of entries: ");
    count = myScanner.nextInt();
    System.out.println("Reading " + count + " elements into a dictionary of size " + size);
    MyDictionary d = new MyDictionary(size);
    for (int i = 0; i < count; i++) {
      double nextValue;
      System.out.print("Enter element: ");
      nextValue = myScanner.nextDouble();
      d.put(new Record((Object) nextValue));
    }
    myScanner.close();
    d.show();

    Record keyRecord = new Record((Object) 632123.362251);
    keyRecord.show();
    System.out.println(d.getLength());
    System.out.print("Found");
    d.get(keyRecord).show();
    System.out.print("Removing");
    d.remove(keyRecord).show();
    System.out.println(d.getLength());
    Record newRecord = new Record((Object) 42);
    d.put(newRecord);
    d.get(newRecord).show();
    System.out.println(d.getLength());

  }
}
