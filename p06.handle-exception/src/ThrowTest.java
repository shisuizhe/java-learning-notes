public class ThrowTest {

    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.regist(-1001);
            System.out.println(s);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("错误：" + e.getMessage()); // 错误：不能输入负数！
        }
    }
}

class Student {
    private int id;

    public void regist(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            // 手动抛出异常对象
            // throw new RuntimeException("您输入的数据非法！");
            // throw new Exception("您输入的数据非法！");
            throw new MyException("不能输入负数！");
        }
    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }
}