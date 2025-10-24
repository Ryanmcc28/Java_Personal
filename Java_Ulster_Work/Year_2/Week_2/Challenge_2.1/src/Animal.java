public class Animal implements AnimalADT {
    private String food;
    private int lifeExpectancy;

    public Animal(){
        food = "?";
        lifeExpectancy = 0;
    }

    public Animal(String food) {
        this.food = food;
        this.lifeExpectancy = 0;
    }

    public Animal(int lifeExpectancy) {
        this.food = "Unknown";
        this.lifeExpectancy = lifeExpectancy;
    }

    public Animal(String food, int lifeExpectancy) {
        this.food = food;
        this.lifeExpectancy = lifeExpectancy;
    }

    @Override
    public String getFood() {
        return food;
    }

    @Override
    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    @Override
    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    @Override
    public String toString() {
        return "This animal eats " + food + " and has an average life expectancy of " + lifeExpectancy + " years.";
    }
}
