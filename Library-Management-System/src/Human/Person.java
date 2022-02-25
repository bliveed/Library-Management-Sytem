package Human;
import java.sql.Date;

import Connection.Database;

public class Person {
	
	protected String name;
	protected String surname;
	protected String email;
	protected Date birthday;
	private String password;
	private int id;
	protected String status;
	protected String gender;
	
	Database data = new Database();
	
	public Person() {}
	
	public Person(String name,String surname,String email,String password,Date birthday,String gender,String status) {
		this.name=name;
		this.surname=surname;
		this.email=email;
		this.password=password;
		this.birthday=birthday;
		this.status=status;
		this.gender=gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String status) {
		this.gender = gender;
	}

}
