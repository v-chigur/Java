//package Java;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;

public class Stock {

	public static void main(String[] args) throws Exception
	{
		Queue<Integer> xx, yy;
		xx = new PriorityQueue<>(); yy = new PriorityQueue<>();
		Scanner reader = new Scanner(System.in);
		char z; int n, c, x, y;

		while (true)
		{
			System.out.println("Enter an order in format \"b/s num cost\" (example: b 5 10)");
			z = reader.next().charAt(0); n = reader.nextInt(); c = reader.nextInt();
	
			System.out.print(z+" "+n+" "+c);
			if (z == 'b')
			{
				xx.add(c);
			}
			else if (z == 's')
			{
				yy.add(c);
			}
	
			if (xx.peek() == null || yy.peek() == null)
				continue;
	
			x = xx.poll(); y = yy.poll();
	
			while (x <= y && !(xx.peek() == null || yy.peek() == null))
			{
				x = xx.poll(); y = yy.poll();
			}
	
			if (y > x)
			{
				xx.add(x); yy.add(y);
			}
		}
	}
}