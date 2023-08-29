class MyDictionary {
  // Main Driver Method (optional in our modular design)
  public static void main(String args[]) {
    System.out.println("The best way to use this type is to run another app main and instantiate a dictionary in it.");
  }

  private int[] arr;
  private int size = 0;
  private int count = 0;

  public int Size() {
    return size;
  }

  public int Count() {
    return count;
  }

  MyDictionary(int initialSize) {
    arr = new int[initialSize];
    size = initialSize;
    count = 0;
  }

  public void Insert(int elem) {
    if (size > count) {
      int i;
      for (i = count; (i >= 0 && arr[i] > elem); i--) {
        arr[i + 1] = arr[i];
      }
      arr[i] = elem;
      count++;
    } else
      System.out.println("Size" + size + " not enough for holding an extra element after " + count + " count");
  }

  public void Remove(int elem) {
    int idx = Find(elem);
    if (idx == -1) {
      System.out.println("Element not found");
    } else {
      for (int i = idx + 1; i < count; i++) {
        arr[i - 1] = arr[i];
      }
      count--;
    }
  }

  public int Find(int elem) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (arr[middle] == elem)
        return middle;
      else if (arr[middle] < elem)
        left = middle + 1;
      else
        right = middle - 1;
    }
    return -1;
  }

  public void Replace(int a, int b) {
    int idx = Find(a);
    if (idx == -1) {
      System.out.println("Element " + a + " not found");
      return;
    }
    System.out.println("Replacing " + a + " with " + b);
    arr[idx] = b;
  }

  public void Sort() {
    for (int i = 0; i < count - 1; ++i) {
      for (int j = 0; j < count - i - 1; ++j) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    System.out.println("Sorting dictionary");
  }

  public void Show() {
    System.out.print("Printing Dictionary of " + size + " Size and " + count + " Occupancy:");
    for (int i = 0; i < count; i++) {
      System.out.print(" " + arr[i]);
    }
    for (int i = count; i < size; i++) {
      System.out.print(" .");
    }
    System.out.println("");
  }
}
