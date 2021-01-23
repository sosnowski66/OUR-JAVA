public class Parent {

    private final String a;

    public int b;

    public Parent(String a) {
        this.a = a;
    }

    public int multiplyB(int c) {
        return b * c;
    }

    public String getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
