package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private List<Site> sites = new ArrayList<>();

    public void sellSite(Site site) {
        sites.add(site);
    }

    private int countSide(int side) {
        int count = 0;
        for (int i = 0; i < sites.size(); i++) {
            if (sites.get(i).getSide() == side) {
                count++;
            }
        }
        return count;
    }

    public int getHouseNumber() {
        int amount = countSide(sites.get(sites.size() - 1).getSide());
        return amount * 2 - sites.get(sites.size() - 1).getSide();
    }

    public List<Report> fenceStats() {
        int[] amount = new int[Fence.values().length];
        for (Site site : sites) {
            amount[site.getFence().ordinal()]++;
        }
        List<Report> result = new ArrayList<>();
        for (int i = 0; i < sites.size(); i++) {
            result.add(new Report(sites.get(i).getFence(), amount[i]));
        }
        return result;
    }

}
