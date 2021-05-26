package pkg2021alg2semestral.voderka.testovani.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;
import pkg2021alg2semestral.voderka.testovani.app.Testing;

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
        displayMenu();
        Testing testing = new Testing();
        while (sc.hasNextInt())
        {
            choice = sc.nextInt();
            if(choice == 4) break;
            switch(choice)
            {
                case 1:
                    testing.test();
                    break;
                case 2:
                    testing.resultsByPoints();
                    break;
                case 3:
                    testing.resultsByTime();
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
