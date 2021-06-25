package pkg2021alg2semestral.voderka.testovani.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import pkg2021alg2semestral.voderka.testovani.utils.ResultsFile;

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

    public Test(String jmeno) {
        this.jmeno = jmeno;
    }
    
    public void setTestStart ()
    {
        this.startTime = Instant.now();
    }
    
    public void setTestEnd()
    {
        this.endTime = Instant.now();
        this.timeDuration = Duration.between(startTime, endTime).toMillis();
    }
    
    public void addPoint()
    {
        this.points++;
    }
    
    public void saveResult() throws FileNotFoundException, IOException
    {
        ResultsFile resFile = new ResultsFile();
        resFile.addResults(jmeno, points, (int) timeDuration);
    }
    public String getResult()
    {
        return jmeno + ": " + points + "points, " + timeDuration + "s";
    }
    
}
