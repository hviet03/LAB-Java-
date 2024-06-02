package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static boolean pressYNtoContinue(String mess) {
        //"Do you want to continue (Y/N): "
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static String normalFormName(String input) {
        input = removeUnnecessaryBlank(input);
        String temp[] = input.split(" ");
        input = "";
        for (int i = 0; i < temp.length; i++) {
            input += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                input += " ";
            }
        }
        return input;
    }

    public static String getNonEmptyString(String mess) {
        String ret = "";
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            ret = removeUnnecessaryBlank(scan.nextLine());
            if (ret.equalsIgnoreCase("")) {
                System.err.println("Please input Non-Empty String!!!");
                continue;
            }
            return ret;
        }
    }

    public static String normalFormStringAfterDot(String input) {
        String output = "";
        input = removeUnnecessaryBlank(input);
        input = String.valueOf(input.charAt(0)).toUpperCase() + input.substring(1);

        input = input.replaceAll("\\.\\s+", "\\.").replaceAll("\\s+\\.", "\\.");
        output += input.charAt(0);
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i - 1) == '.' && Character.isAlphabetic(input.charAt(i))) {
                output += " " + Character.toUpperCase(input.charAt(i));
            } else {
                output += input.charAt(i);
            }
        }
        return output;
    }

    public static int getInt(String mess, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, "Must be number format", "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println("Please enter in range " + min + " - " + max);
            } else {
                return ret;
            }
        }
    }

    public static float getFloat(String mess, String errorNumberFormat, String errorOutOfRange, float min, float max) {
        while (true) {
            float ret = Float.parseFloat(getStringByRegex(mess, errorNumberFormat, "[0-9.]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }
    }

    public static double getDouble(String mess, String errorNumberFormat, String errorOutOfRange, double NumberOfDigitAfterDecimal, double min, double max) {
        while (true) {
            double ret = Double.parseDouble(getStringByRegex(mess, errorNumberFormat, "[0-9]+[.0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return (double) (Math.round(ret * NumberOfDigitAfterDecimal) / NumberOfDigitAfterDecimal);
            }
        }
    }

    public static double getDoubleWithRegex(String mess, String errorNumberFormat, String errorOutOfRange, String regex, String regex1, double min, double max) {
        while (true) {
            double ret = Double.parseDouble(getStringByManyRegex(mess, errorNumberFormat, regex, regex1));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return (double) (Math.round(ret * 10.0) / 10.0);
            }
        }
    }

    public static float getFloat(String mess, double min, double max) {
        float ret;
        Scanner scan = new Scanner(System.in);
        System.out.print(mess);
        do {
            try {
                ret = Float.parseFloat(scan.nextLine());
                if (ret < min || ret > max) {
                    throw new IndexOutOfBoundsException();
                }
                return ret;
            } catch (NumberFormatException e) {
                System.out.println("Only allowed to enter number");
                System.out.print(mess);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter number in range [" + min + "," + max + "]");
                System.out.print(mess);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (true);

    }

    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static String getStringByManyRegex(String mess, String error, String regex, String regex1) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine();
            if (output.matches(regex) || output.matches(regex1)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static String getEmail(String mess) {

        String regex = "^[A-Za-z](.*)([@]{1})(.{2,})(\\.)(.{2,})";//phai bat dau bang chu cai
        String email = getStringByRegex(mess, "Please enter email with format <account name>@<domain>", regex);
        return email;
    }

    public static String getPhone(int minLength, String mess) {
        String regex = "[0-9 ]+";
        while (true) {
            String phoneNum = getStringByRegex(mess, "Please enter number only!!", regex).replaceAll("\\s+", "");
            if (phoneNum.length() < minLength) {
                System.err.println("Phone number must be at least 10 characters");
            } else {
                return phoneNum;
            }
        }
    }

    public static String getDate(String mess, String dateFormatInput, String regex) {
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

}
