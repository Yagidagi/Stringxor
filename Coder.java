import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Coder
{
	public static void main(String args[])
	{
		String text = "Hi my name is james";
		String key = "sup";
		key = makeKey(text, key);

		String result = human(text, key);

		System.out.println(result);

		result = human(result, key);

		System.out.println(result);

		System.out.println(toHex(result));
	}

	public static String makeKey(String text, String key)
	{
		int reps = text.length()/key.length();
		String result="";

		for(int x=0;x<=reps;x++)
		{
			result+=key;
		}
		return result;
	}

	public static String human(String text, String key)
	{
		String result = "";

		for (int i=0;i<text.length() && i<key.length();i++)
		{
			int x = (int) text.charAt(i);
			int y = (int) key.charAt(i);

			String z = String.valueOf((char) (x^y));

			result+=z;
		}
	
		return result;
	}

	public static String toHex(String str)
	{
		String result = "";

		for (int i=0;i<str.length();i++)
		{
			int x = (int) str.charAt(i);

			String temp = Integer.toHexString(x);

			result+=temp + " ";
		}
	
		return result;
	}

	public static String read(String name)
	{
		String result = "";
		try
		{
			File file = new File (name);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) 
			{
      				result += scanner.nextLine();
			}	
		scanner.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return result;
	}

}