package metro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestTourniquet {
    @Test
    public void testTourniquet(){
        Tourniquet lockedTourniquet = new Tourniquet();
        Tourniquet unlockedTourniquet = new Tourniquet();

        lockedTourniquet.changeState(new Locked());
        unlockedTourniquet.changeState(new Unlocked());

        lockedTourniquet.push();
        Assertions.assertInstanceOf(Locked.class, lockedTourniquet.getState());
        lockedTourniquet.insertNonValidTicket();
        Assertions.assertInstanceOf(Locked.class, lockedTourniquet.getState());
        lockedTourniquet.insertValidTicket();
        Assertions.assertInstanceOf(Unlocked.class, lockedTourniquet.getState());

        unlockedTourniquet.insertValidTicket();
        Assertions.assertInstanceOf(Unlocked.class, unlockedTourniquet.getState());
        unlockedTourniquet.insertNonValidTicket();
        Assertions.assertInstanceOf(Unlocked.class, unlockedTourniquet.getState());
        unlockedTourniquet.push();
        Assertions.assertInstanceOf(Locked.class, unlockedTourniquet.getState());
    }
}
