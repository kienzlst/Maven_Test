import java.util.Scanner;


public class Grossbuchstaben {


	public static void main(String[] args){
		
		
		Scanner scanner = new Scanner(System.in);
        String eingabe;
        eingabe =scanner.nextLine();
        
        for(char c : eingabe.toCharArray()){  
            if(Character.isLowerCase(c)){
            	System.out.print(Character.toUpperCase(c));
            } else {
            	System.out.print(c);
            }  
        }
        
        scanner.close();
 
	}

	
}