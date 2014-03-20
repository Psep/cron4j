package cl.psep.cron4j.main;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import cl.psep.cron4j.beans.CronBean;
import cl.psep.cron4j.utils.Constantes;
import cl.psep.cron4j.utils.CronException;

/**
 * @author psep
 * 
 */
public final class Cron4J extends Constantes {

	/**
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static final Boolean createCron(Object object) throws Exception {
		if (object instanceof CronBean) {
			CronBean cron = (CronBean) object;
			return Cron4J.processCron(cron);
		} else if (object instanceof List<?>) {
			List<?> jobs = (List<?>) object;
			return Cron4J.processList(jobs);
		} else {
			return false;
		}
	}

	/**
	 * @param jobs
	 * @return
	 * @throws Exception
	 */
	private static final Boolean processList(List<?> jobs) throws Exception {
		if (jobs.size() == 0) {
			throw new CronException("La lista de cron está vacía");
		} else if (jobs.get(0) instanceof CronBean) {
			Iterator<?> jobsIter = jobs.iterator();

			while (jobsIter.hasNext()) {
				CronBean cron = (CronBean) jobsIter.next();

				if (!Cron4J.processCron(cron)) {
					return false;
				}
			}

			return true;

		} else {
			throw new CronException(
					"La lista de cron no corresponde a objetos de tipo CronBean");
		}
	}

	/**
	 * @param cron
	 * @return
	 */
	private static final Boolean processCron(CronBean cron) {
		boolean result = false;
		PrintWriter pw = null;
		String espacio = " ";

		try {
			FileWriter cronFile = new FileWriter(cron.getPath());

			StringBuilder row = new StringBuilder();
			row.append(cron.getMinutos());
			row.append(espacio);
			row.append(cron.getHoras());
			row.append(espacio);
			row.append(cron.getMeses());
			row.append(espacio);
			row.append(cron.getDias());
			row.append(espacio);
			row.append(cron.getUser());
			row.append(espacio);
			row.append(cron.getCmd());

			pw = new PrintWriter(cronFile);
			pw.println(row.toString());

			result = Cron4J.createCronCMD(cron);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

		return result;
	}

	/**
	 * @param file
	 * @return
	 */
	private static final Boolean createCronCMD(CronBean cron) {
		return Cron4J.executeCommand(CRON + cron.getPath());
	}

	/**
	 * @param command
	 * @return
	 */
	private static final Boolean executeCommand(String command) {
		boolean result = false;

		try {
			Runtime.getRuntime().exec(command);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * @return
	 */
	public static final Boolean deleteAllCron() {
		return Cron4J.executeCommand(DELETECRON);
	}

}
