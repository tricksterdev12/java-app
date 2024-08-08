package constraints;
public class MeetConstraint extends BinaryConstraint 
{
   public MeetConstraint(Activity Ac1, Activity Ac2)
   {
	   super(Ac1,Ac2);
   }
   @Override
   public boolean isSatisfied(int d1,int d2)
   {
	   int d=super.Ac1.getDuration();
	   if((d1+d) == d2)
		return true;
	   else
	    return false;
	   
   }
}

