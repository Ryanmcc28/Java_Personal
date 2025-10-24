package Week_1;

public class Task_4
{
    public static void main(String[] args)
    {
        int height = 3;
        int width = 4;
        int depth = 5;
        double perimeter = 0;
        double volume = 0;

        perimeter = 4 * height + 4 * width + 4 * depth;
        volume = height * width * depth;

        System.out.println(perimeter);
        System.out.println(volume);

    }
}
