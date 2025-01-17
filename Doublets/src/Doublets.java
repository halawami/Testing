import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Class for finding the doublet that implements the chains and links
 *
 * @author xiek and Alawamhm.
 *         Created Sep 21, 2017.
 */

public class Doublets {
	private LinksInterface links;

	public Doublets(LinksInterface links) {
		this.links = links;
	}

	public static void main(String[] args) {
		Links links = new Links("english.cleaned.all.35.txt");
		Doublets doublets = new Doublets(links);
		ChainManager manager;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Doublets, a game of \"verbal torture.\"");

		String input = "";
		String start, end;
		Chain chain;

		while (true) {
			System.out.print("Enter starting word: ");
			start = scanner.next();
			System.out.print("Enter ending word: ");
			end = scanner.next();
			System.out.print("Enter chain manager (s: stack, q: queue, p: priority queue, x: exit): ");

			char c = scanner.next().charAt(0);
			switch (c) {
			default:
				continue;
			case 's':
				manager = new StackChainManager();
				break;
			case 'p':
				manager = new PriorityQueueChainManager(end);
				break;
			case 'q':
				manager = new QueueChainManager();
				break;
			case 'x':
				System.out.println("Goodbye!");
				return;
			}

			chain = doublets.findChain(start, end, manager);
			if(!links.exists(start)){
				System.out.println("The word " + "\"" + start + "\" " + "is not valid. Please try again.");

			}
			else if (chain==null) {
				System.out.println("No doublet chain exists from owner to bribe.");
				
			} else {
				System.out.println("Chain: " + chain.toString());
				System.out.println("Length: " + chain.length());
				System.out.println("Candidates: " + manager.getNumberOfNexts());
				System.out.println("Max size: " + manager.maxSize());
			}

		}
	}

	public Chain findChain(String start, String end, ChainManager manager) {

		if (start.length() != end.length())
			return null;

		Chain chain = new Chain();
		chain = chain.addLast(start);
		manager.add(chain);

		String s = null;
		Set set;

		while (!manager.isEmpty()) {
			chain = manager.next();
			s = chain.getLast();
			//System.out.println(s);
			if (s.equals(end)) {
				return chain;
			}

			set = this.links.getCandidates(s);

			if (set != null) {
				Iterator<String> iterator = set.iterator();
				while (iterator.hasNext()) {
					s = iterator.next();
					if(!chain.contains(s))
						manager.add(chain.addLast(s));
				}
			}
		}

		return null;
	}

}
