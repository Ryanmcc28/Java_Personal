public class Dog extends Pet{
    String breed;

    //Constructor
    public Dog(String name, int age, String colour, double weight, String breed){
        super(name,age,colour,weight);
        this.breed = breed;

    }

    //Prints a simple text with some of the pets details
    @Override
    public void speak(){
        System.out.println("Woof Woof! i am " + this.name + " i'm a " + this.age + " year old " + this.breed);
    }

    //Returns all the pets details in a string
    @Override
    public String toString(){
        return "dog " + super.toString() + " " + breed;
    }
}
