package tw;

import java.util.ArrayList;
import java.util.List;

public class GatheringsManager
{
    private static List<Gatherings> gatheringsList = new ArrayList<>();

    public GatheringsManager()
    {
        if(gatheringsList.size() == 0)
        {
            gatheringsList.add(new Gatherings("Welcome New Pledges", "10/29/2018", false));
            gatheringsList.add(new Gatherings("Sacrificial Lamb Slaughter", "10/30/2018", false));
            gatheringsList.add(new Gatherings("Free Tacos - Halloween", "10/31/2018", true));
            gatheringsList.add(new Gatherings("Summoning Circle", "11/14/2018", false));
            gatheringsList.add(new Gatherings("Potion Brewing", "11/16/2018", true));
            gatheringsList.add(new Gatherings("Punch Drinking Contest", "11/19/2018", true));
        }
    }

    public List<Gatherings> getGatheringsList()
    {
        return gatheringsList;
    }

    public List<Gatherings> getCurrentGatherings()
    {
        List<Gatherings> remaining = new ArrayList<>();
        for (Gatherings e : gatheringsList)
        {
            if (e.isCompleted())
            {
                remaining.add(e);
            }
        }
        return remaining;
    }
    public Gatherings getGatheringsByName(String name)
    {
        Gatherings e = null;
        for(int i = 0; i < gatheringsList.size(); i++)
        {
            if(gatheringsList.get(i).getName().equals(name))
            {
                e = gatheringsList.get(i);
            }
        }
        return e;
    }

    @Override
    public String toString()
    {
        return "GatheringsList{" +
                "gatheringsList=" + gatheringsList +
                '}';
    }
}
