package differents.equals;

public class Ex {
    public static void main(String[] args) {
        Book book1 = new Book("One");
        Book book2 = new Book("One");
        Book book3 = new Book("One");


        System.out.println("reflexion -> always true");
        System.out.println(book1.equals(book1));
        System.out.println(book2.equals(book2));
        System.out.println();


        System.out.println("symmetric -> same true or same false");
        System.out.println(book1.equals(book2));
        System.out.println(book2.equals(book1));
        System.out.println();


        System.out.println("transitive -> if 1==2 and 2==3 then 1==3");
        System.out.println(book1.equals(book2));
        System.out.println(book2.equals(book3));
        System.out.println(book1.equals(book3));
        System.out.println();


        System.out.println("consistent -> always same result");
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book2));
        System.out.println();

        System.out.println("not null -> always false");
        System.out.println(book1.equals(null));
        System.out.println(book2.equals(null));
        System.out.println(book3.equals(null));
    }

}
class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return this.title != null? this.title.equals(book.title) : book.title == null;
    }
}
