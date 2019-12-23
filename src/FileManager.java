import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

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

        pw.close();
    }

    private void writeAgents(PrintWriter pw, FriendsGraph graph) throws IOException {
        pw.append("\n\n").append("# agents as: id type or id* type if sick").append('\n');
        Agent[] agents = graph.getAgents();
        for(int i = 0; i < agents.length; i++) {
            pw.append(agents[i].toString());
        }
    }

}
