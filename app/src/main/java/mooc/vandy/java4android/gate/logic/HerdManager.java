package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;
    public static final int HERD = 24;


    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }
    // TODO -- Fill your code in here

    public void simulateHerd(Random randomNumber) {
        int snailCount = HERD;

        mOut.println("There are currently " + snailCount
                + " snails in the pen and " + (HERD - snailCount)
                + " snails in the pasture");

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            int randomGate = 0;

            if (snailCount != HERD && snailCount != 0)
                randomGate = randomNumber.nextInt(2);

            int snailsToMove;

            if (snailCount == HERD) {
                snailsToMove = randomNumber.nextInt(snailCount) + 1;
                snailCount += mEastGate.thru(snailsToMove);
            } else if (snailCount == 0) {
                snailsToMove = randomNumber.nextInt(HERD) + 1;
                snailCount += mWestGate.thru(snailsToMove);
            } else if (randomGate == 0) {
                snailsToMove = randomNumber.nextInt(HERD - snailCount) + 1;
                snailCount += mWestGate.thru(snailsToMove);
            } else {
                snailsToMove = randomNumber.nextInt(snailCount) + 1;
                snailCount += mEastGate.thru(snailsToMove);
            }

            mOut.println("There are currently " + snailCount
                    + " snails in the pen and " + (HERD - snailCount)
                    + " snails in the pasture");
        }
    }


    
}
