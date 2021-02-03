package collectionsmap;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    static final String REGEX = ":";
    static final int AMOUNT_OF_ENTRIES_IN_LINE = 3;
    static final int IP_PLACE = 0;
    static final int LOGIN_TIME_PLACE = 1;
    static final int LOGIN_CREDENTIAL_PLACE = 2;
    static final String DATE_FORMAT = "yyyy-MM-dd";



    public List<Entry> parseEntryList(String log){
        List<Entry> solution = new ArrayList<>();
        try (Scanner sc = new Scanner(log)) {
            LocalDate loginDate;
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] entry = currentLine.split(REGEX);
                if (entry.length != AMOUNT_OF_ENTRIES_IN_LINE) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                try {
                    loginDate = LocalDate.parse(entry[LOGIN_TIME_PLACE]);
                } catch (DateTimeParseException pe) {
                    throw new IllegalArgumentException("Incorrect log: incorrect date");
                }
                Entry currentEntry = new Entry(entry[IP_PLACE], loginDate, entry[LOGIN_CREDENTIAL_PLACE]);
                solution.add(currentEntry);
            }
        }
        return solution;
    }

    public  Map<String, List<Entry>> parseLog(String log){
        List<Entry> list = parseEntryList(log);
        Map<String, List<Entry>> solution = new HashMap<>();
        for (Entry currentEntry : list){
            if (!solution.containsKey(currentEntry.getIp())){
                solution.put(currentEntry.getIp(), new ArrayList<>());
            }
            solution.get(currentEntry.getIp()).add(currentEntry);
        }
        return solution;
    }



}
