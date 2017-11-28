package demo.entity;

public class ConditionUsers
{

	@Override
	public String toString()
	{
		return "ConditionUsers [name=" + name + ", minAge=" + minAge + ", maxAge=" + maxAge + "]";
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getMinAge()
	{
		return minAge;
	}
	public void setMinAge(int minAge)
	{
		this.minAge = minAge;
	}
	public int getMaxAge()
	{
		return maxAge;
	}
	public void setMaxAge(int maxAge)
	{
		this.maxAge = maxAge;
	}
	private String name;
	private int minAge;
	private int maxAge;
	
}
