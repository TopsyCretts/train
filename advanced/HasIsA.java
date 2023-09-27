package advanced;

public class HasIsA {
    public static void main(String[] args) {

    }
}
class Transport{

}
class Cart{
    int wheels =4;
}
class Car extends Transport{ //can't be extended of Cart because: extends -> is a --> Car IS A Transport
    int wheels = 4;
    Radio radio; // because Car HAS A Radio
}
class Radio{
    public void listen(){
    }
}