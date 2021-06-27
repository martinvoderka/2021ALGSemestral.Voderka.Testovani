package pkg2021alg2semestral.voderka.testovani.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class Questions {
    private ArrayList<String> otazky = new ArrayList<String>();
    private ArrayList<String> odpovedi = new ArrayList<String>();

    public Questions(String otazkyP, String odpovediP) throws FileNotFoundException, IOException 
    {
        BufferedReader otazkyR = new BufferedReader(new FileReader("data\\" + otazkyP));
        BufferedReader odpovediR = new BufferedReader(new FileReader("data\\" + odpovediP));
        String otazka, odpoved;
        while((otazka = otazkyR.readLine()) != null)
        {
            odpoved = odpovediR.readLine();
            otazky.add(otazka);
            odpovedi.add(odpoved);
        }
        
    }
    
    /**
     * 
     * @return number of questions in private list
     */
    public int getNumberOfQuestions()
    {
        return otazky.size();
    }
    
    /**
     * 
     * @param cisloOtazky
     * @return question on index from param
     */
    public String getQuestion (int cisloOtazky)
    {
        return otazky.get(cisloOtazky - 1);
    }
    
    /**
     * 
     * @param cislo odpovedi
     * @return answer on index from param
     */
    public String getOdpoved(int cislo)
    {
        return odpovedi.get(cislo - 1);
    }
    
    /**
     * 
     * @param odpovedUzivatele
     * @param cisloOtazky - index of answer
     * @return true if userAnswer equals answer on index from param
     */
    public boolean isCorrect (String odpovedUzivatele, int cisloOtazky)
    {
        return odpovedi.get(cisloOtazky - 1).toLowerCase().equals(odpovedUzivatele.toLowerCase());
    }
    
}
