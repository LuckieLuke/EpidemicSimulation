import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Simulation {

    private static int numberOfAgents;
    private static int friendsAvg;
    private static double socialProbability;
    private static double deathChance;
    private static double recoverChance;
    private static double meetingChance;
    private static double diseaseChance;
    private static final int numOfDays = 5;

    public static void main(String[] args) throws IOException {
        try {
            getProps();
        } catch(IOException e) {
            System.out.println("We've got a problem with properties' file!");
        }


        FriendsGraph fg = new FriendsGraph(numberOfAgents, friendsAvg, socialProbability, deathChance, recoverChance, meetingChance, diseaseChance);
        FileManager fm = new FileManager();
        fm.writeData(numberOfAgents, socialProbability, meetingChance, diseaseChance,
                recoverChance, deathChance, numOfDays, friendsAvg, fg);

        World world = new World(fg, numOfDays);
        ArrayList<Agent> friends = world.availableFriends(fg.getAgents()[0]);
        System.out.println("FINAL LIST:");
        world.printArrayList(friends);
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
