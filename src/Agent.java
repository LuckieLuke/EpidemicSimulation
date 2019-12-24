public class Agent {

    private int id;
    private AgentType type;
    private boolean resistant;
    private boolean sick;
    private boolean alive;

    public Agent(int id, AgentType type) {
        this.id = id;
        this.type = type;
        resistant = false;
        alive = true;
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
    }

    public void recover() {
        sick = false;
        resistant = true;
    }

    public boolean isSick() {
        return sick;
    }

    public boolean isAlive() {
        return alive;
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
