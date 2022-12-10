package Day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class Day4
{
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("D:\\mypmp\\scr\\java\\AdventOfCode\\Day4\\Input.txt"));
            String line = null;
            int containCount = 0;
            int overLapCount = 0;
            while ((line = reader.readLine()) != null) {

                String[] str = line.split(",");
                String[] a = str[0].split("-");
                String[] b = str[1].split("-");
                int a1 = Integer.parseInt(a[0]);
                int a2 = Integer.parseInt(a[1]);
                int b1 = Integer.parseInt(b[0]);
                int b2 = Integer.parseInt(b[1]);
                ArrayList list1 = getMySet(a1,a2);
                ArrayList list2 = getMySet(b1,b2);

                if(list1.containsAll(list2) || list2.containsAll(list1))
                {
                    containCount++;
                }
                if(checkListIfOverlaps(list1,list2))
                {
                    overLapCount++;
                }
            }
            System.out.println("Contain count :"+containCount);
            System.out.println("Overlap Count :"+overLapCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkListIfOverlaps(ArrayList A, ArrayList B)
    {
        boolean flag = false;
        int l = A.size();
        int m = B.size();
	if(l<=m) // Just making it faster by checking the smaller list against bigger list.
	{
		for(int i=0;i<l;i++)
        	{
	        	int p = (int) A.get(i);
	        	if(B.contains(p))
        	    	{
	        		flag = true;
        	        	break;
			}
        	}		
	}
	else
	{
		for(int i=0;i<m;i++)
        	{
	        	int p = (int) B.get(i);
	        	if(A.contains(p))
        	    	{
	        		flag = true;
        	        	break;
			}
        	}
	}
        return flag;
    }
    private static ArrayList getMySet(int a, int b)
    {
        ArrayList al = new ArrayList();
        int len = 0;
        int flag=0;
        if(a>=b)
        {
            for(int i=b;i<=a;i++)
            {
                al.add(i);
            }
        }
        else
        {
            for(int i=a;i<=b;i++)
            {
                al.add(i);
            }
        }
        return al;
    }
}
