package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Programozás");
        note.setTopic("structuremethods");
        note.setText("Ez a szöveg metódusokkal lett legenerálva.");
        System.out.println(note.getNoteText());
    }
}
