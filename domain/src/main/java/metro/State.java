package metro;

public abstract class State {
    public abstract State push();
    public abstract State insertValidTicket();
    public abstract State insertNonValidTicket();

}
