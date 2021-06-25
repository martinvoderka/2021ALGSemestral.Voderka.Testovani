package pkg2021alg2semestral.voderka.testovani.utils;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to read binary file or add next result to binary file
 * @author Martin
 */
public class ResultsFile {
    private ArrayList<Result> results = new ArrayList<Result>();
    private String resultFile;

    public ResultsFile() throws FileNotFoundException, IOException 
    {
        readResults();
    }
    
    public ResultsFile (String file) throws FileNotFoundException, IOException
    {
        resultFile = file;
        readResults();
    }

    /**
     * Reads all binary file 
     * @throws FileNotFoundException 
     */
    public void readResults () throws FileNotFoundException, IOException {
        String name;
        int points;
        int time;
        results.clear();
        DataInputStream dis = new DataInputStream(new FileInputStream(new File("data\\" + resultFile)));
            boolean end = false;
            while(!end){
                try{
                    name = dis.readUTF();
                    points = dis.readInt();
                    time = dis.readInt();
                    Result res = new Result(name, points, time);
                    results.add(res);
                } catch(EOFException e){
                    end = true;
                }
            }
    }
    
    /**
     * Adds new result to the end of binary file
     * @param name - name of tested person
     * @param points - points gained throw test
     * @param time - time of test duration
     * @throws FileNotFoundException 
     */
    public void addResults(String name, int points, int time) throws FileNotFoundException, IOException{
        Result res = new Result(name, points, time);
        results.add(res);
        
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("data\\" + resultFile)));
            for (Result r : results) {
                dos.writeUTF(r.getName());
                dos.writeInt(r.getPoints());
                dos.writeInt(r.getTime());
            }
        
        
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResultFile(String resultFile) {
        this.resultFile = resultFile;
    }
    
    
}
