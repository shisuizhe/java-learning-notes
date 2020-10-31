package p07JiCheng.permission1;
/*
 * 体会4种不同的权限修饰
 *
 */
public class P1 {
    private int Private;
    int Default;
    protected int Protected;
    public int Public;

    private void methodPrivate(){
        Private = 1;
        Default = 2;
        Protected = 3;
        Public = 4;
    }
    void methodDefault(){
        Private = 1;
        Default = 2;
        Protected = 3;
        Public = 4;
    }
    protected void methodProtected(){
        Private = 1;
        Default = 2;
        Protected = 3;
        Public = 4;
    }

    public void methodPublic(){
        Private = 1;
        Default = 2;
        Protected = 3;
        Public = 4;
    }
}
