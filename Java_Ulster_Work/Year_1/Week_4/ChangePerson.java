public class ChangePerson {

     public static void main (String[] args)
    {
        Person p1 = new Person("Sally", 18);
        Person p2 = new Person("Sam", 20);
        int age = 31;
        String name = "Jill";
        System.out.println ("\nParameter Passing... Original values...");
        System.out.println ("person1: " + p1);
        System.out.println ("person2: " + p2);
        System.out.println ("age: " + age + "\tname: " + name + "\n");
        editPerson (p1, p2, age, name);
        System.out.println ("\nValues after calling editPerson...");
        System.out.println ("person1: " + p1);
        System.out.println ("person2: " + p2);
        System.out.println ("age: " + age + "\tname: " + name + "\n");
    }

    public static void editPerson (Person p1, Person p2, int age, String name)
    {
        System.out.println ("\nInside changePeople... Original parameters...");
        System.out.println ("person1: " + p1);
        System.out.println ("person2: " + p2);
        System.out.println ("age: " + age + "\tname: " + name + "\n");

        Person p3 = new Person(name, age);
        p2 = p3;
        name = "Jack";
        age = 25;
        p1.setName (name);
        p1.setAge (age);

        System.out.println ("\nInside editPerson... Changed values...");
        System.out.println ("person1: " + p1);
        System.out.println ("person2: " + p2);
        System.out.println ("age: " + age + "\tname: " + name + "\n");
    } 
}