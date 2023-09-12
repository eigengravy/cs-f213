class MyDictionary {
	public static void main(String args[]) {
		System.out.println(
				"The best way to use this type is to run another app main and instantiate a dictionary in it.");
	}

	private Record[] records;
	private int size = 0;
	private int count = 0;
	private Ordering ordering = Ordering.NONE;

	MyDictionary(int initialSize) {
		records = new Record[initialSize];
		size = initialSize;
		count = 0;
	}

	public Record get(Record keyRecord) {
		for (Record record : records) {
			if (record.compare(keyRecord) == Comparison.MATCHING)
				return record;
		}
		return null;
	}

	public void put(Record record) {
		if (size > count) {
			records[count++] = record;
		} else
			System.out.println("Size" + size + " not enough for holding an extra element after " + count + " count");
	}

	public Record remove(Record keyRecord) {
		Record removed = null;
		int index = 0;
		boolean found = false;
		for (Record record : records) {
			if (record.compare(keyRecord) == Comparison.MATCHING) {
				removed = record;
				found = true;
				break;
			}
			index++;
		}
		if (found) {
			for (int i = index; i < records.length - 1; i++)
				records[i] = records[i + 1];
			count = count - 1;
			return removed;
		} else
			return null;
	}

	public int getSize() {
		return size;
	}

	public int getLength() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == size;
	}

	public void show() {
		System.out.print("Printing Dictionary of " + size + " Size and " + count + " Occupancy:\n");
		for (int i = 0; i < count; i++) {
			System.out.print(i + " : ");
			records[i].show();
		}
		for (int i = count; i < size; i++) {
			System.out.print(i + " :#\n");
		}
		System.out.println("");
	}
}
