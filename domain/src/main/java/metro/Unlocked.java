package metro;

public class Unlocked extends State{
    private Tourniquet tourniquet;
    public State push() {
        return new Locked();
    }

    public State insertValidTicket() {
        return new Unlocked();
    }

    public State insertNonValidTicket() {
        return new Unlocked();
    }
}
