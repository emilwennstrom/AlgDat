public class TestMain {

    public static void main(String[] args) {
        IntList ints = new IntList(10);

        for (int i = 0; i < 15; i++) {
            ints.add(i);
        }
        System.out.println(ints);
        System.out.println(ints.size()); // 15
        ints.add(0, -1);
        System.out.println(ints.size()); // 16
        ints.add(10, -2);   // 17
        //ints.add(19, -3); // ger outofbounds
        ints.add(17, -3);
        System.out.println(ints);
        System.out.println(ints.size()); // 18
        ints.add(0, -5); // 19
        System.out.println(ints);
        ints.add(0, -6); // 20
        System.out.println(ints);
        System.out.println(ints.size());
        ints.add(19, -7); // 21
        System.out.println(ints);
        System.out.println(ints.size());
        //ints.get(-1); oob
        System.out.println(ints.get(0));
        System.out.println(ints.get(20));
        //ints.get(21); oob
        System.out.println(ints.indexOf(-6) + ", " + ints.indexOf(5) +", "+ ints.indexOf(400)); // -1

        System.out.println(ints.remove(0) + ints.remove(19)); // 19

        ints.remove(18);
        System.out.println(ints);


        System.out.println(ints.set(0, 0) + " " + ints.set(17, 17));
        System.out.println(ints);
        System.out.println(ints.size());
        //ints.set(20, 1); oob
        ints.set(17, 1);
        System.out.println(ints);

    }

}
