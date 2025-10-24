import java.util.Random;
import java.util.Scanner;

public class PetTest {

    public static void main(String[] args) {
        Pet[] petList = new Pet[5];
        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();
        int tempAge;
        String tempName;
        String tempBreed;
        String petType;
        String[] catBreeds = {"Tabby", "Tuxedo", "Calico"};
        String[] dogBreeds = {"Pug", "Bulldog", "Labrador"};

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Cat or Dog for pet number " + (i + 1));
            petType = scanner.next();
            tempAge = rng.nextInt(1, 15);
            switch (petType.toLowerCase()) {
                case "cat":
                    System.out.println("Enter Name for pet number " + (i + 1));
                    tempName = scanner.next();
                    tempBreed = catBreeds[rng.nextInt(1, 4) - 1];
                    Cat cat = new Cat(tempName, tempAge, tempBreed);
                    petList[i] = cat;
                    break;
                case "dog":
                    System.out.println("Enter Name for pet number " + (i + 1));
                    tempName = scanner.next();
                    tempBreed = dogBreeds[rng.nextInt(1, 4) - 1];
                    Dog dog = new Dog(tempName, tempAge, tempBreed);
                    petList[i] = dog;
                    break;
            }
        }

        int catNum = 0;
        int dogNum = 0;

        for (int i = 0; i < petList.length; i++) {

            if (petList[i] instanceof Cat) {
                // ((Cat)petList[i]).speak();
                ++catNum;
            } else {
                // ((Dog)petList[i]).speak();
                ++dogNum;
            }
        }
        System.out.println("There are " + catNum + " cats, and there are " + dogNum + " dogs");

        boolean run = true;
        while (run)
        {
            System.out.println("Please enter a pet to search for or type exit to leave:");
            tempName = scanner.next();
            for (int i = 0; i < petList.length; i++) {
                if (petList[i].getName().equals(tempName)) {
                    if (petList[i] instanceof Cat) {
                        ((Cat) petList[i]).speak();
                        break;
                    } else {
                        ((Dog) petList[i]).speak();
                        break;
                    }
                }else if (tempName.toLowerCase().equals("exit")){
                    run = false;
                    System.out.println("Terminating...");
                    break;
                }
            }
        }

    }
}