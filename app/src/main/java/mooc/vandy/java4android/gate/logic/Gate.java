package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    public static final int IN = 1;
    private int mSwing;

    public Gate() {
    }

    public void close() {
        mSwing = CLOSED;
    }

    public int getSwingDirection() {
        return mSwing;
    }
    public boolean setSwing(int direction) {
        if (direction == IN || direction == OUT || direction == CLOSED) {
            mSwing = direction;
            return true;
        }
        return false;
    }

    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            return setSwing(direction);
        }
        return false;
    }

    public int thru(int count) {
        if (mSwing == IN) {
            return count;
        }
        if (mSwing == OUT) {
            return -count;
        }
        return 0;
    }

    @Override
    public String toString() {
        if (mSwing == CLOSED) {
            return "This gate is closed";
        }
        if (mSwing == IN) {
            return "This gate is open and swings to enter the pen only";
        }
        if (mSwing == OUT) {
            return "This gate is open and swings to exit the pen only";
        }
        return "This gate has an invalid swing direction";
    }


}
