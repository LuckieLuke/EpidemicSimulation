import java.util.ArrayList;
import java.util.Random;

public class World {

    private int numberOfDays;
    private int endDay;
    private int sick;
    private int healthy;
    private int resistant;
    FriendsGraph graph;
    public double deathChance;
    public double recoverChance;
    public double meetingChance;
    public double diseaseChance;
    Random rand = new Random();

    public World(FriendsGraph graph, double deathChance, double recoverChance, double meetingChance, double diseaseChance, int endDay) {
        numberOfDays = 0;
        this.graph = graph;
        this.deathChance = deathChance;
        this.recoverChance = recoverChance;
        this.meetingChance = meetingChance;
        this.diseaseChance = diseaseChance;
        this.endDay = endDay;

        startSimulation();
    }

    private void startSimulation() {
        while(numberOfDays < endDay) {

            numberOfDays++;
        }
    }

}
