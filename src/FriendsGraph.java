import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FriendsGraph {

    private ArrayList<Agent>[] graph;
    private Agent[] agents;
    private int numOfAgents;
    private int avgFriends;

    public FriendsGraph(int numOfAgents, int avgFriends, double socialProbability, double death, double rec, double meet, double dis) {
        this.numOfAgents = numOfAgents;
        this.avgFriends = avgFriends;

        Random rand = new Random();
        agents = new Agent[numOfAgents];
        for(int i = 0; i < numOfAgents; i++) {
            double chance = rand.nextDouble();
            agents[i] = new Agent(i+1, chance < socialProbability ? AgentType.SOCIAL : AgentType.RESERVED, death, rec, meet, dis);
        }
        int sickNum = rand.nextInt(numOfAgents);
        agents[sickNum].sicken();

        makeGraph();
    }

    private void makeGraph() {
        Random rand = new Random();
        graph = new ArrayList[numOfAgents];
        for(int i = 0; i < numOfAgents; i++)
            graph[i] = new ArrayList<>();

        int x, y;
        for(int i = 0; i < avgFriends; i++) {
            x = rand.nextInt(numOfAgents);
            do {
                y = rand.nextInt(numOfAgents);
            } while (x == y);
            if(!graph[x].contains(agents[y])) {
                graph[x].add(agents[y]);
                graph[y].add(agents[x]);
            }
            else
                i--;
        }
    }

    public Agent[] getAgents() {
        return agents;
    }

    public ArrayList<Agent>[] getGraph() {
        return graph;
    }

    public ArrayList<Agent> getFriendsOfX(Agent x) {
        int i = 0;
        int num = 0;
        while(i < numOfAgents) {
            if(agents[i] == x) {
                num = i;
                i = numOfAgents;
            }
            i++;
        }
        ArrayList<Agent> copy = new ArrayList<>(graph[num]);
        return copy;
    }

    public int getNumOfAgents() {
        return numOfAgents;
    }

    public void printAgents() {
        for(int i = 0; i < numOfAgents; i++)
            System.out.println(agents[i]);
    }

    public void printGraph() {
        for(int i = 0; i < numOfAgents; i++) {
            System.out.print((i+1) + " ");
            for(Agent a: graph[i]) {
                System.out.print(a.getId() + " ");
            }
            System.out.println();
        }
    }

}
