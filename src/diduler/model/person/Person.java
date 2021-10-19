package diduler.model.person;

public class Person implements java.io.Serializable
{
	private String name;
	private String email;
	private String phone;
	private String birthday;
	public Person()
	{
		;
	}
	public Person(String name)
	{
		this.name = name;
	}
	public Person(String name,String email)
	{
		this(name);
		this.email=email;
	}
	public Person(String name,String email,String phone)
	{
		this(name,email);
		this.phone=phone;
	}
	public Person(String name,String email,String phone,String birthday)
	{
		this(name,email,phone);
		this.birthday=birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public boolean equals(Object obj) //비교추가
	{
		if(!(obj instanceof Person))
			return false;
		Person person = (Person)obj;
		if(name == person.name && email == person.email && phone == person.phone && birthday == person.birthday)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void modify(Person person) //수정추가.
	{
		this.name=person.name;
		this.email=person.email;
		this.phone=person.phone;
		this.birthday=person.birthday;
	}
}
