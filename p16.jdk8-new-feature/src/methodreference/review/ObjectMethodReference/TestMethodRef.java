package methodreference.review.ObjectMethodReference;

/*
    通过对象名引用成员方法  对象名::成员方法
    使用前提是对象名是已经存在的，成员方法也是已经存在
    就可以使用对象名来引用成员方法
 */
public class TestMethodRef {
    // 定义一个方法，方法的形参为 Printable 接口
    public static void printString(Printable p){
        p.print("hello world");
    }

    public static void main(String[] args) {
        // 调用 printString 方法，方法的参数 Printable 是一个函数式接口，所以可以传递 Lambda 表达式
        printString((str)->{
            //创建 Person 对象
            Person person = new Person();
            //调用 Person 对象中的成员方法 printUpperCaseString，把字符串按照大写输出
            person.printUpperCaseString(str); // HELLO WORLD
        });

        /*
            使用方法引用优化 Lambda
            对象是已经存在的 person
            成员方法也是已经存在的 printUpperCaseString
            所以我们可以使用对象名引用成员方法
         */
        // 创建 person 对象
        Person person = new Person();
        printString(person::printUpperCaseString); // HELLO WORLD
    }
}
