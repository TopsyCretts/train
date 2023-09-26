package advanced;

public class EnumEx {
    //enums extend of Enum class
    //enums can implement
    //constructor can't be public or protected
    // we can't use enum as method local class

    public static void main(String[] args) {
        System.out.println(Level.BEGINNER);
        System.out.println(Level.INTERMEDIATE);

    }
}
enum Level{
    BEGINNER("blue"){
        @Override
        public String toString() {
            return "We can override methods for everyone value of enum";
        }
    }, INTERMEDIATE("red"), ADVANCED("black");
    String color;

    Level(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Level name is "+ name()+". Color is "+color;

    }
}
