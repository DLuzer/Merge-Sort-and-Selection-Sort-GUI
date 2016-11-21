
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class sort {
	
	public static ArrayList<Person> getFile(){
		ArrayList<Person> people = new ArrayList<Person>();
		try {
			Scanner file = new Scanner(new File("phonebook.txt"));
			while(file.hasNext()){
				Person person = new Person(file.next(), removeComma(file.next()), file.next());
				people.add(person);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return people;
	}
	
	// Idea for this method was conceived by Sam Svinland in CIS 212 
	private static String removeComma(String s){
		return s.substring(0,s.length()-1);
	}
	
	public static ArrayList<Person> selectionSort(ArrayList<Person> list){
		for (int i = 0; i < list.size() - 1; i++){
			int index = i;
			Person last = list.get(i);
			for (int j = i + 1; j < list.size(); j++){
				String smallest = last.getLastName();
				Person nextSmallest = list.get(j);
				String nextString = nextSmallest.getLastName();
				int compare = smallest.compareTo(nextString);
				if(compare > 0){
					index = j;
					last = nextSmallest;
				} 
			} 
			list.set(index, list.get(i));
			list.set(i, last);
		}
		return list;
	}
	
	// This medthod is a modifed version of the one presented at: http://www.codexpedia.com/java/java-merge-sort-implementation/
	public static ArrayList<Person> mergeSort(ArrayList<Person> list){
		ArrayList<Person> left = new ArrayList<Person>();
		ArrayList<Person> right = new ArrayList<Person>();
		if(list.size() <= 1){
			return list;
		} else {
			int mid = list.size() / 2;
			for(int i = 0; i < mid; i++){
				left.add(list.get(i));
			}
			for(int j = mid; j < list.size(); j++){
				right.add(list.get(j));
			}
			left = mergeSort(left);
			right = mergeSort(right);
			
			merge(left, right, list);
		}	
		return list;
	}
	
	//This method is a modified version of the on presented at: http://www.codexpedia.com/java/java-merge-sort-implementation/
	public static void merge(ArrayList<Person> left, ArrayList<Person> right, ArrayList<Person> list){
		int leftIndex = 0;
		int rightIndex = 0;
		int listIndex = 0;
		while(leftIndex < left.size() && rightIndex < right.size()){
			if (left.get(leftIndex).getLastName().compareTo(right.get(rightIndex).getLastName()) < 0){
				list.set(listIndex, left.get(leftIndex));
				leftIndex++;
			} else {
				list.set(listIndex, right.get(rightIndex));
				rightIndex++;
			}
			listIndex++;
		}
		ArrayList<Person> rest;
		int restIndex;
		if(leftIndex >= left.size()){
			rest = right;
			restIndex = rightIndex;
		} else {
			rest = left;
			restIndex = leftIndex;
		}
		for (int i = restIndex; i < rest.size(); i++){
			list.set(listIndex, rest.get(i));
			listIndex++;
		}
	}
	public static boolean checkSorted(ArrayList<Person> list){
		boolean check = true;
		for (int i = 0; i < list.size() - 1; i++){
			if(list.get(i).getLastName().compareTo(list.get(i+1).getLastName()) > 0){
				check = false;
			}
		}
		return check;
	}
}
