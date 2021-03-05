package covid;

import java.util.Scanner;

public class CovidMain {

    public String[] addAndCheckSingleItem() {
        String[] data = new String[5];
        Validator validator = new Validator();
        Scanner sc = new Scanner(System.in);
        CovidDao cd = new CovidDao();
        try {
            System.out.println("Kérem a páciens nevét!");
            data[0] = validator.isNameValid(sc.nextLine());
            System.out.println("Kérem a páciens irányítószámát!");
            data[1] = validator.isZipValid(sc.nextLine());
            System.out.println(cd.returnCitiesWithZipcodeStatement(cd.initializeDataSource(),Integer.parseInt(data[1])));
            System.out.println("Kérem a páciens életkorát!");
            data[2] = validator.isAgeValid(sc.nextLine());
            System.out.println("Kérem a páciens e-mail címét!");
            data[3] = validator.isEmailValid(sc.nextLine());
            System.out.println("Kérem a páciens TAJ számát!");
            data[4] = validator.isSNNValid(sc.nextLine());
            System.out.println("A páciens adatai: " + String.join(", ",data));
            cd.addPersonToDatabase(cd.initializeDataSource(),data);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
            addAndCheckSingleItem();
        }
        return data;
    }

    public void vaccinatePerson(String ssn){
        CovidDao cd = new CovidDao();
        Scanner sc = new Scanner(System.in);
        String vaccineType = null;
        String administer = null;
        switch (cd.returnAmountOfDoses(cd.initializeDataSource(), ssn)) {
            case 0 -> {
                System.out.println("Adja meg a vakcina típusát");
                vaccineType = sc.nextLine();
                System.out.println("Adja meg az oltás időpontját \" yyyy-mm-dd hh:mm:ss \" formátumban!");
                administer = sc.nextLine();
                cd.addDoseOfVaccine(cd.initializeDataSource(), ssn, vaccineType, administer);
                break;
            }
            case 1 -> {
                vaccineType = cd.getFirstDoseInformation(cd.initializeDataSource(), ssn);
                System.out.println("Adja meg az oltás időpontját \" yyyy-mm-dd hh:mm:ss \" formátumban!");
                administer = sc.nextLine();
                cd.addDoseOfVaccine(cd.initializeDataSource(), ssn, vaccineType, administer);
                break;
            }
            default -> throw new IllegalArgumentException("A beteg megkapta a megfelelő mennyiségű vakcinát!");
        }

    }

    public void initializeMenu(){
        System.out.println("Kérem válasszon az alábbi menüpontok közül:");
        System.out.println("1. Regisztráció");
        System.out.println("2. Tömeges regisztráció");
        System.out.println("3. Generálás");
        System.out.println("4. Oltás");
        System.out.println("5. Oltás meghíusulás");
        System.out.println("6. Riport");
    }



    public static void main(String[] args) {

        CovidDao cd = new CovidDao();
        CovidMain cm = new CovidMain();
        Scanner sc = new Scanner(System.in);
        cm.initializeMenu();
        switch (sc.nextLine()) {
            case "1":
                cm.addAndCheckSingleItem();
                cm.initializeMenu();
                break;

            case "2":
                System.out.println("Adja meg a file helyét!");
                cd.massDatabaseFill(cd.initializeDataSource(), sc.nextLine());
                System.out.println("Adatbázis sikeresen frissítve!");
                break;
            case "3":
                System.out.println("Adja meg az irányítószámot!");
                cd.generateVaccinationList(cd.initializeDataSource(), sc.nextLine());
                break;
            case "4":
                System.out.println("Kérem a páciens TAJ számát!");
                cm.vaccinatePerson(sc.nextLine());
                break;
            case "5":
                System.out.println("Kérem a páciens TAJ számát!");
                String ssn = sc.nextLine();
                System.out.println("Mi volt a probléma? Kérem írja le röviden:");
                String error = sc.nextLine();
                cd.addInvalidVaccine(cd.initializeDataSource(),ssn,error);
                break;
        }
    }
}
