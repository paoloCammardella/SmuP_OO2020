package Entita;

import java.util.ArrayList;

public class Singolo {
	
	private String id_Single;
	private String nameSingle;
	private int duration;
	private String genere;
	private ArrayList<Pubblica> pubblica;
	
	public String getNameSingle() {
		return nameSingle;
	}
	public void setNameSingle(String nameSingle) {
		this.nameSingle = nameSingle;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public String getId_Single() {
		return id_Single;
	}
	public void setId_Single(String id_Single) {
		this.id_Single = id_Single;
	}
	
	public ArrayList<Pubblica> getPubblica() {
		return pubblica;
	}
	public void setPubblica(ArrayList<Pubblica> pubblica) {
		this.pubblica = pubblica;
	}
}
