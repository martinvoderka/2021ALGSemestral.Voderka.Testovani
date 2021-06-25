package pkg2021alg2semestral.voderka.testovani.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import pkg2021alg2semestral.voderka.testovani.utils.CompareByTime;
import pkg2021alg2semestral.voderka.testovani.utils.Result;
import pkg2021alg2semestral.voderka.testovani.utils.ResultsFile;

/**
 * Class to sort ArrayList of results
 * @author Martin
 */
public class Comparing { 
    
    private ArrayList<Result> resultsAL; 

    public Comparing() throws FileNotFoundException {
        
    }
    
    /**
     * Sorting ArrayList of results by points
     * @return Sorted Arraylist in one String
     * @throws FileNotFoundException 
     */
    public String compareBy(int choice) throws FileNotFoundException{
        switch (choice)
        {
            case 1:
                Collections.sort(resultsAL);
                break;
            case 2: 
                CompareByTime timeComparator = new CompareByTime();
                Collections.sort(resultsAL, timeComparator);
                break;
        }
        
        return listToString();
    }
    
    public String listToString ()
    {
        StringBuilder sb = new StringBuilder();
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
    
    public void setFileName(String file) throws FileNotFoundException, IOException
    {
        ResultsFile resFile = new ResultsFile(file);
        this.resultsAL = resFile.getResults();
    }
    
}
