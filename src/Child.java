public class Child extends Parent{

    public int a;

    private static String greeting;


    public Child(String a) {
        super(a);
    }

    private static void zeroIntegrer() throws NullPointerException, AbstractMethodError{
        System.out.println("TEST");
    }

    public String helloSth(String variable) {
        return "Hello " + variable;
    }



}
