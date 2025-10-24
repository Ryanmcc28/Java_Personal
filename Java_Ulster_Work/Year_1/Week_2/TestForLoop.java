package Week_2;

public class TestForLoop {

    public static void main (String[] args)
    {

        String[] studentName = {"John","Mary", "Stephen","James", "Amy", "Fiona"};
        int[] studentMarks = {90,56,70,66,81,96};

        for(int i = studentName.length; i >= 1; i--)
        {
            System.out.println("Student = " + studentName[i-1] + ", his/her mark = " + studentMarks[i-1]);
        }

        int maxVal = 0;
        int prevVal = 0;
        String name = "";

        for( int i = 0; i < studentName.length; i++ )
        {
            if (i == 0)
            {
                prevVal = studentMarks[i];
                name = studentName[i];
            }

            if (studentMarks[i] > prevVal)
            {
                maxVal = studentMarks[i];
                name = studentName[i];
            }
            prevVal = studentMarks[i];
        }
        System.out.println(maxVal);
        System.out.println(name);


    }


}
