package DAO;

import java.sql.ResultSet;

public interface FollowingDAO {
	public void insertFollow(String id_User, String id_Artist);
	public void removeFollow(String id_User, String id_Following);
	public ResultSet printFollow(String id_User);
}
