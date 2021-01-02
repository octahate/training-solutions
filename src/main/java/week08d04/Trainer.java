package week08d04;

public class Trainer {
    CanMark mood;

    public Trainer(CanMark mood) {
        this.mood = mood;
    }

    int giveMark(){
        return mood.giveMark();
    }

    public static void main(String[] args) {
        CanMark goodmood = new GoodMood();
        Trainer goodmoodedtrainer = new Trainer(goodmood);
        System.out.println(goodmoodedtrainer.giveMark());
        CanMark badmood = new BadMood();
        Trainer badmoodrtrainer = new Trainer(badmood);
        System.out.println(badmoodrtrainer.giveMark());
    }
}
