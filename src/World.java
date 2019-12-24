import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class World {

    private int dayNumber;
    private int endDay;
    private int sick;
    private int healthy;
    private int resistant;
    private FriendsGraph graph;
    public double deathChance;
    public double recoverChance;
    public double meetingChance;
    public double diseaseChance;
    private Day[] days;
    private Random rand = new Random();

    public World(FriendsGraph graph, double deathChance, double recoverChance, double meetingChance, double diseaseChance, int endDay) throws IOException{
        dayNumber = 0;
        this.graph = graph;
        this.deathChance = deathChance;
        this.recoverChance = recoverChance;
        this.meetingChance = meetingChance;
        this.diseaseChance = diseaseChance;
        this.endDay = endDay;

        resistant = 0;
        sick = 1;
        healthy = graph.getNumOfAgents()-1;

        days = new Day[endDay];
        for(int i = 0; i < endDay; i++)
            days[i] = new Day(i);

        startSimulation();
    }

    private void startSimulation() throws IOException {
        FileManager fm = new FileManager();
        while(dayNumber < endDay) {

            updateHSR();
            fm.writeStats(healthy, sick, resistant);
            dayNumber++;
        }
    }

    private void updateHSR() {
        Agent[] agents = graph.getAgents();
        healthy = sick = resistant = 0;
        for(int i = 0; i < agents.length; i++) {
            if(agents[i].isSick())
                sick++;
            else
                healthy++;
            if(agents[i].isResistant())
                resistant++;
        }
    }

}
