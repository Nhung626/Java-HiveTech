public class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void walk() {
        System.out.println("I'm walking.");
    }

    public void eat() {
        System.out.println("I'm eating.");
    }

    public static void main(String[] args) {
        Human Humen = new Human("AB", 13);
        Humen.walk();
    }
}