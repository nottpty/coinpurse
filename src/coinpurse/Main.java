package coinpurse;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Patinya Yongyai
 */
public class Main {
	private static int CAPACITY = 3;

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	Purse purse = new Purse(CAPACITY);
    	ConsoleDialog ui = new ConsoleDialog( purse );
    	ui.run();
    }
}
