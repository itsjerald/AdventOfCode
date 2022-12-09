package AdventOfCode;

public class Day6
{
	public static void main(String[] args) throws Exception
	{
		String str = args[0];
		int l = str.length();
		for(int i=0;i<l;i++)
		{
			int j=i+4;
			if(j > l)
			{
				System.out.println("NOT FOUND");
				break;
			}
			String s = str.substring(i,j);
			char c[] = new char[4];
			c[0] = s.charAt(0);
			c[1] = s.charAt(1);
			c[2] = s.charAt(2);
			c[3] = s.charAt(3);
			if(c[0] == c[1] || c[0] == c[2] || c[0] == c[3]  || c[1] == c[2]  || c[1] == c[3]  || c[2] == c[3] )
			{
				continue;
			}
			else
			{
				System.out.println("Data starts at "+(i+4));
				break;
			}

		}
		
	}
}
