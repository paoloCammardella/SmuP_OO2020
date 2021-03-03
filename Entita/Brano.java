package Entita;

public class Brano {

	private String name;
	private String duration;
	private String genre;
	private Album brano;

	public Brano(String name, String artist, String duration, String genre) {
		setName(name);
		setDuration(duration);
		setGenre(genre);
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Album getBrano() {
		return brano;
	}

	public void setBrano(Album brano) {
		this.brano = brano;
	}
}
