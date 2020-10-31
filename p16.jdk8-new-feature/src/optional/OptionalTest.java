package optional;

import org.junit.Test;

import java.util.Optional;

/*
 * Optional类：为了在程序中避免出现空指针异常而创建的。
 *
 * 常用的方法：ofNullable(T t)
 *            orElse(T t)
 */

public class OptionalTest {
    // Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
    // Optional.empty() : 创建一个空的 Optional 实例
    // Optional.ofNullable(T t)：t可以为null
    @Test
    public void test1() {
        Girl girl = new Girl();
        // girl = null;

        // of(T t): 保证t是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        // girl = null;

        // ofNullable(T t)：t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        // orElse(T t1) : 如果单前的Optional内部封装的t是非空的，则返回内部的t.
        // 如果内部的t是空的，则返回orElse()方法中的参数t1.
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    // **********************************************************************************************
    // 会出现空指针的getGirlName()：
    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy); // NullPointerException
        System.out.println(girlName);
    }



    // 优化以后的getGirlName():
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName); // null
    }



    // 使用Optional类的getGirlName():
    public String getGirlName2(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);

        // 此时的 boy1 一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);

        // 此时的 girl1 一定非空
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        return girl1.getName();
    }

    @Test
    public void test5() {
        Boy boy1 = null;
        String girlName1 = getGirlName2(boy1);
        System.out.println(girlName1); // 迪丽热巴

        Boy boy2 = new Boy();
        String girlName2 = getGirlName2(boy2);
        System.out.println(girlName2); // 古力娜扎

        Boy boy3 = new Boy(new Girl("苍老师"));
        String girlName3 = getGirlName2(boy3);
        System.out.println(girlName3); // 苍老师
    }
    // **********************************************************************************************
}
