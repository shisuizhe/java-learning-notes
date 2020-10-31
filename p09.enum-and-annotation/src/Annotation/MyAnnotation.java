package Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Repeatable(MyAnnotations.class)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}

/*                      ********** 自定义Annotation **********
 *
 * 1.定义新的Annotation 类型使用@interface 关键字
 *
 * 2.自定义注解自动继承了java.lang.annotation.Annotation接口
 *
 * 3.Annotation 的成员变量在Annotation 定义中以无参数方法的形式来声明。其方法名和返回值定义了该成员的名字和类型。
 *   我们称为配置参数。类型只能是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、以上所有类型的数组。
 *
 * 4.可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始值可使用default 关键字
 *
 * 5.如果只有一个参数成员，建议使用参数名为 value
 *
 * 6.如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。格式是“参数名=参数值”，如果只有一个参数成员，
 *   且名称为value，可以省略“value=”
 *
 * 7.没有成员定义的Annotation 称为标记; 包含成员变量的Annotation 称为元数据Annotation
 *
 * 注意：自定义注解必须配上注解的信息处理流程才有意义。
 */

/*                  ********** JDK 中的元注解 **********
 *
 * @Retention: 只能用于修饰一个Annotation 定义, 用于指定该Annotation 的生命周期, @Rentention 包含
 *             一个RetentionPolicy 类型的成员变量, 使用@Rentention 时必须为该value 成员变量指定值，如下:
 *
 * 1.RetentionPolicy.SOURCE:  在源文件中有效（即源文件保留），编译器直接丢弃这种策略的注释。
 * 2.RetentionPolicy.CLASS:   在class文件中有效（即class保留），当运行Java 程序时, JVM不会保留注解。这是默认值
 * 3.RetentionPolicy.RUNTIME: 在运行时有效（即运行时保留），当运行Java 程序时, JVM 会保留注释。程序可以通过反射获取该注释。
 *
 *
 * @Target: 用于修饰Annotation 定义, 用于指定被修饰的Annotation 能用于修饰哪些程序元素。@Target 也包含一个名为value 的成员变量。
 *
 * 1.CONSTRUCTOR：    用于描述构造器
 * 2.FIELD:           用于描述域
 * 3.LOCAL_VARIABLE： 用于描述局部变量
 * 4.METHOD:          用于描述方法
 * 5.PACKAGE:         用于描述包
 * 6.PARAMETER:       用于描述参数
 * 7.TYPE：           用于描述类、接口（包括注解类型）或enum声明
 *
 *
 * @Documented: 用于指定被该元Annotation 修饰的Annotation 类将被javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
 *              定义为Documented的注解必须设置Retention值为RUNTIME。
 *
 *
 * @Inherited: 被它修饰的Annotation 将具有继承性。如果某个类使用了被 @Inherited 修饰的Annotation, 则其子类将自动具有该注解。
 *
 * 1.比如：如果把标有 @Inherited 注解的自定义的注解标注在类级别上，子类则可以继承父类类级别的注解
 * 2.实际应用中，使用较少
 *
 */
