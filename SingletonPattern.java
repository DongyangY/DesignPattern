/*
 * The Singleton Pattern ensures a class has only one instance, and provides a 
 * global point of access to it.
 */

public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {}

    // Synchronized for multithreading situation
    public static synchronized Singleton getInstance() {
	if (uniqueInstance == null) {
	    uniqueInstance = new Singleton();
	}
	return uniqueInstance;
    }
}
