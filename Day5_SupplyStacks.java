package AdventOfCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;



public class Day5_SupplyStacks
{
	private static ArrayList<String> stack = new ArrayList<String>();
	public static void main(String[] args) throws Exception
	{
	
		BufferedReader reader = new BufferedReader(new FileReader("D:/mypmp/scr/java/AdventOfCode/Day5/supply.txt"));
		String line = null;
		String ls = System.getProperty("line.separator");
		stack.add("NRGP");
		stack.add("JTBLFGDC");
		stack.add("MSV");
		stack.add("LSRCZP");
		stack.add("PSLVCWDQ");
		stack.add("CTNWDMS");
		stack.add("HDGWP");
		stack.add("ZLPHSCMV");
		stack.add("RPFLWGZ");
		System.out.println("OLD Stack "+stack);
		while ((line = reader.readLine()) != null) 
		{
			ArrayList<Integer> cmds = getCmds(line);
			System.out.println("cmds : "+ cmds);
			rearrangeStack(cmds);
		}
		// delete the last new line separator
		reader.close();
		System.out.println("New Stack "+stack);

	}

	private static void rearrangeStack(ArrayList<Integer> cmds)
	{
		for(int t=0;t<cmds.get(0);t++)
		{
			moveACrateFromAtoB(cmds);
		}
	}

	private static void moveACrateFromAtoB(ArrayList<Integer> cmds)
	{
		String src = stack.get(cmds.get(1)-1);
		String dest = stack.get(cmds.get(2)-1);
		//Append the last char of the src string to dest string
		dest = dest + src.substring(src.length()-1); 
		//Remove the last char from the src string.
		src = src.substring(0,src.length()-1);
		stack.set(cmds.get(1)-1, src);
		stack.set(cmds.get(2)-1, dest);
	}

	private static ArrayList<Integer> getCmds(String line)
	{
		ArrayList<Integer> cmds = new ArrayList<Integer>();
		String regex = "\\d+";
      		//Compiling the regular expression
		Pattern pattern = Pattern.compile(regex);
		//Retrieving the matcher object
		Matcher matcher = pattern.matcher(line);
		int count = 0;
		while(matcher.find()) 
		{
			String s = matcher.group();
			cmds.add(Integer.parseInt(s));
			count++;
		}
		return cmds;
	}

}

