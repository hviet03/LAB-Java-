package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Task;

public class InOutUtils {

    private Scanner sc = new Scanner(System.in);

    public String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public String getNonEmptyString(String mess) {
        String ret = "";
        while (true) {
            System.out.print(mess);
            ret = removeUnnecessaryBlank(sc.nextLine());
            if (ret.equalsIgnoreCase("")) {
                System.err.println("Please input Non-Empty String!!!");
                continue;
            }
            return ret;
        }
    }

    public int getInt(String mess, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, "Must be number format", "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println("Please enter in range " + min + " - " + max);
            } else {
                return ret;
            }
        }
    }

    public double getDouble(String mess, String errorNumberFormat, String errorOutOfRange, double NumberOfDigitAfterDecimal, double min, double max) {
        while (true) {
            double ret = Double.parseDouble(getStringByRegex(mess, errorNumberFormat, "-?\\d+(?:\\.\\d+)?"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return (double) (Math.round(ret * NumberOfDigitAfterDecimal) / NumberOfDigitAfterDecimal);
            }
        }
    }

    public String getStringByRegex(String mess, String error, String regex) {
        String output = null;
        while (true) {
            System.out.print(mess);
            output = sc.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public String getDate(String mess, String dateFormatInput, String regex) {
        while (true) {
            String dateInput = getStringByRegex(mess, "Invalid input format! " + dateFormatInput + "\n", regex);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatInput);
            dateFormat.setLenient(false);
            try {
                date = dateFormat.parse(dateInput);
                return dateFormat.format(date);
            } catch (ParseException e) {
                System.err.println("Date does not exist!");
            }
        }
    }

    public int checkIdExisted(ArrayList<Task> taskList, int id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int inputIntInRange(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Must be in range! Try again.");
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
            }
        }
    }
}
