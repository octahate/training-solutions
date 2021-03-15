package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> users = new ArrayList<>();

    public void addMember(String name) {
        users.add(new Member(name));
    }

    private Member findByName(String name) {
        for (Member currentUser : users) {
            if (currentUser.getName().equals(name)) {
                return currentUser;
            }
        }
        throw new IllegalArgumentException("Cannot find such user!");
    }

    public void connect(String name, String otherName) {
        Member member1 = findByName(name);
        Member member2 = findByName(otherName);
        member1.connectMember(member2);
    }

    public List<String> bidirectionalConnections() {
        List<String> connections = new ArrayList<>();
        for (Member currentMember : users) {
            for (Member memberConnections : currentMember.getConnections()) {
                for (Member anotherMember : users) {
                    if (memberConnections.equals(anotherMember)) {
                        connections.add(currentMember.getName() + " - " + anotherMember.getName());
                    }
                }
            }
        }
        return connections;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Member currentMember: users){
            sb.append(currentMember.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.addMember("Joe");
        socialNetwork.addMember("John");
        socialNetwork.addMember("Jane");
        socialNetwork.addMember("Richard");

        socialNetwork.connect("Joe", "John");
        socialNetwork.connect("John", "Joe");

        System.out.println(socialNetwork.bidirectionalConnections());
        System.out.println(socialNetwork.toString());
    }
}
