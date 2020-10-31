package p13DaiMaKuai;

// 总结：由父及子，静态先行
public class CodeExecOrder {
    public static void main(String[] args) {
        new Leaf();
        /*
         * Root的静态初始化块
         * Mid的静态初始化块
         * Leaf的静态初始化块
         * Root的普通初始化块
         * Root的无参数的构造器
         * Mid的普通初始化块
         * Mid的无参数的构造器
         * Mid的带参数构造器，其参数值：尚硅谷
         * Leaf的普通初始化块
         * Leaf的构造器
         */
    }
}

class Root {
    static {
        System.out.println("Root的静态初始化块");
    }

    {
        System.out.println("Root的普通初始化块");
    }

    public Root() {
        // super(); // 如果不显示指定会默认自带 super()
        System.out.println("Root的无参数的构造器");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid的静态初始化块");
    }

    {
        System.out.println("Mid的普通初始化块");
    }

    public Mid() {
        // super();
        System.out.println("Mid的无参数的构造器");
    }

    public Mid(String msg) {
        // 通过this调用同一类中重载的构造器
        this();
        System.out.println("Mid的带参数构造器，其参数值：" + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf的静态初始化块");
    }

    {
        System.out.println("Leaf的普通初始化块");
    }

    public Leaf() {
        // 通过super调用父类中有一个字符串参数的构造器
        super("尚硅谷");
        System.out.println("Leaf的构造器");
    }
}


// ------------------------------------------------------------

class Father {
    static {
        System.out.println("11111111111");
    }

    {
        System.out.println("22222222222");
    }

    public Father() {
        System.out.println("33333333333");

    }

}

class Son extends Father {
    static {
        System.out.println("44444444444");
    }

    {
        System.out.println("55555555555");
    }

    public Son() {
        System.out.println("66666666666");
    }

    public static void main(String[] args) {
        System.out.println("77777777777");
        System.out.println();
        new Son();
        System.out.println();
        new Son();
        System.out.println();
        new Father();
        /*
         * 11111111111
         * 44444444444
         * 77777777777
         *
         * 22222222222
         * 33333333333
         * 55555555555
         * 66666666666
         *
         * 22222222222
         * 33333333333
         * 55555555555
         * 66666666666
         *
         * 22222222222
         * 33333333333
         *
         */
    }

}
