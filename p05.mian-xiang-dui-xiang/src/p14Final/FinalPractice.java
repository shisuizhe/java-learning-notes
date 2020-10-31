package p14Final;

public class FinalPractice {
    public static void main(String[] args) {
        Something s = new Something();
        System.out.println(s.addOne1(1)); // 2

        Other o = new Other();
        System.out.println(o.i); // 0
        s.addOne2(o);
        System.out.println(o.i); // 1
    }
}

class Something {
    public int addOne1(final int x) {
        // return x++;      // 不可以
        return x + 1;
    }

    public void addOne2(final Other o) {
        // o = new Other(); // 不可以
        o.i++;
    }
}

class Other {
    public int i;
}