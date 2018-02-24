import java.io.*;
import java.util.*;

public class Task1 {

	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader(args[0]);
		Scanner scan = new Scanner(fr);

		Map<String, LinkedList<Integer>> mp = new LinkedHashMap<>();
		String word;
		LinkedList<Integer> lst;
		int i = 0, n;

		while (scan.hasNext())
		{
			++i;
			word = scan.next().toLowerCase();
			if (mp.containsKey(word))
			{
				lst = mp.get(word);
				n = lst.getFirst();
				lst.removeFirst();
				lst.addFirst(++n);
				lst.addLast(i);
				mp.put(word, lst);
			}
			else
			{
				lst = new LinkedList<Integer>();
				lst.addFirst(1);
				lst.addLast(i);
				mp.put(word, lst);
			}
		}

		FileWriter fw = new FileWriter(args[1]);
		Iterator<String> iter = mp.keySet().iterator();
		while (iter.hasNext()) 
		{
			String key = iter.next();
			fw.write(key);
			lst = mp.get(key);
			Iterator itr = lst.iterator();
        	while (itr.hasNext())
        	{
        		fw.write(" " + itr.next());
        	}
        	fw.write("\n");
		}

		fr.close();
		fw.close();
	}
}