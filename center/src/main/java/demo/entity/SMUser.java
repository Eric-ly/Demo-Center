package demo.entity;

import java.util.Date;

/*
 * CREATE TABLE s_user(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(30),
	user_birthday DATE,
	user_salary DOUBLE
)
 */
public class SMUser
{

		@Override
	public String toString()
	{
		return "SMUser [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
		public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
		private int id;
		private String name;
		private Date birthday;
		private double salary;
		public SMUser()
		{
			super();
		}
		public SMUser(int id, String name, Date birthday, double salary)
		{
			super();
			this.id = id;
			this.name = name;
			this.birthday = birthday;
			this.salary = salary;
		}
	    
}
