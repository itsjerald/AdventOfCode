package Day3;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class Day3
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("D:\\mypmp\\scr\\java\\AdventOfCode\\Day3\\Input.txt"));
            String line = null;
            String buffer1 = "";
            String buffer2 = "";
            ArrayList<String> P2 = new ArrayList<String>();
            while ((line = reader.readLine()) != null)
            {
                //Part 1
                int t = line.length();
                t = t/2;
                String str1 = line.substring(0,t);
                String str2 = line.substring(t);

                String[] srr = str1.split("");

                for(String s : srr)
                {
                   if(str2.contains(s))
                   {
                       buffer1 = buffer1 + s;
                       break;
                   }
                }

                //Part 2

                P2.add(line);
                String itemType = "";
                if(P2.size() == 3)
                {
                    buffer2 = buffer2 + getGroupItemType(P2);
                    P2 = new ArrayList<String>();
                }
            }
            System.out.println("Part 1 Item type string : "+buffer1);
            int g = getPriorityNumber(buffer1);
            System.out.println("Part1 Answer : "+g);

            System.out.println("Part 2 Item type string : "+buffer2);
            g = getPriorityNumber(buffer2);
            System.out.println("Part2 Answer : "+g);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static String getGroupItemType(ArrayList<String> A) {
        String str1 = A.get(0);
        String str2 = A.get(1);
        String str3 = A.get(2);
        String buffer1 = "";
        String buffer2 = "";
        String[] srr = str1.split("");

        for(String s : srr)
        {
            if(str2.contains(s))
            {
                buffer1 = buffer1 + s;
            }
        }
        srr = buffer1.split("");
        for(String s : srr)
        {
            if(str3.contains(s))
            {
                buffer2 = buffer2 + s;
                break;
            }
        }
        return buffer2;
    }

    private static int getPriorityNumber(String str) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("a",1);
        hm.put("b",2);
        hm.put("c",3);
        hm.put("d",4);
        hm.put("e",5);
        hm.put("f",6);
        hm.put("g",7);
        hm.put("h",8);
        hm.put("i",9);
        hm.put("j",10);
        hm.put("k",11);
        hm.put("l",12);
        hm.put("m",13);
        hm.put("n",14);
        hm.put("o",15);
        hm.put("p",16);
        hm.put("q",17);
        hm.put("r",18);
        hm.put("s",19);
        hm.put("t",20);
        hm.put("u",21);
        hm.put("v",22);
        hm.put("w",23);
        hm.put("x",24);
        hm.put("y",25);
        hm.put("z",26);
        hm.put("A",27);
        hm.put("B",28);
        hm.put("C",29);
        hm.put("D",30);
        hm.put("E",31);
        hm.put("F",32);
        hm.put("G",33);
        hm.put("H",34);
        hm.put("I",35);
        hm.put("J",36);
        hm.put("K",37);
        hm.put("L",38);
        hm.put("M",39);
        hm.put("N",40);
        hm.put("O",41);
        hm.put("P",42);
        hm.put("Q",43);
        hm.put("R",44);
        hm.put("S",45);
        hm.put("T",46);
        hm.put("U",47);
        hm.put("V",48);
        hm.put("W",49);
        hm.put("X",50);
        hm.put("Y",51);
        hm.put("Z",52);
        String[] strr = str.split("");
        int total = 0;
        for(String s : strr)
        {
            total = total + (Integer)hm.get(s);
        }
        return total;
    }
}
