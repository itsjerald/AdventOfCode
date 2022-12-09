package Day7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Day7
{
    //part 1 answer - 1348005
    public static void main(String[] args) throws IOException
    {
        String inputDir = "D:/mypmp/scr/java/AdventOfCode/Day7";
        BufferedReader reader = new BufferedReader(new FileReader(inputDir+"/Input.txt"));
        String line = null;
        DirectoryType currentDir = null;
        DirectoryType rootDir = new DirectoryType(null, "/");
        ArrayList<DirectoryType> allDirList = new ArrayList<DirectoryType>();
        while ((line = reader.readLine()) != null)
        {
            String[] arr = line.split(" ");
            if("$".equals(arr[0]))
            {
                //handle commands
                if("cd".equals(arr[1]))
                {
                    if("/".equals(arr[2])) // cd / command
                    {
                        currentDir = rootDir;
                    }
                    else if ("..".equals(arr[2])) // cd .. command
                    {
                        currentDir = currentDir.getParentDir();
                    }
                    else // cd dirname command
                    {
                        currentDir = currentDir.getDir(arr[2]);
                    }
                }
                else //ls command
                {
                    //do nothing
                }
            }
            else if ("dir".equals(arr[0]))
            {
                DirectoryType de = new DirectoryType(currentDir, arr[1]); // arg1 parent directory and arg2 name
                currentDir.addFile(de);
                allDirList.add(de);
            }
            else // Add a file for file entry
            {
                currentDir.addFile(new FileType(arr[1], Long.parseLong(arr[0])));
            }
        }

        long s = 0;
        for(DirectoryType d : allDirList)
        {
            if(d.getSize() < 100000) {
                s += d.getSize();
            }
        }
        System.out.println("Total size of directories that less than 100000 : " + s);

        long totalSpace = 70000000;
        long rootSize = rootDir.getSize();
        System.out.println("rootSize "+rootSize);

        long availableFreeSpace = totalSpace - rootSize;
        if(availableFreeSpace < 30000000)
        {
            long spaceNeeded = 30000000 - availableFreeSpace;
            ArrayList <DirectoryType> dirsHavingSpaceNeeded = new ArrayList<DirectoryType>();
            dirsHavingSpaceNeeded.add(rootDir);
            for(DirectoryType d : allDirList)
            {
                if(d.getSize() > spaceNeeded) {
                    dirsHavingSpaceNeeded.add(d);
                }
            }
            dirsHavingSpaceNeeded.sort((a,b) -> (int)(a.getSize() - b.getSize()));

            System.out.println("Dir to be removed, name  and size : "+dirsHavingSpaceNeeded.get(0).getName()+" and size "+ dirsHavingSpaceNeeded.get(0).getSize());
        }
    }
}
