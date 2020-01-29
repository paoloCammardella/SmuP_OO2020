
package Entita;

import java.util.Date;

public class Artista{
	
	private String fristName;
	private String lastName;
	private String nickname;
	private String id_Artist;
	private Date birthDate;
	private String city;
	private int followers;
	
	public Artista(String city, String firstName, String lastName, String nickname, String id_Artist, Date birthDate, int followers) {
		setCity(city);
		setFristName(firstName);
		setLastName(lastName);
		setId_Artist(id_Artist);
		setNickname(nickname);
		setFollowers(0);
		setBirthDate(birthDate);
	}
	
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getId_Artist() {
		return id_Artist;
	}
	public void setId_Artist(String id_Artist) {
		this.id_Artist = id_Artist;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
}



