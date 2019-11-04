package comparator;

public class CompareInt implements Comparator{

	@Override
	public boolean isBiggerThan(Object v1, Object v2) {
		
		return ((int)v1) > ((int)v2) ;
	}

	@Override
	public boolean isSmallerThan(Object v1, Object v2) {
		
		return  (int)v1 < (int)v2;
	}

	@Override
	public boolean isEqueal(Object v1, Object v2) {
		
		return  (int)v1 == (int)v2;
	}

	@Override
	public boolean isBiggerThanEqualTo(Object v1, Object v2) {
		
		return   (int)v1 >= (int)v2;
	}

	@Override
	public boolean isSmallThanEqualTo(Object v1, Object v2) {
		
		return   (int)v1 <= (int)v2;
	}


}
