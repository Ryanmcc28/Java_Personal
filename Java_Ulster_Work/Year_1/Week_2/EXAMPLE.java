package Week_2;

public class EXAMPLE {

    public static class Car
    {
        private String colour;
        private int doors;
        private String fuel_type;
        private int seats;

        //Constructor
        public Car(String colour, int doors, String fuelType, int seats)
        {
            this.colour = colour;
            this.doors = doors;
            this.fuel_type = fuelType;
            this.seats = seats;
        }

        //Getters and Setters
        public void setColour(String newColour)
        {
            colour = newColour;
        }

        public String getColour()
        {
            return colour;
        }

        public void setDoors(int newDoors)
        {
            doors = newDoors;
        }
        public int getDoors()
        {
            return doors;
        }

        public void setFuelType(String newFuelType)
        {
            fuel_type = newFuelType;
        }
        public String getFuelType()
        {
            return fuel_type;
        }

        public void setSeats(int newSeats)
        {
            seats = newSeats;
        }
        public int getSeats()
        {
            return seats;
        }
    }

    public static void main(String[] args)
    {
        Car dannysCar = new Car("white", 5, "petrol", 5);

        //CAR.setColour("White");
        // CAR.setDoors(5);
        // CAR.setSeats(4);
        //CAR.setFuelType("petrol");

        System.out.println(dannysCar.getColour());
        System.out.println(dannysCar.getDoors());
        System.out.println(dannysCar.getSeats());
        System.out.println(dannysCar.getFuelType());

        dannysCar.setFuelType("Diesel");

        System.out.println(dannysCar.getFuelType());

        Car ethansCar = new Car("pink", 2, "electric", 1);

        ethansCar.setSeats(10);

        System.out.println(ethansCar.getSeats());
    }
}