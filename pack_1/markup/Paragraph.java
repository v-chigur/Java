package markup;

import java.util.Arrays;
import java.util.List;
import java.util.Collections; 

public class Paragraph {

	public List<Text> arr;

	public Paragraph(List<Text>  arr)
	{
		this.arr = arr;
	}

	public static class Text {

		public String s;
	
		public Text(String s)
		{
			this.s = s;
		}
	}
	
	public String toMarkdown(StringBuilder builder)
	{
		for (int i = 0; i < this.arr.size(); ++i)
		{

			builder.append(this.arr.get(i).s);
		}
		return builder.toString();
	}

	public static class Emphasis extends Text {

		public Emphasis(List<Text> arr)
		{
			super("*");
			
			Paragraph p = new Paragraph(arr);
			StringBuilder builder = new StringBuilder();
			s += p.toMarkdown(builder) + "*";
		}
	}
	
	public static class Strong extends Text {

		public Strong(List<Text> arr)
		{
			super("_");
			Paragraph p = new Paragraph(arr);
			StringBuilder builder = new StringBuilder();
			s += p.toMarkdown(builder) + "_";
		}	
	}
	
	public static class Strikeout extends Text {

		public Strikeout(List<Text> arr)
		{
			super("~");
			Paragraph p = new Paragraph(arr);
			StringBuilder builder = new StringBuilder();
			s += p.toMarkdown(builder) + "~";
		}
	}
}