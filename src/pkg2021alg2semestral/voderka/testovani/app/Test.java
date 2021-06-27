package pkg2021alg2semestral.voderka.testovani.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import pkg2021alg2semestral.voderka.testovani.utils.ResultsFile;
import java.util.regex.*;  

/**
 *
 * @author Martin
 */
public class Test {
    
    private String jmeno;
    private int points;
    private Instant startTime;
    private Instant endTime;
    private long timeDuration;

    public Test() {
    
    }
    
    public Test(String jmeno) {
        this.jmeno = jmeno;
    }
    
    /**
     * saves current time as start of test
     */
    public void setTestStart ()
    {
        this.startTime = Instant.now();
    }
    
    /**
     * saves current time as end of test and calculates duration of test
     */
    public void setTestEnd()
    {
        this.endTime = Instant.now();
        this.timeDuration = Duration.between(startTime, endTime).toMillis();
    }
    
    /**
     * adds one point by correct answer
     */
    public void addPoint()
    {
        this.points++;
    }
    
    /**
     * sends data to ResultFile to save them
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveResult() throws FileNotFoundException, IOException
    {
        ResultsFile resFile = new ResultsFile();
        resFile.addResults(jmeno, points, (int) timeDuration);
    }
    
    /**
     * 
     * @return result of person in string
     */
    public String getResult()
    {
        return jmeno + ": " + points + "points, " + timeDuration + "s";
    }

    /**
     * set name of tested subject
     * @param jmeno 
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
    
    /**
     * 
     * @param name
     * @return 0 - name correct, 1 - 1st letter isn't capital, 2 - name contains non-letter character, 3 - 2nd or next characters can't be capital, 4 - other problem
     */
    public int checkName (String name) {
        if (Pattern.matches("^[A-Z][a-z]+", name))
        {
            return 0;
        }
        else
        {
            if (!Pattern.matches("^[A-Z][0-9a-zA-Z]+", name))
            {
                return 1;
            }
            else if (!Pattern.matches(".[a-zA-Z]+", name))
            {
                return 2;
            }
            else if (!Pattern.matches(".[a-z]+", name))
            {
                return 3;
            }
            else 
            {
                return 4;
            }
        }
    }
    
}
