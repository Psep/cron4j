package cl.psep.cron4j.utils;

/**
 * @author psep
 *
 */
public class CronException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8981896408733613256L;
	
	/**
	 * @param msg
	 */
	public CronException(String msg){
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public CronException(String msg, Throwable t){
		super(msg, t);
	}

}
