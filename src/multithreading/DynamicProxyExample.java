package multithreading;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class DynamicProxyExample {
    public static void main(String[] args) {
        Class[] interfaces = new Class[]{Callable.class, Runnable.class };
        InvocationHandler handler = new MyHandler(new Task("Gleb"));
        Object proxy = Proxy.newProxyInstance(null,interfaces, handler);
        System.out.println(proxy);
        InvocationHandler handler1 = new MyHandler(5);
        Object proxy1 = Proxy.newProxyInstance(null, interfaces, handler1);
        System.out.println(proxy1);
    }
}
class Task implements Callable<String> {
    String userName;

    public Task(String userName) {
        this.userName = userName;
    }

    @Override
    public String call() throws Exception {
        return userName;
    }
}
class MyHandler implements InvocationHandler{
    Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Username is: ");
        if (target.getClass().getSimpleName().equals("Task")){
            System.out.println(((Task) target).call());
            return method.invoke(target,args);
        }
        return "No class";
    }
}
