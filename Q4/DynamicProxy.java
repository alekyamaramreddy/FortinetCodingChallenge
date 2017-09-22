import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//interface having a method
interface ProxyInterface {
    void originalMethod(String s);
}

//Main class having a single method
class Main implements ProxyInterface {
    public void originalMethod(String s) {
        System.out.println(s);
    }
}

//proxyclass which act as the proxy for the main class with additional functionality
//for the given main class
class Handler implements InvocationHandler {
    private final ProxyInterface original;

    public Handler(ProxyInterface original) {
        this.original = original;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        System.out.println("BEFORE");
        method.invoke(original, args);
        System.out.println("AFTER");
        return null;
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        Main main = new Main();

        //here the main object is passed to the handler class which has an additional method
        //invoke which will be invoked whenever the proxy interface assigned the proxy instance with
        //handler which contains the
        Handler handler = new Handler(main);


        ProxyInterface proxyInterface = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(),
                new Class[]{ProxyInterface.class},
                handler);
        proxyInterface.originalMethod("Hello");
    }

}
