public class Agent {

    private int id;
    private AgentType type;
    private boolean resistant;
    private boolean sick;
    private boolean alive;

    private double deathChance;
    private double recoverChance;
    private double meetingChance;
    private double diseaseChance;

    public Agent(int id, AgentType type, double death, double rec, double meet, double dis) {
        this.id = id;
        this.type = type;
        resistant = false;
        alive = true;
        deathChance = death;
        recoverChance = rec;
        meetingChance = meet;
        diseaseChance = dis;
    }

    public AgentType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public boolean isResistant() {
        return resistant;
    }

    public void sicken() {
        sick = true;
        meetingChance /= 2;
    }

    public void recover() {
        sick = false;
        resistant = true;
        meetingChance *= 2;
    }

    public boolean isSick() {
        return sick;
    }

    public boolean isAlive() {
        return alive;
    }

    public double getDeathChance() {
        return deathChance;
    }

    public double getRecoverChance() {
        return recoverChance;
    }

    public double getDiseaseChance() {
        return diseaseChance;
    }

    public double getMeetingChance() {
        return meetingChance;
    }

    public void die() {
        alive = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        if(sick)
            sb.append("*");
        sb.append(" ").append(String.format("%s\n", type).toLowerCase());
        return sb.toString();
    }
}
