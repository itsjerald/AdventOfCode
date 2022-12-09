package Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryType extends FileType
{
    private Map<String, FileType > files = new HashMap<String, FileType>();
    private final DirectoryType parentDir;

    public DirectoryType(DirectoryType parentDir, String name)
    {
        super(name, 0l);
        this.parentDir = parentDir;
    }

    public DirectoryType getParentDir() {
        return this.parentDir;
    }

    public DirectoryType getDir(String dir) {
        return (DirectoryType) files.get(dir);
    }

    public void addFile(FileType f)
    {
        files.put(f.getName(), f);
    }

    @Override
    public long getSize()
    {
        long dirSize = 0;
        for(FileType f : files.values())
        {
            dirSize += f.getSize();
        }
        return dirSize;
    }
}
