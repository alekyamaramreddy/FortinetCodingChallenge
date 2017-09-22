public class SingletonImplementation {

    private static SingletonImplementation singletonInstance;

    private SingletonImplementation() {
    }
    // Providing Global point of access
    public static SingletonImplementation getInstance() {
        if (null == singletonInstance) {
            singletonInstance = new SingletonImplementation();
        }
        return singletonInstance;
    }


    //testing the singleton pattern
    public static void main(String[] args) {
        SingletonImplementation singletonImplementation = SingletonImplementation.getInstance();
        SingletonImplementation singletonImplementation1 = SingletonImplementation.getInstance();
        SingletonImplementation singletonImplementation2 = SingletonImplementation.getInstance();

        System.out.println(singletonImplementation);
        System.out.println(singletonImplementation1);
        System.out.println(singletonImplementation2);


    }
}