package solvers;
import java.util.Random;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import constraints.Constraint;
import constraints.Activity;
public class RandomScheduler
{
	protected Random rand;

    public RandomScheduler(Random rand) 
    {
        this.rand = rand;
    }
	public Map<Activity, Integer> generateOneSchedule(Set<Activity> listAct, int min, int max) {
        Map<Activity, Integer> map = new HashMap<>();
        for (Activity a : listAct) {
            map.put(a,this.rand.nextInt(max - min + 1) + min);
        }
        return map;
    }
    
	public Map<Activity, Integer> generateSchedule(Set<Activity> listAct,Set<Constraint> listC, int min, int max,int nbrT)
	{
		Map<Activity, Integer> map = new HashMap<>();
		Verifier v=new Verifier(listC);
		int maxUnsatisfied=listAct.size(); 
        for(int i=0;i<=nbrT;i++)
        {
			Map<Activity, Integer> m =generateOneSchedule(listAct,min,max);
			int t=v.unsatisfied(m).size();
			if(t<maxUnsatisfied)
			{
				map=m;
				maxUnsatisfied=t;
			}
			
		}
		return map;
    }
	
	
}
