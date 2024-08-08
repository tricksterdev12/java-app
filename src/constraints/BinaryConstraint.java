package constraints;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public abstract class BinaryConstraint implements Constraint
{
   protected Activity Ac1;
   protected Activity Ac2;
   
    public BinaryConstraint(Activity Ac1,Activity Ac2)
    {
	   this.Ac1=Ac1;
	   this.Ac2=Ac2;
    }
    
    public Activity getFirst()
    {
		return this.Ac1;
    }
    
	public Activity getSecond()
	{
	   return this.Ac2;
	}
	
    @Override
    public Set<Activity> getActivities() 
    {
        return new HashSet<>(Arrays.asList(getFirst(), getSecond()));
    }
    
    public abstract boolean isSatisfied(int date1,int date2);
    
	public boolean isSatisfied(Map<Activity, Integer> dict)
    {
        if (dict.containsKey(this.Ac1) && dict.containsKey(this.Ac2)) 
        {
			int date1=dict.get(this.Ac1);
			int date2=dict.get(this.Ac2);
            return isSatisfied(date1,date2);
        }
        else
        {
		    return false;
		}
    }
}
