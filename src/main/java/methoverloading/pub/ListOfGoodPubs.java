package methoverloading.pub;

import methoverloading.Time;

import java.util.List;

public class ListOfGoodPubs{

    private List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null ||goodPubs.isEmpty()){
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest(){
        Pub best = goodPubs.get(0);
        for (int i = 0; i < goodPubs.size(); i++) {
            if(goodPubs.get(i).getTime().isEarlier(best.getTime())){
                best = goodPubs.get(i);
            }
        } return best;
    }

}


