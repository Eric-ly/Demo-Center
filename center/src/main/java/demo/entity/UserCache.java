package demo.entity;

import java.io.Serializable;

public class UserCache implements Serializable
{

		@Override
	public String toString()
	{
		return "UserCache [id=" + id + ", name=" + name + ", age=" + age + "]";
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
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
		private int id;
		private String name;
		private int age;
		
}
