package p06FengZhuang;
/*
* 最小的权限在类内部可以使用
* */
public class Permission {
    private int Private;   // private
    int Default;           // 缺省
    public int Public;     // public

    private void methodPrivate() {
        Private = 1;
        Default = 2;
        Public = 3;
    }

    void methodDefault() {
        Private = 1;
        Default = 2;
        Public = 3;
    }

    public void methodPublic() {
        Private = 1;
        Default = 2;
        Public = 3;
    }
}
