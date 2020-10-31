package p01Base;

public class StudentTest {

    public static void main(String[] args) {
        Student[] stus = new Student[20];
        for (int i = 0; i < stus.length; i++) {
            stus[i] = new Student();
            stus[i].number = i + 1;
            // 年级：[1,6]
            stus[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            // 成绩：[0,100]
            stus[i].score = (int) (Math.random() * (100 - 0 + 1));
        }

        StudentTest test = new StudentTest();
        // 遍历
        test.print(stus);
        System.out.println("---------------------");

        test.searchState(stus, 3);
        System.out.println("---------------------");

        test.sort(stus);

        test.print(stus);
    }

    public void print(Student[] stus) {
        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].info());
        }
    }

    public void searchState(Student[] stus, int state) {
        for (int i = 0; i < stus.length; i++) {
            if (stus[i].state == state) {
                System.out.println(stus[i].info());
            }
        }
    }

    public void sort(Student[] stus) {
        for (int i = 0; i < stus.length; i++) {
            for (int j = 0; j < stus.length - 1; j++) {
                if (stus[j].score > stus[j + 1].score) {
                    Student temp = stus[j];
                    stus[j] = stus[j + 1];
                    stus[j + 1] = temp;
                }
            }
        }
    }
}

class Student {
    int number; // 学号
    int state; // 年纪
    int score; // 成绩

    public String info() {
        return "学号：" + number + ",年级：" + state + ",成绩：" + score;
    }
}
