public class Meeting {

    private Agent[] agents;

    public Meeting(Agent a, Agent b) {
        agents = new Agent[2];
        agents[0] = a;
        agents[1] = b;
    }

    public boolean canGetSick() {
        if(agents[0].isAlive() && agents[0].isSick() && agents[1].isAlive() && !agents[1].isResistant())
            return true;
        else
            return false;
    }

    public Agent getHealthy() {
        if(agents[0].isSick())
            return agents[1];
        else
            return agents[0];
    }

}
