package structure;

public abstract class A {
    String name = "123";

    public static A getInstance() {
        return new B();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
