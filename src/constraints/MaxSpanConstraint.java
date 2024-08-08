package constraints;
import java.util.Map;
import java.util.Set;
public class MaxSpanConstraint implements Constraint
{
	protected Set<Activity> listActivities;
	protected int duree;
	public MaxSpanConstraint(Set<Activity> listActivities,int duree)
	{
		this.listActivities=listActivities;
		this.duree=duree;
	}
	public Set<Activity> getActivities() {
        return listActivities;
    }
	public boolean isSatisfied(Map<Activity, Integer> dict)
	{
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		if(listActivities.isEmpty())
		{
			return true;
		}
		for (Activity a: listActivities) {
					int tps=dict.get(a);
				if ( tps < min) {
					min = tps;
				}
				if (tps+a.getDuration()> max) 
				{
					max= tps+ a.getDuration();
				}
			
		}
		return  (max- min)<= this.duree; 
	}
	
	public String toString() 
	{
		String affiche = "MaxSpanConstraint porte sur les activités suivantes :\n";
		for (Activity a : this.listActivities) 
		{
			affiche += "\t* '" + a.getDuration() + "'\n";
		}
		affiche += "et la durée max pour ces activités = " + this.duree+ " minutes";
		return affiche;
	}
}

