package su.bnair.bpassword.models;

public class StoredInformation {
	
	private int id;
	private String name;
	private String url;
	private String user;
	private String password;
	
	public StoredInformation(String name, String url, String user, String password) {
		this.name = name;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public StoredInformation(int id, String name, String url, String user, String password) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return getName();
	}
}
