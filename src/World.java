import java.util.ArrayList;

public class World {

    private int numberOfDays;
    private int sick;
    private int healthy;
    private int resistant;
    FriendsGraph graph;
    public double deathChance;
    public double recoverChance;
    public double meetingChance;
    public double diseaseChance;

    public World(FriendsGraph graph, double deathChance, double recoverChance, double meetingChance, double diseaseChance) {
        numberOfDays = 0;
        this.graph = graph;
        this.deathChance = deathChance;
        this.recoverChance = recoverChance;
        this.meetingChance = meetingChance;
        this.diseaseChance = diseaseChance;

        startSimulation();
    }

    private void startSimulation() {

    }

}
