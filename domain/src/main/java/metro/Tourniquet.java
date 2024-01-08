package metro;
public class Tourniquet {

    private State state;

    public void push() {
        changeState(state.push());
    }
    public void insertValidTicket(){
        changeState(state.insertValidTicket());
    }

    public void insertNonValidTicket(){
        changeState(state.insertNonValidTicket());
    }
    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
