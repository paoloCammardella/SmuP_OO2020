package Entita;

import java.util.ArrayList;

public class Album {
	
	private String nome;
	private String genre;
	private String id_Album;
	private ArrayList<Brano> songs;
	
	public Album(String nome, String genre, String id_Album) {
		setNome(nome);
		setGenre(genre);
		setId_Album(id_Album);
	}
	
	public ArrayList<Brano> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<Brano> songs) {
		this.songs = songs;
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
}
