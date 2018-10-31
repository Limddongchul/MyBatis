package kh.mybatis.dto;

public class UsersDTO {
	String seq;
	String user_id;
	String password;
	String name;
	String email;
	
	public UsersDTO() {
		
	}
	
	public UsersDTO(String seq, String user_id, String password, String name, String email) {
		super();
		this.seq = seq;
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmai() {
		return email;
	}

	public void setEmai(String emai) {
		this.email = emai;
	}
	
	
}
