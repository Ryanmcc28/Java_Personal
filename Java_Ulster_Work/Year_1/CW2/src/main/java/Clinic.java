public class Clinic {
    String name;
    int fishNum;
    int dogNum;
    int catNum;
    String domColour;


    //Constructor
    public Clinic(String name, int fishNum, int dogNum, int catNum, String domColour){
        this.name = name;
        this.fishNum = fishNum;
        this.dogNum = dogNum;
        this.catNum = catNum;
        this.domColour = domColour;
    }

    //Returns all the clinics details in a string
    public String toString() {
        return name + " " + fishNum + " " + dogNum + " " + catNum + " " + domColour;
    }
}
