package pkg2021alg2semestral.voderka.testovani.utils;

/**
 *
 * @author Martin
 */
public class Result implements Comparable<Result> {
    
    public String name;
    public int points;
    public int time;
    
    public Result(){
        
    }
    
    public Result(String name, int points, int time){
        this.name = name;
        this.points = points;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getTime() {
        return time;
    }
    
    @Override
    public int compareTo(Result otherPlayer) {
        return Integer.compare(getPoints(), otherPlayer.getPoints());
    }
    
}
