public class Cat extends Pet{
    private String breed;

    public Cat(String Name, int Age, String Breed){
        super(Name,Age);
        breed = Breed;
    }

    public String getBreed(){
        return breed;
    }
    public void speak(){
        System.out.println("Meow i am "+ getName() + " i am a " + getAge() + " year old "+ breed);
    }
}
