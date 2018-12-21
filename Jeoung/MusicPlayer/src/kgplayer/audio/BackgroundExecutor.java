package kgplayer.audio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Using this for computing outside swing UI thread
 * @author Pierluigi
 *
 */
public class BackgroundExecutor {

	private static ExecutorService backgroundEx = Executors.newCachedThreadPool(); 
	
	public BackgroundExecutor(){}
	
	public static ExecutorService get() { return backgroundEx;}
}
