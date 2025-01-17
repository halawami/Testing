import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


/**
 * 
 * A class for representing immutable sequence of link words.
 *
 * @author xiek and Alawamhm.
 *         Created Sep 21, 2017.
 */

public class Chain implements Iterable<String> {
	private Set<String> set;
	private LinkedList<String> list;
	
	public Chain(){
		this.set = new HashSet<>();
		this.list = new LinkedList<>();
	}

	public Chain(Set<String> set, LinkedList<String> list) {
		this.set = set;
		this.list = list;
	}

	@Override
	public Iterator<String> iterator() {
		return this.list.iterator();
	}

	public String getLast() {
		return this.list.getLast();
	}

	public Chain addLast(String string) {
		HashSet<String> ss = new HashSet<>(this.set);
		LinkedList<String> ll = new LinkedList<>(this.list);
		ss.add(string);
		ll.add(string);
		return new Chain(ss,ll);
	}

	private void add(String string){
		this.set.add(string);
		this.list.add(string);
	}
	
	public int length() {
		return this.set.size();
	}

	public boolean contains(String string) {
		return this.set.contains(string);
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		Iterator<String> iterator = iterator();
		
		while(iterator.hasNext()){
			s.append(iterator.next());
			s.append(", ");
		}
		
		String rt = s.toString();
		rt = rt.substring(0, rt.length()-2);
		rt = "["+rt+"]";
		return rt;
	}

}
