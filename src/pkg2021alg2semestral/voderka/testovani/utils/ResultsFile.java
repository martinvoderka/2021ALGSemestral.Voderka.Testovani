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
    Result result = new Result();
    ArrayList<Result> results = new ArrayList<Result>();

    /**
     * Reads all binary file 
     * @return ArrayList<Return> of results
     * @throws FileNotFoundException 
     */
    public ArrayList<Result> readResults () throws FileNotFoundException {
        String name;
        int points;
        int time;
        results.clear();
        try(DataInputStream dis = new DataInputStream(new FileInputStream(new File("data\\results.dat")))){
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
 
        } catch (IOException ex) {
            Logger.getLogger(ResultsFile.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        return results;
    }
    
    /**
     * Adds new result to the end of binary file
     * @param name - name of tested person
     * @param points - points gained throw test
     * @param time - time of test duration
     * @throws FileNotFoundException 
     */
    public void addResults(String name, int points, int time) throws FileNotFoundException{
        results.clear();
        results = readResults();
        Result res = new Result(name, points, time);
        results.add(res);
        
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("data\\results.dat")))){
            for (Result r : results) {
                dos.writeUTF(r.getName());
                dos.writeInt(r.getPoints());
                dos.writeInt(r.getTime());
            }
        } catch (IOException ex) {
            Logger.getLogger(ResultsFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
