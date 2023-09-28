package advanced.differentClasses;

public class LocalClasses {
    static int i =1;
    int j = 2;
    public static void main(String[] args) {

    }
    void method(int e){
        int k;
        class Local{ //hasn't modifiers
            int e = 1;
            int k =2;
            int i =3;
            int j = 4;
            private final static int m = 0;
        }
        Local local = new Local();

    }
    void method2(){
        class Local{
            //another class
        }
    }
}
