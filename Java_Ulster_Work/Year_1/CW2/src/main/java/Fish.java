public class Fish extends Pet{
    //Saltwater or freshwater
    String waterType;
    String species;

    //Constructor
    public Fish(String name, int age, String colour, double weight, String species, String waterType){
        super(name,age,colour,weight);
        this.waterType = waterType;
        this.species = species;
    }

    @Override
    //Prints a simple text with some of the pets details
    public void speak(){
        System.out.println("Bloop Bloop Bloop! i am " + this.name + " i'm a " + this.age + " year old " + this.species);
    }

    //Returns all the pets details in a string
    @Override
    public String toString(){
        return "fish " + super.toString() + " " + species + " " + waterType;
    }
}
