package cl.psep.cron4j.beans;

import java.io.Serializable;

/**
 * @author psep
 *
 */
public class CronBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7916148084400956484L;
	private String path;
	private String cmd;
	private String minutos;
	private String horas;
	private String dias;
	private String meses;
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}
	
}
