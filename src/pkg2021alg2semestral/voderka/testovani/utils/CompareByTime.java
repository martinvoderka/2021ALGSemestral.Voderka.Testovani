package pkg2021alg2semestral.voderka.testovani.utils;

import java.util.Comparator;

/**
 * Compares one result with another
 * @author Martin
 */
public class CompareByTime implements Comparator<Result> {

    /**
     * 
     * @param result1 - one result of Result
     * @param result2 - second result of Result
     * @return 
     */
    @Override
    public int compare(Result result1, Result result2) {
        return Integer.compare(result1.getTime(), result2.getTime());
    }
    
}
