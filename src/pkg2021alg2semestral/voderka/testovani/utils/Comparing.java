package pkg2021alg2semestral.voderka.testovani.utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Class to sort ArrayList of results
 * @author Martin
 */
public class Comparing {
    
    static ResultsFile resFile = new ResultsFile();
    
    /**
     * Sorting ArrayList of results by points
     * @return Sorted Arraylist in one String
     * @throws FileNotFoundException 
     */
    public String compareByPoints() throws FileNotFoundException{
        StringBuilder sb = new StringBuilder();
        Result result = new Result();
        ArrayList<Result> resultsAL = resFile.readResults();
        Collections.sort(resultsAL);
        Collections.reverse(resultsAL);
        for (Result r : resultsAL) 
        {
            sb.append(r.getName());
            sb.append(" - ");
            sb.append(r.getPoints());
            sb.append(" points, ");
            sb.append(r.getTime());
            sb.append(" sec");
            sb.append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Sorting ArrayList of results by points
     * @return Sorted Arraylist in one String
     * @throws FileNotFoundException 
     */
    public String compareByTime() throws FileNotFoundException{
        StringBuilder sb = new StringBuilder();
        CompareByTime timeComparator = new CompareByTime();
        Result result = new Result();
        ArrayList<Result> resultsAL = resFile.readResults();
        Collections.sort(resultsAL, timeComparator);
        for (Result r : resultsAL) {
            sb.append(r.getName());
            sb.append(" - ");
            sb.append(r.getPoints());
            sb.append(" points, ");
            sb.append(r.getTime());
            sb.append(" sec");
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}
