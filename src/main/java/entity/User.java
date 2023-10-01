package entity;

public class User {
	private int id;
	private String username;
	private String fullName;
	private String password;
	private String role;
	
	public User() {}
	
	public User(
		int id,
		String username,
		String fullName,
		String password,
		String role
	) {
		this.setId(id);
		this.setUsername(username);
		this.setFullName(fullName);
		this.setPassword(password);
		this.setRole(role);
	}
	
	public int getId() { return this.id; }
	public String getUsername() { return this.username; }
	public String getFullName() { return this.fullName; }
	public String getPassword() { return this.password; }
	public String getRole() { return this.role; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
}
