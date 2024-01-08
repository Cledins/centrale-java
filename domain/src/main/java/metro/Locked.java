package metro;

public class Locked extends State{
    private Tourniquet tourniquet;
    public State push() {
        return new Locked();
    }

    public State insertValidTicket() {
        return new Unlocked();
    }

    public State insertNonValidTicket() {
        return new Locked();
    }

}
