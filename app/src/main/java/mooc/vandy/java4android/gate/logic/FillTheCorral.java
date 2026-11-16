package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    public void CorralGates(Gate[] corral,Random Rand){

    }

    public void setCorralGates(Gate[] corral, Random randomNumber) {
        mOut.println("Initial gate setup:");
        for (int i = 0; i < corral.length; i++) {
            corral[i].setSwing(randomNumber.nextInt(3) - 1);
            mOut.println("Gate " + i + ": " + corral[i]);
        }
    }

    public boolean anyCorralAvailable(Gate[] corral) {
        for (Gate gate : corral) {
            if (gate.getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }

    public int corralSnails(Gate[] corral, Random randomNumber) {
        int pastureCount = 5;
        int attempts = 0;

        while (pastureCount > 0) {
            int gateIndex = randomNumber.nextInt(corral.length);
            int snailsToMove = randomNumber.nextInt(pastureCount) + 1;

            mOut.println(snailsToMove + " are trying to move through corral "
                    + gateIndex);


            pastureCount -= corral[gateIndex].thru(snailsToMove);

            attempts++;
        }

        mOut.println("It took " + attempts
                + " attempts to corral all of the snails.");
        return attempts;
    }
}
