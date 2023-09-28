package advanced.differentClasses;

public class StaticInnerClasses {
    //static inner class have access only to static fields in external class
    private static int i = 1;
    static int j = 2;
    int k = 3;

    static class Inner{
        public int getI(){ 
            return i;
        }
    }
    class Inner2 extends Inner{

    }

    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.getI();
    }
}
class OtherClass{
    public static void main(String[] args) {
        StaticInnerClasses staticInnerClasses = new StaticInnerClasses();
        StaticInnerClasses.Inner inner = staticInnerClasses.new Inner2();
    }
}
