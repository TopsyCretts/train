package advanced;

public class CohesionCoupling {
    public static void main(String[] args) {

    }
}
//cohesion - provides info about degree of relationship of methods for ex in class -> high cohesion
//coupling - provides info about degree of relationship of different modules for ex classes -> low coupling

//low cohesion example
class Restaurant{
    Worker worker;
}
class Worker{
    void cook(){

    }
    void clean(){

    }
    void delivery(){

    }
}
//high cohesion example
class Restaurant2{
    Cooker cooker;
    Cleaner cleaner;
    Deliver deliver;
}
class Cooker{
    void cook(){

    }
}
class Cleaner{
    void clean(){

    }
}
class Deliver{
    void delivery(){

    }
}

//high coupling

class A{
    int i;
}
class B{
    void method(){
        System.out.println(new A().i);
    }
}
// low coupling
class A2{
    private int i;

    public int getI() {
        return i;
    }
}
class B2{
    void method(){
        System.out.println(new A2().getI());
    }
}
