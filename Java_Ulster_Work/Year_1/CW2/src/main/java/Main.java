import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    final File petFile = new File("src/PetDetails.txt");
    final File clinicFile = new File("src/ClinicDetails.txt");
    Pet selectedPet = null;
    boolean selected = false;
    ArrayList<Pet> petList = new ArrayList<>();
    ArrayList<String> colourList = new ArrayList<>();
    final String clinicName = "Ryan's_Clinic";
    Clinic clinic = new Clinic(clinicName, 0, 0, 0, null);


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    private void start() {
        //A loop to make frequent returns to the main menu
        while (true){
            loadData();

            System.out.println("Would you like to:");
            System.out.println("Add pet (A)");
            System.out.println("Delete pet (D)");
            System.out.println("Modify existing pet (M)");
            System.out.println("Clinic report (R)");
            System.out.println("View all pets (V)");
            System.out.println("Search for a pet (S)");
            System.out.println("------------");
            System.out.println("Exit (E)");
            System.out.println("Please type your letter of choice in the line below");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "A":
                    addPet();
                    break;
                case "D":
                    deletePet();
                    break;
                case "M":
                    modPet();
                    break;
                case "R":
                    report();
                    break;
                case "V":
                    viewPets();
                    break;
                case "S":
                    searchPet();
                    break;
                default:
                    //Happens if any key not mentioned is pressed
                    System.out.println("Thank you for using our system :)");
                    System.exit(0);
                    break;
            }
        }
    }
    private void loadData() {
        petList.clear();
        colourList.clear();
        clinic = new Clinic(clinicName, 0, 0, 0, null);

        //Makes a pet object and adds it to the pet list
        try {
            Scanner reader = new Scanner(petFile);
            do {
                String data = reader.nextLine();
                String[] tempPet = data.split(" ");

                switch (tempPet[0]) {
                    case "fish":
                        petList.add(new Fish(tempPet[1],
                                Integer.parseInt(tempPet[2]),
                                tempPet[3],
                                  Double.parseDouble(tempPet[4]),
                                tempPet[5],
                                tempPet[6]));
                        clinic.fishNum++;
                        break;
                    case "cat":
                        petList.add(new Cat(tempPet[1],
                                Integer.parseInt(tempPet[2]),
                                    tempPet[3],
                                Double.parseDouble(tempPet[4]),
                                tempPet[5]));
                        clinic.catNum++;
                        break;
                    default:
                        petList.add(new Dog(tempPet[1],
                                Integer.parseInt(tempPet[2]),
                                tempPet[3],
                                Double.parseDouble(tempPet[4]),
                                tempPet[5]));
                        clinic.dogNum++;
                }
            }
               while (reader.hasNextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File cant be found");
        }

        //Code below determines dominant pet colour
        for (Pet pet : petList) {
            if (!colourList.contains(pet.colour)) {
                colourList.add(pet.colour);
            }
        }
        int[] colourCount = new int[colourList.size()];
        for (Pet pet : petList) {
            for (int i = 0; i < colourList.size(); i++) {
                if (pet.colour.equals(colourList.get(i))) {
                    colourCount[i] += 1;
                }
            }
        }

        int maxCount = 0;
        String domColour = null;
        for (int i = 0; i < colourCount.length; i++) {
            if (colourCount[i] > maxCount) {
                maxCount = colourCount[i];
                domColour = colourList.get(i);
            }
        }
        clinic.domColour = domColour;

        try {
            FileWriter writer = new FileWriter(clinicFile, false);
            writer.write(clinic.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void addPet() {
        String name = null;
        int age = 0;
        String colour = null;
        double weight = 0.0;
        String breed = null;
        String waterType = null;

        System.out.println("Enter pet type: Dog (D), Cat (C) or Fish (F) or return to the main menu (M)");
        String animal = scanner.next().toUpperCase();


        if (!animal.equalsIgnoreCase("D") && !animal.equalsIgnoreCase("C") && !animal.equalsIgnoreCase("F")){
            System.out.println("Returning to main menu");
            System.out.println("..........");
            start();
        }

        System.out.println("Enter pet name");
        name = scanner.next();
        System.out.println("Enter pet age (years only)");
        try{
            //Try parseInt to check the correct data type is entered
            age = Integer.parseInt(scanner.next());
        }catch (Exception e){
            System.out.println("Please enter a whole number for the age value");
            System.out.println("Would you like to try again? (Y/N)");
            System.out.println("\nEnter (I) for more info");

            switch (scanner.next().toUpperCase()) {
                case "Y":
                    addPet();
                    break;
                case "I":
                    printInfo();
                    proceed();
                    break;
                default:
                    proceed();
                    break;
            }
        }
        System.out.println("Enter pet colour");
        colour = scanner.next();
        System.out.println("Enter pet weight (kg)");
        try{
            weight = Double.parseDouble(scanner.next());
        }catch (Exception e){
            System.out.println("you did not enter a number for the weight value");
            System.out.println("Would you like to try again? (Y/N)");
            System.out.println("\nEnter (I) for more info");
            switch (scanner.next().toUpperCase()) {
                case "Y":
                    addPet();
                    break;
                case "I":
                    printInfo();
                    proceed();
                    break;
                default:
                    proceed();
                    break;
            }
        }

        if (animal.equals("F")) {
            System.out.println("Enter species");
            breed = scanner.next();
            System.out.println("Enter water type (Saltwater or Freshwater)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("saltwater") || answer.equalsIgnoreCase("freshwater")) waterType = answer;
            else {
                System.out.println("you did not enter saltwater or freshwater");
                System.out.println("Would you like to try again? (Y/N)");
                System.out.println("\nEnter (I) for more info");
                switch (scanner.next().toUpperCase()) {
                    case "Y":
                        addPet();
                        break;
                    case "I":
                        printInfo();
                        proceed();
                        break;
                    default:
                        proceed();
                        break;
                }
            }
        } else if (animal.equals("C") || animal.equals("D")) {
            System.out.println("Enter pet breed");
            breed = scanner.next();
        } else {
            proceed();
        }

        //Writing new animal to file
        switch (animal) {
            case "C":
                Cat cat = new Cat(name, age, colour, weight, breed);
                if (petValidation(cat)) {
                    try {
                        FileWriter writer = new FileWriter(petFile, true);
                        writer.append("\n" + cat.toString());
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    System.out.println("Pet data invalid, would you like to try again? (Y/N)");
                    System.out.println("\nEnter (I) for more info");
                    switch (scanner.next().toUpperCase()) {
                        case "Y":
                            addPet();
                            break;
                        case "I":
                            printInfo();
                            proceed();
                            break;
                        default:
                            proceed();
                            break;
                    }
                }
                break;

            case "F":
                Fish fish = new Fish(name, age, colour, weight, breed, waterType);
                if (petValidation(fish)) {
                    try {
                        FileWriter writer = new FileWriter(petFile, true);
                        writer.append("\n" + fish.toString());
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    System.out.println("Pet data invalid, would you like to try again? (Y/N)");
                    System.out.println("\nEnter (I) for more info");
                    switch (scanner.next().toUpperCase()) {
                        case "Y":
                            addPet();
                            break;
                        case "I":
                            printInfo();
                            proceed();
                            break;

                        default:
                            proceed();
                            break;
                    }
                }
                break;
            default:
                Dog dog = new Dog(name, age, colour, weight, breed);
                if (petValidation(dog)) {
                    try {
                        FileWriter writer = new FileWriter(petFile, true);
                        writer.append("\n" + dog.toString());
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    System.out.println("Pet data invalid, would you like to try again? (Y/N)");
                    System.out.println("\nEnter (I) for more info");
                    switch (scanner.next().toUpperCase()) {
                        case "Y":
                            addPet();
                            break;
                        case "I":
                            printInfo();
                            proceed();
                            break;
                        default:
                            proceed();
                            break;
                    }
                }
                break;
        }
        System.out.println("Pet successfully added, would you like to add another animal? (Y/N)");
        String answer = scanner.next().toUpperCase();
        if (answer.equals("Y")) {
            addPet();
        } else {
            proceed();
        }
    }
    private void selectPet(){
        String name = scanner.next().toLowerCase();
        selectedPet = null;
        selected = false;
        if (name.equals("m")) {
            System.out.println("Returning to main menu");
            System.out.println("..........");
            start();
        }
        //Check to see if name entered is present in list
        for (Pet pet : petList) {
            if (pet.name.toLowerCase().equals(name)) {
                selectedPet = pet;
                selected = true;
            }
        }
    }
    private void deletePet() {
        System.out.println("Type below the name of the pet to remove or (M) to return to the main menu");
        selectPet();

        if (selected) {
            System.out.println("Are you sure you want to delete the pet with these details (Y/N)");
            System.out.println(selectedPet.toString());
            if (scanner.next().equalsIgnoreCase("Y")) {
                petList.remove(selectedPet);

                //Clears pet file
                try {
                    FileWriter writer = new FileWriter(petFile, false);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Rewrites it but without the removed pet
                try {
                    FileWriter writer = new FileWriter(petFile, true);
                    int count = 0;
                    for (Pet pet : petList) {
                        if (count == 0) {
                            writer.append(pet.toString());
                        } else {
                            writer.append("\n" + pet.toString());
                        }
                        ++count;
                    }
                    writer.close();
                    System.out.println("Pet successfully removed");
                    proceed();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(selectedPet.name + " has NOT been deleted from our system");
                proceed();
            }
        } else {
            System.out.println("That pet is not in our system would you like to try again (Y/N)");
            if (scanner.next().equalsIgnoreCase("Y")) {
                deletePet();
            } else {
                proceed();
            }
        }
    }
    private void modPet() {
        System.out.println("Type below the name of the pet to modify or (M) to return to the main menu");
        selectPet();

        if (selected) {
            System.out.println("Are you sure you want to modify the pet with these details (Y/N)");
            System.out.println(selectedPet.toString());
            String stat = null;
            if (scanner.next().equalsIgnoreCase("Y")) {
                System.out.println("Please enter which value to change");
                System.out.println("Name (N)");
                System.out.println("Age (A)");
                System.out.println("Weight (W)");
                System.out.println("Colour (C)");
                System.out.println("------------");
                System.out.println("Main menu(M)");

                //Breed, species and water type not present in options as these values in animals don't change
                switch (scanner.next().toUpperCase()) {
                    case "N":
                        stat = "name";
                        break;
                    case "A":
                        stat = "age";
                        break;
                    case "W":
                        stat = "weight";
                        break;
                    case "C":
                        stat = "colour";
                        break;
                    default:
                        System.out.println("Returning to main menu");
                        System.out.println("..........");
                        start();
                }

                switch (stat) {
                    case "name":
                        System.out.println("Enter new name for " + selectedPet.name);
                        selectedPet.name = scanner.next();
                        break;
                    case "age":
                        System.out.println("Enter new age for " + selectedPet.name);
                        try{
                            selectedPet.age = Integer.parseInt(scanner.next());
                        }catch (Exception e){
                            System.out.println("Please enter a whole number for the age value");
                            System.out.println("Would you like to try again? (Y/N)");
                            System.out.println("\nEnter (I) for more info");

                            switch (scanner.next().toUpperCase()) {
                                case "Y":
                                    modPet();
                                    break;
                                case "I":
                                    printInfo();
                                    proceed();
                                    break;
                                default:
                                    proceed();
                                    break;
                            }
                        }
                        break;
                    case "weight":
                        System.out.println("Enter new weight for " + selectedPet.name);
                        try{
                            selectedPet.weight = Double.parseDouble(scanner.next());
                        }catch (Exception e){
                            System.out.println("you did not enter a number for the weight value");
                            System.out.println("Would you like to try again? (Y/N)");
                            System.out.println("\nEnter (I) for more info");
                            switch (scanner.next().toUpperCase()) {
                                case "Y":
                                    modPet();
                                    break;
                                case "I":
                                    printInfo();
                                    proceed();
                                    break;
                                default:
                                    proceed();
                                    break;
                            }
                        }
                        break;
                    case "colour":
                        System.out.println("Enter new colour for " + selectedPet.name);
                        selectedPet.colour = scanner.next();
                        break;
                }

                //Clears pet file
                try {
                    FileWriter writer = new FileWriter(petFile, false);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Rewrites it with updated details
                try {
                    FileWriter writer = new FileWriter(petFile, true);
                    int count = 0;
                    for (Pet pet : petList) {
                        if (count == 0) {
                            writer.append(pet.toString());
                        } else {
                            writer.append("\n" + pet.toString());
                        }
                        ++count;
                    }
                    writer.close();
                    System.out.println("Pet successfully modified");
                    proceed();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(selectedPet.name + " has NOT been modified");
            }
        } else {
            System.out.println("That pet is not in our system would you like to try again (Y/N)");
            if (scanner.next().equalsIgnoreCase("Y")) {
                modPet();
            } else {
                proceed();
            }
        }
    }
    private void viewPets() {
        //Prints out each pets details
        for (int i = 0; i < petList.size(); i++) {
            printPet(i);
        }
        proceed();
    }
    private void printPet(int i) {
        //Prints out pet details in a visually appealing format
        if (petList.get(i).getClass() == Fish.class) {
            Fish temp = (Fish) petList.get(i);
            System.out.println("Pet: Fish | Name: " + temp.name +
                    " | Age: " + temp.age +
                    " | Weight: " + temp.weight +
                    " | Colour: " + temp.colour +
                    " | Species: " + temp.species +
                    " | Watertype: " + temp.waterType);
        } else if (petList.get(i).getClass() == Cat.class) {
            Cat temp = (Cat) petList.get(i);
            System.out.println("Pet: Cat | Name: " + temp.name +
                    " | Age: " + temp.age +
                    " | Weight: " + temp.weight +
                    " | Colour: " + temp.colour +
                    " | Breed: " + temp.breed);
        } else if (petList.get(i).getClass() == Dog.class) {
            Dog temp = (Dog) petList.get(i);
            System.out.println("Pet: Dog | Name: " + temp.name +
                    " | Age: " + temp.age +
                    " | Weight: " + temp.weight +
                    " | Colour: " + temp.colour +
                    " | Breed: " + temp.breed);
        }
    }
    private void searchPet() {
        System.out.println("Enter the colour or than name of your pet or return to the main menu (M)");
        String search = scanner.next().toLowerCase();
        Pet selectedPet = null;
        boolean selected = false;

        if (search.equals("m")) {
            System.out.println("Returning to main menu");
            System.out.println("..........");
            start();
        }

        //Checks if colour or name match any pet in the list
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).colour.toLowerCase().equals(search) || petList.get(i).name.toLowerCase().equals(search)) {
                printPet(i);
                selected = true;
                selectedPet = petList.get(i);
                selectedPet.speak();
            }
        }
        if (!selected) {
            System.out.println("There is no pet in our system that matches your search");
        }
        System.out.println("Would you like to search again (Y/N)");
        switch (scanner.next().toUpperCase()) {
            case "Y":
                searchPet();
                break;
            default:
                proceed();
        }
    }
    private void report() {
        //Prints out basic info about the clinic
        System.out.println("Clinic Name: " + clinic.name);
        System.out.println("Amount of Fish registered: " + clinic.fishNum);
        System.out.println("Amount of Dogs registered: " + clinic.dogNum);
        System.out.println("Amount of Cats registered: " + clinic.catNum);
        System.out.println("Dominant color of pets: " + clinic.domColour);
        proceed();
    }
    private boolean petValidation(Pet pet) {
        //Checks pet info to ensure correct data was entered
        if (pet.name.isEmpty()) return false;
        if (pet.colour.isEmpty()) return false;
        if (pet.age <= 0) return false;
        if (pet.weight <= 0.0) return false;

        if (pet.getClass().getSimpleName().equals("Fish")) {
            Fish fish = (Fish) pet;
            if (!fish.waterType.equalsIgnoreCase("saltwater") && !fish.waterType.equalsIgnoreCase("freshwater"))
                return false;
            if (fish.species.isEmpty()) return false;
        } else if(pet.getClass().getSimpleName().equals("Cat")) {
            Cat cat = (Cat) pet;
            if (cat.breed.isEmpty()) return false;
        }else {
            Dog dog = (Dog) pet;
            if (dog.breed.isEmpty()) return false;
        }
        return true;
    }
    private void printInfo(){
        //Simple text to help the user
        System.out.println("When creating or modifying animal details these conditions must be met:");
        System.out.println("Name must not be empty");
        System.out.println("Age must be a whole number");
        System.out.println("Colour must not be empty");
        System.out.println("Weight must be a whole or decimal number");
        System.out.println("Breed must not be empty");
        System.out.println("Species must not be empty");
        System.out.println("Water type must be either saltwater or freshwater");
    }
    private void proceed(){
        //Used to give the user a choice to return to the main menu or quit the system
        System.out.println("Would you like to return to the Main Menu (Y/N)");
        if (scanner.next().equalsIgnoreCase("Y")) {
            System.out.println("Returning to main menu");
            System.out.println("..........");
            start();
        } else {
            System.out.println("Thank you for using our system :)");
            System.exit(0);
        }
    }
}