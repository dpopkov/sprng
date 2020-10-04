package learn.spr.sh4b.hibernatetutor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDate(String dateStr) throws ParseException {
        return formatter.parse(dateStr);
    }

    public static String formatDate(Date date) {
        String result = null;
        if (date != null) {
            result = formatter.format(date);
        }
        return result;
    }
}
