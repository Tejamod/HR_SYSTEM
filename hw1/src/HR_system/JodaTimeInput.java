package HR_system;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JodaTimeInput {
        public static DateTime jodaTimeInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the date and time in this format: YYYY-MM-DD HH:mm (ex: 2024-01-01 12:00)");
            String userInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
            DateTime dateTime = formatter.parseDateTime(userInput);
            return dateTime;

        }
    }

