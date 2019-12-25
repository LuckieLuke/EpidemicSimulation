import java.util.ArrayList;
import java.util.Random;

public class Day {

    private int number;
    private ArrayList<Meeting> meetings;

    public Day(int nr) {
        number = nr;
        meetings = new ArrayList<>();
    }

    public void dieOrRecover(FriendsGraph graph) {
        Agent[] agents = graph.getAgents();
        Random rand = new Random();
        double deathProb, recoveryProb;
        for(Agent a: agents) {
            if(a.isAlive() && a.isSick()) {
                deathProb = rand.nextDouble();
                if(deathProb <= a.getDeathChance()) {
                    a.die();
                }
                if(a.isAlive()) {
                    recoveryProb = rand.nextDouble();
                    if(recoveryProb <= a.getRecoverChance()) {
                        a.recover();
                    }
                }
            }
        }
    }

    public void meet() {
        Random rand = new Random();
        double sickenChance;
        for(Meeting m: meetings) {
            if(m.canGetSick()) {
                Agent a = m.getHealthy();
                sickenChance = rand.nextDouble();
                if(sickenChance < a.getDiseaseChance())
                    a.sicken();
            }
        }
    }

    public void addMeeting(Agent a, Agent b) {
        meetings.add(new Meeting(a, b));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Day number %d:\n", number));
        for(Meeting m: meetings) {
            sb.append(m.toString());
        }
        return sb.toString();
    }

}
