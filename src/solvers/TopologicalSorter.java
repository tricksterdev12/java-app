package solvers;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import constraints.Activity;
import constraints.PrecedenceConstraint;
import constraints.MeetConstraint;
public class TopologicalSorter
{
	public TopologicalSorter()
	{
	}
	
	public ArrayList<Activity> bruteForceSort (HashSet<Activity> Activitys,HashSet<PrecedenceConstraint> Constraints)
	{
		ArrayList<Activity> res =new ArrayList<Activity>();
		HashSet<Activity> copieActivitys =new HashSet<Activity> (Activitys);
		
		while(!copieActivitys.isEmpty())
		{
			boolean continuer=false;
			for(Activity a : copieActivitys)
			{
				boolean ok=true;
				for(PrecedenceConstraint c :Constraints)
				{
					if(a==c.getSecond() && !res.contains(c.getFirst()))
					{
						ok=false;
					}
				 }
				 if(ok==true)
				 {
					res.add(a);
					copieActivitys.remove(a);
					continuer=true;
					break;
				  }
			 }
			if(continuer==false)
			{
			   return null;		
			}
		}
		return res;
	}
	
	
	public HashMap<Activity, Integer> schedule(HashSet<Activity> Activitys, HashSet<PrecedenceConstraint> Constraints)
	{
		ArrayList<Activity> liste=this.bruteForceSort(Activitys,Constraints);
		HashMap<Activity, Integer> d=new HashMap<Activity, Integer>();
		int t=0;
			if(liste!=null)
			 { 
				for(Activity a :liste)
				{
					d.put(a,t);
					t=t+a.duree;
				}
				return d;
		      }
		     else
		     {
				 return null;
			 }
	}
}
