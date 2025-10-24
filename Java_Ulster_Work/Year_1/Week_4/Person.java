public class Person {

    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAge (int newAge) {
        age = newAge;
    }

    public String toString() {
        return name + " - Age " + age;
    }
}

