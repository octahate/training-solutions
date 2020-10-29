package classstructuremethods;
public class TrainerMain {
    public static void main(String[] args) {
        Trainer trainer = new Trainer(); // 1
        trainer.setName ( "John Doe");
        trainer.setYearOfBirth (1980);
        System.out.println(trainer.getName());
        System.out.println(trainer.getYearOfBirth());
        Trainer anotherTrainer = new Trainer(); // 2
        Trainer yetAnotherTrainer = new Trainer();
        anotherTrainer.setName("Jack Doe");
        System.out.println(anotherTrainer.getName());
        System.out.println(trainer.getNameAndYearOfBirth());
        anotherTrainer.changeName("Joe Doe");
        System.out.println(anotherTrainer.getName());
        anotherTrainer.changeName("Jack Doe");
        System.out.println(anotherTrainer.getName());
        yetAnotherTrainer.changeName("Kiss Péter");
        System.out.println(yetAnotherTrainer.getName());



    }

}

