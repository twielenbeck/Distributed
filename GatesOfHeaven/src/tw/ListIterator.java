package tw;

import java.util.List;

public class ListIterator
{
    private List list;

    // JavaBean accessors for first name
    public ListIterator(List list)
    {
        this.list = list;
    }

    public List getList()
    {
        return list;
    }

    public int getSize()
    {
        return list.size();
    }
}