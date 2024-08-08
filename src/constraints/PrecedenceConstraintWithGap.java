package constraints;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint
{
	protected int delai_min;
	protected int delai_max;
	
	public PrecedenceConstraintWithGap(Activity Ac1,Activity Ac2,int delai_min,int delai_max)
	{
		super(Ac1,Ac2);
		this.delai_min=delai_min;
		this.delai_max=delai_max;
	}
	
	@Override
	public boolean isSatisfied(int date1, int date2)
	{
		if(this.Ac1.getDuration()+date1+this.delai_min <= date2 && this.Ac1.getDuration()+date1+this.delai_max >= date2)
			return true;
		else
			return false;
		
	}
}
