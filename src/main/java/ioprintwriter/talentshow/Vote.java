package ioprintwriter.talentshow;

public class Vote {
    int Id;
    int amount;

    public Vote(int id, int amount) {
        Id = id;
        this.amount = amount;
    }

    public void incNumber(){
        amount++;
    }
}
