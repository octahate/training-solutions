package classstructureattributes;
public class TrainerMain {
    public static void main(String[] args) {
        Trainer trainer = new Trainer(); // 1
        trainer.name = "John Doe";
        trainer.yearOfBirth = 1980;
        System.out.println(trainer.name);
        System.out.println(trainer.yearOfBirth);
        Trainer anotherTrainer = new Trainer(); // 2
        anotherTrainer.name = "Jack Doe";
        System.out.println(anotherTrainer.getName());
        System.out.println(trainer.getNameAndYearOfBirth());
        anotherTrainer.changeName("Joe Doe");
        System.out.println(anotherTrainer.getName());

    }

}

