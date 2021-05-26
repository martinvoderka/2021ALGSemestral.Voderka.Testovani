package pkg2021alg2semestral.voderka.testovani.app;

import java.time.Duration;
import pkg2021alg2semestral.voderka.testovani.utils.PlaySound;
import pkg2021alg2semestral.voderka.testovani.utils.Comparing;
import java.time.Instant;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import pkg2021alg2semestral.voderka.testovani.utils.ResultsFile;


/**
 * Interface class with main methods to run test and display results
 * @author Martin
 */
public class Testing {
    
    static Scanner sc = new Scanner(System.in);
    static PlaySound play = new PlaySound();
    
    /**
     * Reads questions from file and comparing user answer with correct answers from file
     * 
     */
    public void test(){
        
        int points = 0;
        String userAnswer;
        String correctAnswer;
        String name;
               
        System.out.print("Enter you name: ");
        name = sc.next();
        System.out.println("");
        System.out.println("Odpovidej jednim slovem: ");
        System.out.println("");
            
        try {    
            //setting the files and files path
            File questions = new File("data\\otazky.txt");
            Scanner questionFile = new Scanner(questions);
            File answers = new File("data\\odpovedi.txt");
            Scanner answerFile = new Scanner(answers);

            //saving curret time (java.time.instant)
            Instant startTime = Instant.now();
            
            //reading question file
            while(questionFile.hasNextLine())
            {
                System.out.println(questionFile.nextLine());
                correctAnswer = answerFile.nextLine();
                userAnswer = sc.next();
                //comparing user and correct answers (not case sensitive)
                if(userAnswer.toLowerCase().contains(correctAnswer))
                {
                    play.playGoodSound(); //plays sound of success
                    points++;
                }
                else
                {
                    play.playFailSound(); //plays sound of failture
                }
            }
            //saving curret time
            Instant finishTime = Instant.now();
            //calculating time of test in milliseconds
            long timeDuration = Duration.between(startTime, finishTime).toMillis();
            timeDuration = timeDuration/1000;
            System.out.format("Your result: %n%s - %d/%d points, %d seconds %n", name, points, 20, timeDuration);
            System.out.println("Do you want to save your score?");
            String saving = sc.next();
            if(saving.toLowerCase().contains("yes"))
            {
                ResultsFile resFile = new ResultsFile();
                resFile.addResults(name, points, (int) timeDuration);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Files not founded");
        }
    }
    
    /**
     * Shows results from file sorted according to more points
     * @throws FileNotFoundException 
     */
    public void resultsByPoints() throws FileNotFoundException{
        Comparing comparing = new Comparing();
        String results = comparing.compareByPoints();
        System.out.println("");
        System.out.println("Test results by points: ");
        System.out.println("");
        System.out.println(results);
        
    }
    
    /**
     * Swow results from file sorted according to small time
     * @throws FileNotFoundException 
     */
    public void resultsByTime() throws FileNotFoundException{
        Comparing comparing = new Comparing();
        String results = comparing.compareByTime();
        System.out.println("");
        System.out.println("Test results by time: ");
        System.out.println("");
        System.out.println(results);
    }
    
}
