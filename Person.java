
public class Person {
	public String _phoneNumber;
	public String _firstName;
	public String _lastName;
	
	public Person(String number, String last, String first){
		_phoneNumber = number;
		_lastName = last;
		_firstName = first;
	}
	
	public String getPhoneNumber(){
		return _phoneNumber;
	}
	
	public String getFirstName(){
		return _firstName;
	}
	
	public String getLastName(){
		return _lastName;
	}
}
