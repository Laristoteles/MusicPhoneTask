package commons.utils;

import java.util.Comparator;

import commons.dataClasses.Recommendation;

public class CustomComparator implements Comparator<Recommendation> {

	@Override
	public int compare(Recommendation o1, Recommendation o2) {
		int result = 0;
		if(o1.getFanCount() > o2.getFanCount()) result = 1;
		else if(o1.getFanCount() == o2.getFanCount()) result = 0;
		else if(o1.getFanCount() > o2.getFanCount()) result = -1;
		
		return result;

	}

}
