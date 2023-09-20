package differents.javadocEx;

/**
 * @author Topsy
 * @version 1.1
 * @since 1.0
 * This is my first JavaDoc XD
 * Here I will write my <strong>code</strong> he-he
 * <img src="doc-files/result.png" alt="bla"/>
 *
 */
//javadoc -d javadoc differents.javadocEx
public class jdEx {
    /**
     * this is just int for example
     */
    int i;

    /**
     * Here is starting point of this program
     * @param args just default
     */
    public static void main(String[] args) {

    }

    /**
     * This method will return i
     * @param string  not used in method
     * @param i param which will be returned
     * @return result is just i param
     * @throws RuntimeException if smth goes wrong this exc will be thrown
     *
     */
    int getMyInt(int i, String string) throws RuntimeException{
        return i;
    }

    /**
     * @deprecated please use newMethod
     */
    void oldMethod(){

    }

    /**
     * this is just desc with just ling {@link OtherClass#otherMethod()}
     * @see OtherClass#otherMethod()
     * @see "chapter 2"
     */
    void newMethod(){

    }
}
