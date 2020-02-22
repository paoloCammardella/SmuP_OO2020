package Entita;

public class Album {
	
	private String id_Album;
	private String nome;
	private String genre;
	private int songNumber;

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

	@Override
	public String toString() {
		return getId_Album();
	}
}
