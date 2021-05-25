package pkg2021alg2semestral.voderka.testovani.utils;

import java.util.Comparator;

/**
 *
 * @author Martin
 */
public class CompareByTime implements Comparator<Result> {

    @Override
    public int compare(Result result1, Result result2) {
        return Integer.compare(result1.getTime(), result2.getTime());
    }
    
}
