package exercise;

import java.util.List;

// BEGIN
class App{
    public  static int getCountOfFreeEmails(List<String> emails) {
        String[] freeEmails = {"gmail.com", "yandex.ru", "hotmail.com"};
        int emailsCount = 0;

        for (String domen : freeEmails) {
            emailsCount += (int) emails.stream()
                    .filter(name -> name.endsWith(domen))
                    .count();
        }
        return emailsCount;
    }
}
// END
