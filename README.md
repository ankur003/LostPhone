# LostPhone

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(final String[] args) {
        findSunWeekendsList(2020);
        findSatSunWeekendsList(2020);

    }

    public static void findSunWeekendsList(final int year) {
        final ArrayList<Date> weekendList = new ArrayList<>();
        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 1, 0, 0);
        while (calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SUNDAY:
                    weekendList.add(calendar.getTime());
                    break;
                default:
                    break;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        System.out.println("SUN --> " + weekendList);
    }

    public static void findSatSunWeekendsList(final int year) {
        final ArrayList<Date> weekendList = new ArrayList<>();
        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 1, 0, 0);
        while (calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                case Calendar.SUNDAY:
                    weekendList.add(calendar.getTime());
                    break;
                default:
                    break;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        System.out.println("SAT SUN--> " + weekendList);
    }

}
