package comparator;

public class CompareString implements Comparator{

	@Override
	public boolean isBiggerThan(Object v1, Object v2) {
		
		return ((String)v1).compareTo((String)v2) > 0;
	}

	@Override
	public boolean isSmallerThan(Object v1, Object v2) {
		
		return  ((String)v1).compareTo((String)v2) < 0;
	}

	@Override
	public boolean isEqueal(Object v1, Object v2) {
		
		return  ((String)v1).compareTo((String)v2) == 0;
	}

	@Override
	public boolean isBiggerThanEqualTo(Object v1, Object v2) {
		
		return  ((String)v1).compareTo((String)v2) >= 0;
	}

	@Override
	public boolean isSmallThanEqualTo(Object v1, Object v2) {
		
		return  ((String)v1).compareTo((String)v2) <= 0;
	}

	

}
