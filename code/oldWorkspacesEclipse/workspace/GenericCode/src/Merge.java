import java.util.Arrays;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

class Merge{
	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("dog");
		list.add("bear");
		list.add("wewe");
		list.add("wewe");
		list.add("sdfdf");
		list.add("zebra");
		list.add("kittenasds");
		list.add("apwewee");
		list.add("lsfsdfion");
		list.add("zegeggbra");
		
		list = merge(list);
	}
	
	public static int[] merge(int[] arr){
		if (arr.length <= 1) return arr;
		
		int mid = arr.length/2;
		int[] l = Arrays.copyOfRange(arr, 0, mid);
		int[] r = Arrays.copyOfRange(arr, mid, arr.length);
		
		r = merge(r);
		l = merge(l);
		int[] result = mergeSort(l, r);
		
		return result;
		
	}
	
	public static int[] mergeSort(int[] l, int[] r){
		int[] result = new int[0];
		
		while (l.length > 0 || r.length > 0){
			if (l.length > 0 && r.length > 0){
				if (l[0] <= r[0]){
					int[] temp = new int[result.length+1];
					for (int i = 0; i < result.length; i++){
						temp[i] = result[i];
					}
					temp[result.length] = l[0];			
					result = temp;
					l = Arrays.copyOfRange(l, 1, l.length);
				} else {
					int[] temp = new int[result.length+1];
					for (int i = 0; i < result.length; i++){
						temp[i] = result[i];
					}
					temp[result.length] = r[0];			
					result = temp;
					r = Arrays.copyOfRange(r, 1, r.length);
				}
			}
			else if (l.length > 0){
				int[] temp = new int[result.length+1];
				for (int i = 0; i < result.length; i++){
					temp[i] = result[i];
				}
				temp[result.length] = l[0];			
				result = temp;
				l = Arrays.copyOfRange(l, 1, l.length);
			}
			else if (r.length > 0){
				int[] temp = new int[result.length+1];
				for (int i = 0; i < result.length; i++){
					temp[i] = result[i];
				}
				temp[result.length] = r[0];			
				result = temp;
				r = Arrays.copyOfRange(r, 1, r.length);
			}
		}
		return result;
	}
	
	
	public static <E extends Comparable<E>> List<E> merge(List<E> arr){
		if (arr.size() <= 1) return arr;
		
		int mid = arr.size()/2;
		List<E> l = arr.subList(0, mid);
		List<E> r = arr.subList(mid, arr.size());
		
		r = merge(r);
		l = merge(l);
		List<E> result = mergeSort(l, r);
		
		return result;
		
	}
	
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> l, List<E> r){
		List<E> result = new ArrayList<E>();
		
		while (l.size() > 0 || r.size() > 0){
			if (l.size() > 0 && r.size() > 0){
				if (l.get(0).compareTo(r.get(0)) <= 0){
					result.add(l.get(0));
					l = l.subList(1, l.size());
				} else {
					result.add(r.get(0));
					r = r.subList(1, r.size());
				}
			}
			else if (l.size() > 0){
				result.add(l.get(0));
				l = l.subList(1, l.size());
			}
			else if (r.size() > 0){
				result.add(r.get(0));
				r = r.subList(1, r.size());
			}
		}
		return result;
	}
}
