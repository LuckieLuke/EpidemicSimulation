import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {

    public void writeData(int numOfAgents, double socialProb, double meetProb, double disProb, double recProb,
                                 double deathProb, int numOfDays, int avgFriends, FriendsGraph graph) throws IOException {
        PrintWriter pw = new PrintWriter("result.txt");

        pw.append("number of agents=").append(String.valueOf(numOfAgents));
        pw.append("\nsocial probability=").append(String.valueOf(socialProb));
        pw.append("\nmeeting probability=").append(String.valueOf(meetProb));
        pw.append("\ndisease probability=").append(String.valueOf(disProb));
        pw.append("\nrecovery probability=").append(String.valueOf(recProb));
        pw.append("\ndeath probability=").append(String.valueOf(deathProb));
        pw.append("\nnumber of days=").append(String.valueOf(numOfDays));
        pw.append("\naverage friends=").append(String.valueOf(avgFriends));

        writeAgents(pw, graph);
        writeGraph(pw, graph, numOfAgents);

        pw.append("\n#stats in the next days\n");

        pw.close();
    }

    private void writeAgents(PrintWriter pw, FriendsGraph graph) throws IOException {
        pw.append("\n\n# agents as: id type or id* type if sick\n");
        Agent[] agents = graph.getAgents();
        for(int i = 0; i < agents.length; i++) {
            pw.append(agents[i].toString());
        }
    }

    private void writeGraph(PrintWriter pw, FriendsGraph graph, int numOfAgents) throws IOException{
        pw.append("\n#graph of friends\n");
        ArrayList<Agent>[] friends = graph.getGraph();
        for(int i = 0; i < numOfAgents; i++) {
            pw.append(String.valueOf(i+1)).append(" ");
            for(Agent a: friends[i]) {
                pw.append(String.valueOf(a.getId())).append(" ");
            }
            pw.append("\n");
        }
    }

    public void writeStats(int healthy, int sick, int resistant) throws IOException {
        FileWriter fw = new FileWriter("result.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(healthy + " ");
        pw.print(sick + " ");
        pw.println(resistant);
        pw.close();
    }

}
