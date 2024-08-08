package solvers;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import constraints.Activity;
import constraints.Constraint;
public class Verifier
{
	protected Set<Constraint> listConstraints;
	public Verifier(Set<Constraint> listConstraints)
	{
		this.listConstraints=listConstraints;
	}
	
	public Set<Constraint> unsatisfied(Map<Activity, Integer> dict)
	{
		Set<Constraint> listC= new HashSet<Constraint>();
		for(Constraint c :this.listConstraints)
		{
			if (c.isSatisfied(dict) == false) 
			{
                listC.add(c);
            }			
		}
		return listC;
	}
}
