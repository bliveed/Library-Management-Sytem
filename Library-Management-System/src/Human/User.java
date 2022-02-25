package Human;
import java.sql.Date;

public class User extends Person {
	
	public User(String name,String surname,String email,String password,Date birthday,String gender,String status) {
		super(name,surname,email,password,birthday,gender,"User");
	}
	public User() {}

}
