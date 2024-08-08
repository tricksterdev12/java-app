package constraints;
public class Activity
{
	public String description;
	public int duree;
	
	public Activity(String description,int duree)
	{
		this.description=description;
		this.duree=duree;
	}

	public String getDescription()
	{
		return this.description;
	}
	
	public int getDuration()
	{
		return this.duree;
	}
	
	public String toString()
	{
		return "la description :"+this.getDescription()+" et la durée :"+this.getDuration();
	}
	
}
