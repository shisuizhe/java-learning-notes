package p05TransferType;
/*
 *
 * 关于变量的赋值：
 *
 *  如果变量是基本数据类型，此时赋值的是变量所保存的数据值。
 *  如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值。
 *
 */
public class Trans1 {
    public static void main(String[] args) {
        System.out.println("***********基本数据类型：****************");
        int m = 10;
        int n = m;
        System.out.println("m = " + m + ", n = " + n); // m = 10, n = 10

        n = 20;
        System.out.println("m = " + m + ", n = " + n); // m = 10, n = 20

        System.out.println("***********引用数据类型：****************");
        Order o1 = new Order();
        o1.id = 100;

        Order o2 = o1; // 赋值以后，o1和o2的地址值相同，都指向了堆空间中同一个对象实体。
        System.out.println("o1.id = " + o1.id + ",o2.id = " +o2.id); // o1.id = 100,o2.id = 100

        o2.id = 200;
        System.out.println("o1.id = " + o1.id + ",o2.id = " +o2.id); // o1.id = 200,o2.id = 200

    }
}

class Order {
    int id;
}