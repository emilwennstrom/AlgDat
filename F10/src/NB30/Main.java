package NB30;

public class Main {
    public static void main(String[] args) {


        MinHeap<String> integerHeap = new MinHeap<>(10);

        integerHeap.insert("6");
        integerHeap.insert("1");
        integerHeap.insert("2");
        integerHeap.insert("3");
        integerHeap.insert("5");
        integerHeap.insert("4");
        integerHeap.insert("8");
        integerHeap.insert("0");
        integerHeap.insert("9");
        integerHeap.insert("3");
        integerHeap.insert("4");
        integerHeap.insert("8");
        integerHeap.insert("0");
        integerHeap.insert("9");
        integerHeap.insert("3");
        System.out.println(integerHeap);

        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println(integerHeap.extract());
        System.out.println();
        System.out.println(integerHeap);


    }
}