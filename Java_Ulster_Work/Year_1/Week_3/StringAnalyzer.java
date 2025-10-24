import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringAnalyzer{
	

	private char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'} ;
    private int[] frequency = new int[26];
	
	
    
    public static void main(String[] args){
            
        StringAnalyzer myAnalyzer = new StringAnalyzer() ;
        
        myAnalyzer.start() ;
    }
    private String getString()
    {
        var scan = new Scanner(System.in);
        System.out.println("Enter some text: ");
        return scan.next();
    }
    private List<Object> analyzeString(){
        var ph = new ArrayList<>();
        String hold = getString();

        for (int i = 0; i < hold.length(); i++) {
            ph.add(hold.charAt(i));
        }

        for (int i = 0; i < ph.size(); i++) {

        }
        System.out.println(ph);
        return ph;
    }

    
    private void start(){

        this.analyzeString() ;
        //this.reportAnalysis() ;
                    
        System.out.println("Program Terminating, Goodbye");
    }

	//1. getString() - Read a string of text from keyboard
	//2. encryptString() - Perform encryption on the strinig as required
	//3. reportAnalysis() - Print the results back to the user on the screen 
	// Feel free to declare other variables as needed.
	
    
}