package pkg2021alg2semestral.voderka.testovani.ui;

import java.time.Duration;
import pkg2021alg2semestral.voderka.testovani.utils.PlaySound;
import java.time.Instant;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import pkg2021alg2semestral.voderka.testovani.app.Comparing;
import pkg2021alg2semestral.voderka.testovani.app.Questions;
import pkg2021alg2semestral.voderka.testovani.app.Test;
import pkg2021alg2semestral.voderka.testovani.utils.ResultsFile;


/**
 * Interface class with main methods to run test and display results
 * @author Martin
 */
public class Testing {
    
    private static Scanner sc = new Scanner(System.in);
    private static PlaySound play = new PlaySound();
    
    /**
     * UI of test, prints questions and reads answers
     * @throws IOException 
     */
    public void test() throws IOException{
        
        String userAnswer;
        System.out.println("Enter filename with questions(default is otazky.txt)");
        String soubOtaz = sc.next();
        System.out.println("Enter filename with answers(default is odpovedi.txt)");
        String souborOdp = sc.next();
        Questions questions = new Questions(soubOtaz, souborOdp);
        PlaySound sound = new PlaySound();
        Test test = new Test();
        String name;
        int nameCheck;
        do {
        System.out.print("Enter you name: ");
        name = sc.next();  
        switch(nameCheck = test.checkName(name))
        {
            case 0: 
                System.out.println("Correct name");
                break;
            case 1: 
                System.out.println("1st letter must be capital");
                break;
            case 2: 
                System.out.println("Name contains non-letter character");
                break;
            case 3: 
                System.out.println("2nd and other characters can not be capital");
                break;
            case 4: 
                System.out.println("Other problem");
                break;
        }
        } while (nameCheck != 0);
        System.out.println("Odpovidej jednim slovem: ");
        System.out.println("");
        test.setTestStart();
        for (int i = 1; i <= questions.getNumberOfQuestions(); i++) 
        {
            System.out.println(questions.getQuestion(i));
            userAnswer = sc.next();
            if(questions.isCorrect(userAnswer, i))
            {
                test.addPoint();
                sound.playGoodSound();
            }
            else
            {
                sound.playFailSound();
            }
            System.out.println("Spravna odpoved: " + questions.getOdpoved(i));
        }
        test.setTestEnd();
        System.out.println(test.getResult());
        System.out.println("Do you want to save your result? [Y/N]");
        if((userAnswer = sc.next()).toLowerCase().equals("y"))
        {
            test.saveResult();
        }
        
    }
    
    
    
}
