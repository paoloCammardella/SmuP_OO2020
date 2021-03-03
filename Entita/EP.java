package Entita;

import java.util.ArrayList;

public class EP {

	private String name;
	private String id_EP;
	private ArrayList<Pubblica> pubblica;

	public EP(String name, String EP) {
		setName(name);
		setId_EP(EP);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_EP() {
		return id_EP;
	}
	public void setId_EP(String id_EP) {
		this.id_EP = id_EP;
	}

	public ArrayList<Pubblica> getPubblica() {
		return pubblica;
	}

	public void setPubblica(ArrayList<Pubblica> pubblica) {
		this.pubblica = pubblica;
	}
}
