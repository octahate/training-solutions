package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member {

    private String name;
    private List<Member> connections = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void connectMember(Member contact){
        connections.add(contact);
    }

    private List<String> connectedNames(){
        List<String> names = new ArrayList<>();
        for (Member currentMember: connections){
            names.add(currentMember.getName());
        }
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) && Objects.equals(connections, member.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, connections);
    }

    @Override
    public String toString() {
        return name + " bejelölt tagok: " + connectedNames();
    }
}
