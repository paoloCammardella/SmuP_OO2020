package Entita;

public class Artista{
	
	private String fristName;
	private String lastName;
	private String nickname;
	private String id_Artist;
	private String birthDate;
	private String city;
	private int followers;
	
	public Artista(String id_Artist,  String firstName, String lastName, String city, String birthDate, String nickname, int followers) {
		setId_Artist(id_Artist);
		setFristName(firstName);
		setLastName(lastName);
		setCity(city);
		setBirthDate(birthDate);
		setNickname(nickname);
		setFollowers(0);
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
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
	
	@Override
	public String toString() {
		return getId_Artist();
	}
}



