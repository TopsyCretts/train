package differents.debugging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class proxyDebugEx {
    public static void main(String[] args) throws FileNotFoundException {
        method1();
        method2();
        method3();
        method4();
        //method 5 -> use cmd java TestEx.java > test.log to print all to log file
        method6();
        //method 7 -> use cmd java -verbose TestEx.java to get info about all loaded jar and classes
        //method 8 -> use cmd  javac -Xling:@arg@ TestEx.java check args in png file
        //method 9 JConsole.exe or JavaProfiler or YourKit or VisualVM
        Scanner scanner = new Scanner(System.in);
        while (!scanner.nextLine().endsWith("exit")){

        }


    }
    static private void method1(){
        Random random = new Random(){
            @Override
            public double nextDouble() {
                System.out.println("override method and check whatever you want");
                return super.nextDouble();
            }
        };
        System.out.println(random.nextDouble());
    }
    static private void method2(){
        try {
            throw new Exception("exception message");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    static private void method3(){
        Thread.dumpStack();
    }
    static private void method4() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("differents\\debugging\\ingest.log"));
        new Throwable().printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
    }
    static private void method6(){
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //save to file
            }
        });
    }

}
