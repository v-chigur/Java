import markup.Paragraph;

import java.util.Arrays;
import java.util.List;
import java.util.Collections; 

public class Task2 {

	public static void main(String[] args)
	{
		Paragraph paragraph = new Paragraph(Collections.singletonList(
			new Paragraph.Strong(Arrays.asList(
				new Paragraph.Text("1"),
				new Paragraph.Strikeout(Arrays.asList(
					new Paragraph.Text("2"),
					new Paragraph.Emphasis(Arrays.asList(
						new Paragraph.Text("3"),
						new Paragraph.Text("4")
					)),
					new Paragraph.Text("5")
				)),
				new Paragraph.Text("6")
			))
    	));
    	System.out.println(paragraph.toMarkdown(new StringBuilder()));
	}
}