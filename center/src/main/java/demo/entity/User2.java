package demo.entity;

public class User2
{

	@Override
	public String toString()
	{
		return "User2 [name=" + name + ", id=" + id + ", password=" + password + ", birthday=" + birthday + "]";
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	private String name;
	private int id;
	private String password;
	private String birthday; 
}
