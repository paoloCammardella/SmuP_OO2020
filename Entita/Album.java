package Entita;

import java.util.ArrayList;

public class Album {
	
	private String id_Album;
	private String nome;
	private String genre;
	private int songNumber;
	private ArrayList<Pubblica> pubblica;
	private ArrayList<Brano> brano;

	public Album(String id_Album,String nome, String genre, int songNumber) {
		setId_Album(id_Album);
		setNome(nome);
		setGenre(genre);
		setSongNumber(songNumber);
	}

	public int getSongNumber() {
		return songNumber;
	}
	public void setSongNumber(int songNumber) {
		this.songNumber = songNumber;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getId_Album() {
		return id_Album;
	}
	public void setId_Album(String id_Album) {
		this.id_Album = id_Album;
	}
	
	public ArrayList<Brano> getBrano() {
		return brano;
	}

	public void setBrano(ArrayList<Brano> brano) {
		this.brano = brano;
	}
	
	public ArrayList<Pubblica> getPubblica() {
		return pubblica;
	}

	public void setPubblica(ArrayList<Pubblica> pubblica) {
		this.pubblica = pubblica;
	}

	@Override
	public String toString() {
		return getId_Album() + ", " + getNome();
	}
}
