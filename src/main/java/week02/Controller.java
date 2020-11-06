package week02;

import java.util.Scanner;

public class Controller {
    Office office = new Office();

    public void readOffice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hány darab tárgyalót rögzítenél?");
        int amount = scanner.nextInt();
        for (int i = 0; i < amount; i++) {
            System.out.println((i + 1) + ". tárgyaló neve?");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println((i + 1) + ". tárgyaló hossza?");
            int length = scanner.nextInt();
            System.out.println((i + 1) + ". tárgyaló szélessége?");
            int width = scanner.nextInt();
            MeetingRoom meetingRoom = new MeetingRoom(name, length, width);
            office.addMeetingRoom(meetingRoom);
        }
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    public void runMenu() {
        System.out.println("Kérem, válasszon a fentebbi menüpontok közül:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            office.printNamesReverse();
        } else {
            if (choice == 2) {
                office.printNamesReverse();
            } else {
                if (choice == 3) {
                    office.printEventNames();
                } else {
                    if (choice == 4) {
                        office.printArea();
                    } else {
                        if (choice == 5) {
                            System.out.println("Melyik termet keresi?");
                            String name = scanner.nextLine();
                            office.printMeetingRoomsWithName(name);
                        } else {
                            if (choice == 6) {
                                System.out.println("Melyik termet keresi?");
                                String name = scanner.nextLine();
                                name.toLowerCase();
                                office.printMeetingRoomsContains(name);
                            } else {
                                if (choice == 7) {
                                    System.out.println("Mekkora méretű termet keres?");
                                    int area = scanner.nextInt();
                                    office.printAreasLargerThan(area);
                                }
                            }
                        }
                    }
                }
            }

        }
    }






    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }
}
