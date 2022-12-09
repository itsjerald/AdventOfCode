package Day5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;



public class Day5
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
            //rearrangeStackPart1(cmds);
            rearrangeStackPart2(cmds);
        }
        // delete the last new line separator
        reader.close();
        System.out.println("New Stack "+stack);

        String output = "";
        for(String a : stack)
        {
               output = output + a.substring(a.length() - 1);
        }
        System.out.println("Output : "+output);

    }

    private static void rearrangeStackPart1(ArrayList<Integer> cmds)
    {
        for(int t=0;t<cmds.get(0);t++)
        {
            moveACrateFromAtoBPart1(cmds);
        }
    }

    private static void rearrangeStackPart2(ArrayList<Integer> cmds)
    {
            moveACrateFromAtoBPart2(cmds);
    }

    private static void moveACrateFromAtoBPart1(ArrayList<Integer> cmds)
    {
        String src = stack.get(cmds.get(1)-1); // from
        String dest = stack.get(cmds.get(2)-1); // to
        //Append the last char of the src string to dest string
        dest = dest + src.substring(src.length()-1);
        //Remove the last char from the src string.
        src = src.substring(0,src.length()-1);
        stack.set(cmds.get(1)-1, src);
        stack.set(cmds.get(2)-1, dest);
    }
    private static void moveACrateFromAtoBPart2(ArrayList<Integer> cmds)
    {
        String src = stack.get(cmds.get(1)-1); // from
        String dest = stack.get(cmds.get(2)-1); // to
        //Append the specified chars of the src string to dest string
        int cc = Integer.parseInt(String.valueOf(cmds.get(0))); //Crate count
        dest = dest + src.substring(src.length()- cc );
        //Remove the specified chars from the src string.
        src = src.substring(0,src.length()-cc);
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

