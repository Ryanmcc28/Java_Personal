public class Dog extends Pet {
    private static String breed;

    public Dog(String Name, int Age, String Breed){
        super(Name,Age);
        breed = Breed;
    }
    public String getBreed(){
        return breed;
    }
    public void speak(){
        System.out.println("Woof i am "+ getName() + " i am a " + getAge() + " year old "+ breed);
    }
}
