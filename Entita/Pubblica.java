package Entita;

import java.util.Date;

public class Pubblica {

	private Date releaseDate;
	private Artista artist;
	private Album album;
	private Singolo single;
	private EP ep;

	public Pubblica(Date releaseDate) {
		setReleaseDate(releaseDate);
	}

	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Artista getArtist() {
		return artist;
	}
	public void setArtist(Artista artist) {
		this.artist = artist;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Singolo getSingle() {
		return single;
	}
	public void setSingle(Singolo single) {
		this.single = single;
	}
	public EP getEp() {
		return ep;
	}
	public void setEp(EP ep) {
		this.ep = ep;
	}
}
