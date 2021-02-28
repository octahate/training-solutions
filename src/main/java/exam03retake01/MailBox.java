package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mailbox = new ArrayList<>();


    public void addMail(Mail mail) {
        mailbox.add(mail);
    }

    public List<Mail> getMails() {
        return mailbox;
    }

    public List<Mail> findByCriteria(String query) {
        if (query.contains("from:")) {
            return mailSearchFrom(query);
        } else if (query.contains("to:")) {
            return mailSearchTo(query);
        } else {
            return mailSearchEtc(query);
        }
    }

    private List<Mail> mailSearchFrom(String query) {
        if (query.contains("@")) {
            return mailSearchFromContainsAt(query);
        } else
            return mailSearchFromContainsName(query);
    }

    private List<Mail> mailSearchFromContainsAt(String query) {
        String name = query.split(":")[1];
        List<Mail> result = new ArrayList<>();
        for (Mail currentMail : mailbox) {
            if (currentMail.getFrom().getEmail().equals(name))
                result.add(currentMail);
        }
        return result;
    }

    private List<Mail> mailSearchFromContainsName(String query) {
        String name = query.split(":")[1];
        List<Mail> result = new ArrayList<>();
        for (Mail currentMail : mailbox) {
            if (currentMail.getFrom().getName().equals(name)) {
                result.add(currentMail);
            }
        }
        return result;
    }


    private List<Mail> mailSearchTo(String query) {
        if (query.contains("@")) {
            return mailSearchFromContainsAt(query);
        } else
            return mailSearchToContainsName(query);
    }

    private List<Mail> mailSearchToContainsAt(String query) {
        String name = query.split(":")[1];
        List<Mail> result = new ArrayList<>();
            for (Mail currentMail : mailbox) {
                for (Contact currentContact : currentMail.getTo()) {
                    if (currentContact.getEmail().equals(name)) {
                        result.add(currentMail);
                    }
                }
            }
        return result;
    }

    private List<Mail> mailSearchToContainsName (String query){
        String name = query.split(":")[1];
        List<Mail> result = new ArrayList<>();
        for (Mail currentMail : mailbox) {
            for (Contact currentContact : currentMail.getTo()) {
                if (currentContact.getName().equals(name)) {
                    result.add(currentMail);
                }
            }
        }
        return result;
    }

    private List<Mail> mailSearchEtc(String query) {
        List<Mail> result = new ArrayList<>();
        for (Mail currentMail : mailbox) {
            if (currentMail.getMessage().contains(query) || currentMail.getSubject().contains(query)) {
                result.add(currentMail);
            }
        }
        return result;
    }
}
