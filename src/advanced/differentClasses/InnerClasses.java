package advanced.differentClasses;

public class InnerClasses {
    private int i = 5;
    static int j = 6;
    public static void main(String[] args) {
        Inner inner = new InnerClasses(). new Inner();
        System.out.println(inner.newJ);
    }
    class Inner{
        int newI = i+1;
        int newJ = j+1;
        void method(){
            newJ=newJ+newI;
        }
        // we can't make new static fields, but we can create only final static fields without using elder fields

    }
}
class OtherClass2{
    public static void main(String[] args) {
        InnerClasses.Inner inner = new InnerClasses().new Inner();

    }
}
