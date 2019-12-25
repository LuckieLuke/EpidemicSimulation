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
    private Day[] days;
    private Random rand = new Random();

    public World(FriendsGraph graph, int endDay) throws IOException{
        dayNumber = 0;
        this.graph = graph;
        this.endDay = endDay;

        resistant = 0;
        sick = 1;
        healthy = graph.getNumOfAgents()-1;

        days = new Day[endDay];
        for(int i = 0; i < endDay; i++)
            days[i] = new Day(i);

        startSimulation();
    }

    public void startSimulation() throws IOException {
        FileManager fm = new FileManager();
        while(dayNumber < endDay) {
            days[dayNumber].dieOrRecover(graph);
            planMeetings(dayNumber);
            days[dayNumber].meet();
            updateHSR();
            fm.writeStats(healthy, sick, resistant);
            dayNumber++;
        }
    }

    public void updateHSR() {
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

    public void planMeetings(int dayNumber) {
        Agent[] agents = graph.getAgents();
        ArrayList<Agent> friends;
        Random rand = new Random();
        double meet;
        int day;
        Agent toMeet;

        for(Agent a: agents) {
            meet = rand.nextDouble();
            while(meet < a.getMeetingChance()) {
                day = meetingDay(dayNumber);
                friends = availableFriends(a);
                Agent b = chooseAgentToMeet(friends);

                days[day].addMeetingOnDay(a, b, day);

                meet = rand.nextDouble();
            }
        }
    }

    public int meetingDay(int dayNumber) {
        Random rand = new Random();
        return rand.nextInt(endDay - dayNumber) + dayNumber;
    }

    public ArrayList<Agent> availableFriends(Agent x) {
        ArrayList<Agent> agents = graph.getFriendsOfX(x);
        ArrayList<Agent> toDo = graph.getFriendsOfX(x);

        if(x.getType() == AgentType.SOCIAL) {
            for(Agent a: toDo) {
                agents.addAll(graph.getFriendsOfX(a)); //możliwe, że doda powtórki, w szczególności samego źródło
            }
        }

        return agents;
    }

    public Agent chooseAgentToMeet(ArrayList<Agent> agents) {
        Random rand = new Random();
        int x = rand.nextInt(agents.size());
        return agents.get(x);
    }

}
