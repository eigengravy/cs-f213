public class App {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary(10);
        dict.put(new Record(3.5));
        System.out.println(dict.keys()[0]);
        System.out.println(dict.records()[0].getValue());
        System.out.println(dict.get(4));
        dict.remove(4);
        System.out.println(dict.get(4));
    }
}
