import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Simulation {

    public static int numberOfAgents;
    public static int friendsAvg;
    public static double socialProbability;
    public static double deathChance;
    public static double recoverChance;
    public static double meetingChance;
    public static double diseaseChance;

    public static void main(String[] args) {
        try {
            getProps();
        } catch(IOException e) {
            System.out.println("We've got a problem with properties' file!");
        }

        FriendsGraph fg = new FriendsGraph(numberOfAgents, friendsAvg, socialProbability);
        fg.printGraph();
    }

    private static void getProps() throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propPath = rootPath + "default.properties";
        Properties props = new Properties();
        props.load(new FileInputStream(propPath));

        numberOfAgents = Integer.parseInt(props.getProperty("numberOfAgents"));
        friendsAvg = Integer.parseInt(props.getProperty("friendsAvg"));
        socialProbability = Double.parseDouble(props.getProperty("socialProbability"));
        deathChance = Double.parseDouble(props.getProperty("deathChance"));
        recoverChance = Double.parseDouble(props.getProperty("recoverChance"));
        meetingChance = Double.parseDouble(props.getProperty("meetingChance"));
        diseaseChance = Double.parseDouble(props.getProperty("diseaseChance"));
    }
}
