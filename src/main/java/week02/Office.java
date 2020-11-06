package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printNamesReverse() {
        int temp = meetingRooms.size();
        for (int i = temp; i != 0; i--) {
            System.out.println(meetingRooms.get(i-1).getName());
        }
    }

    public void printEventNames() {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if ((i+1) % 2 == 0)
                System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printArea() {
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println("Név: " + meetingRooms.get(i).getName());
            System.out.println("Szélesség: " + meetingRooms.get(i).getWidth());
            System.out.println("Hosszúság: " + meetingRooms.get(i).getLength());
            System.out.println("Terület: " + meetingRooms.get(i).getArea());
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            String temp;
            temp = meetingRooms.get(i).getName();
            if (temp.equals(name)) {
                System.out.println("Szélessége: " + meetingRooms.get(i).getWidth());
                System.out.println("Hosszúsága: " + meetingRooms.get(i).getLength());
                System.out.println("Területe: " + meetingRooms.get(i).getArea());

            }
        }
    }
    public void printMeetingRoomsContains(String part) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            String temp;
            temp = meetingRooms.get(i).getName();
            temp.toLowerCase();
            if (temp.contains(part)) {
                System.out.println("Neve: " + meetingRooms.get(i).getName());
                System.out.println("Szélessége: " + meetingRooms.get(i).getWidth());
                System.out.println("Hosszúsága: " + meetingRooms.get(i).getLength());
                System.out.println("Területe: " + meetingRooms.get(i).getArea());
            }
        }
    }
    public void printAreasLargerThan(int area) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            int temp = meetingRooms.get(i).getArea();
            if (temp > area) {
                System.out.println("Neve: " + meetingRooms.get(i).getName());
                System.out.println("Szélessége: " + meetingRooms.get(i).getWidth());
                System.out.println("Hosszúsága: " + meetingRooms.get(i).getLength());
                System.out.println("Területe: " + meetingRooms.get(i).getArea());
            }
        }
    }

}





