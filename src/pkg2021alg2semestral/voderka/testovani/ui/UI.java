package pkg2021alg2semestral.voderka.testovani.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg2021alg2semestral.voderka.testovani.app.Comparing;

/**
 * UI class to communication with user
 * @author Martin
 */
public class UI {

    static Scanner sc = new Scanner (System.in);
    
    /**
     * Main method with Menu choosing option
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        int choice;
        System.out.println("Welcome to testing app");
        System.out.println("Enter file name with results (default is results.dat):");
        String resultFile = sc.next();
        boolean setFile = false;
        Comparing comparing = new Comparing();
        do{
            try
            {
                comparing.setFileName(resultFile);
                setFile = true;
            } catch (IOException ex) {
                System.out.println("File not found, try again: ");
                resultFile = sc.next();
            }
        } while(!setFile);
        displayMenu();
        Testing testing = new Testing();
        while (sc.hasNextInt())
        {
            choice = sc.nextInt();
            if(choice == 4) break;
            switch(choice)
            {
                case 1:
                    {
                        try {
                            testing.test();
                        } catch (FileNotFoundException ex) {
                            System.out.println("Question/answer file not found, try again: ");
                        } catch (IOException ex) {
                            System.out.println("Question/answer file not found, try again: ");
                        }
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Test results by points: ");
                    System.out.println("");
                    System.out.println(comparing.compareBy(1));
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Test results by time: ");
                    System.out.println("");
                    System.out.println(comparing.compareBy(2));
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
            displayMenu();
        }
        System.out.println("Bye!");
    }
    
    /**
     * Display menu on console
     */
    private static void displayMenu(){
        System.out.println("---------------------------------------------");
        System.out.println("|  1    -           Start TEST              |");
        System.out.println("|  2    -     Show results due points       |");
        System.out.println("|  3    -       Show results due time       |");
        System.out.println("|  4    -               End                 |");
        System.out.println("---------------------------------------------");
    }
}
