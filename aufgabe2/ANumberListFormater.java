package de.edicos.azubi.aufgabe2;

import java.util.List;
import java.util.Collections;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Arrays;

public class ANumberListFormater implements INumberListFormater {

	public ANumberListFormater() {
		super();
	}

	@Override
	public String asRangedList(List<Integer> numbers) {
		// TODO Auto-generated method stub
//      List<Integer> list = new ArrayList<Integer>();
//		String result = "";
//		String comma =",";
//		String minus = "-";
//		int list1 = 0;
//		int list2 = 0;
////		Arrays.sort(numbers);
//		for (int i = 0; i < list.size(); i++) {
//			if (list == null) {
//				result = "List ist leer";
//				
//			}else if(list[i]< list[i+1]) {
//				list1.add(i);
//				continue;
//			}else if (list[i]< list[i+1]) {
//				list2.add(i);
//			break;
//			}
//		} 
//		for (int i = 0; i < list.size(); i++) {
//			if (list1.size() == 2 || list2.size( == 2)) {
//				list = (list1(0)+comma +list1.size()-1) + (list2(0)+comma +list2.size()-1);
//			}else {
//				list = (list1(0)+minus+list1.size()-1) + (list2(0)+minus +list2.size()-1);
//			}
//				
//			}
//		return list;
		
//		ArrayList<Integer> myList = new ArrayList<Integer>();
//		Collections.sort(myList);
//		for (int i : myList) {
//			if (myList.size() == 0) {
//				result = "List ist leer";
//			}else if ()
//		}
		
//		ListIterator<Integer> li = myList.listIterator();
//		 
//		while(li.hasNext()) {
//			System.out.println(li.next());
//		}
//		
	 return null;
}

	@Override
	public String asRangedList(int[] numbers) {
		// TODO Auto-generated method stub
		return rangeList(numbers);
	}
	
	public String rangeList(int[] a) {
        int length = 1;
		List<String> list = new ArrayList<String>();
		Collections.sort(list);
		if (a.length == 0) {
			return list;
		}
		for (int i = 1; i <= a.length; i++) {
			if (i == a.length || a[i] - a[i - 1] != 1) {
				if (a[i] - a[i - 1] == 0) {
					list.remove(i);
				}
				if(length == 1) {
					list.add(String.valueOf(a[i - length]));

				} else {
					list.add(a[i - length] + "-" + a[i - 1]);

				}
				length = 1;

			} else {
				length++;
			}
		}

		return list;
	}
}
