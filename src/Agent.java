public class Agent {

    private int id;
    private AgentType type;
    private boolean resistant;
    private boolean sick;

    public Agent(int id, AgentType type) {
        this.id = id;
        this.type = type;
        resistant = false;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(' ').append(type);
        return sb.toString();
    }
}
