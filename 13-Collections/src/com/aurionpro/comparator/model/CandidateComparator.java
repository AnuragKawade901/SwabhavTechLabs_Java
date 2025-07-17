package com.aurionpro.comparator.model;

import java.util.Comparator;

public class CandidateComparator implements Comparator<CandidateNameAge>{

	@Override
	public int compare(CandidateNameAge candidate1, CandidateNameAge candidate2) {
		int nameCompare = candidate1.getName().compareToIgnoreCase(candidate2.getName());
		if(nameCompare !=0) {
			return nameCompare;
			
		}
		return Integer.compare(candidate1.getAge(), candidate2.getAge());
	}
	

}
