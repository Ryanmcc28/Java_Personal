public class Pet {
    String name;
    int age;
    String colour;
    double weight;

    //Constructor
    public Pet(String name, int age, String colour, double weight){
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }

    //Prints a simple text with some of the pets details
    public void speak(){
        System.out.println("Unspecified pet sound");
    }

    //Returns all the pets details in a string
    public String toString(){
        return name + " " + age + " " + colour + " " + weight;
    }
}
