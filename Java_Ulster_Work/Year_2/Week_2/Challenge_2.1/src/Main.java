public class Main {
    public static void main(String[] args) {
        Lion Lion1 = new Lion(12,"Simba","Meat",40);
        Lion Lion2 = new Lion(35,"Mittens","Meat",40);

        Lion1.setAge(3);
        System.out.println(Lion1.getNumOfLions());
        System.out.println(Lion1.toString());
    }
}