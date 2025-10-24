public class Lion extends Animal {
    private int age;
    private String name;
    private static int numOfLions = 0;

    public Lion(){
        this.age = 0;
        this.name = "TBD";
    }

    public Lion(int Age, String Name, String Food, int LifeExpectancy){
       super(Food,LifeExpectancy);
        this.age = Age;
        this.name = Name;
        ++numOfLions;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    @Override
    public String toString(){
        return "I am a Lion who eats " + this.getFood() + " food and has an average life expectancy of "+ this.getLifeExpectancy()+" years.";
    }

    public int getNumOfLions(){
        return numOfLions;
    }

}
