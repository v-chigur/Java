import java.io.*;
import java.util.*;

public class Task1 {

	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader(args[0]);
		Scanner scan = new Scanner(fr);

		Map<String, LinkedList<Integer>> mp = new LinkedHashMap<>();
		LinkedList<Integer> lst;
		int i = 0, n;

		while (scan.hasNext())
		{
			String w = scan.next().toLowerCase();
			int k = 0;
			String word = "";
			while (k < w.length()) 
			{
				char sm = w.charAt(k);
				if (Character.isLetter(sm) 
					|| sm == '-' || sm == '\'')
				{
					word += sm;
				}
				++k;
			}
			if (word == "") continue;
			
			++i;
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
        	if (iter.hasNext())
        	{
        		fw.write("\n");
        	}
		}

		fr.close();
		fw.close();
	}
}