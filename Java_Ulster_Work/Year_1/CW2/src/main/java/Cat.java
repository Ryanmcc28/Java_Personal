public class Cat extends Pet{
    String breed;

    //Constructor
    public Cat(String name, int age, String colour, double weight, String breed){
        super(name,age,colour,weight);
        this.breed = breed;
    }

    //Prints a simple text with some of the pets details
    @Override
    public void speak(){
        System.out.println("Meow! i am " + this.name + " i'm a " + this.age + " year old " + this.breed + " cat");
    }

    //Returns all the pets details in a string
    @Override
    public String toString(){
        return "cat " + super.toString() + " " + breed;
    }
}
