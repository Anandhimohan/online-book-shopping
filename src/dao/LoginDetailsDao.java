package dao;

import model.UserDetails;

public interface LoginDetailsDao {
	public boolean signUp(UserDetails user);
	public String signIn(UserDetails user);
	public boolean updateUser(String username);
	public boolean deleteUser(String username);
	public void getBooks();
}
