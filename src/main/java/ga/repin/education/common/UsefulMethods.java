package ga.repin.education.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import ga.repin.education.course02.topic10.hw.employees.exceptions.HttpException;
import org.apache.commons.lang3.*;
import org.springframework.http.HttpStatus;

import static ga.repin.education.common.HtmlWrappers.hrefPrep;

public class UsefulMethods {
    public static List<Integer> rndIntGenerated = new ArrayList<>();
    public static List<Integer> rnd0_100Generated = new ArrayList<>();
    public static List<String> rndJsonFI = new ArrayList<>();
    private static long measurementStartTime;
    
    public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sb", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
    }
    
    public static String humanReadableByteCountSI(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }
    
    public static String humanReadableByteCountBin(long bytes) {
        long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
        if (absB < 1024) {
            return bytes + " B";
        }
        long value = absB;
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");
        for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
            value >>= 10;
            ci.next();
        }
        value *= Long.signum(bytes);
        return String.format("%.1f %ciB", value / 1024.0, ci.current());
    }
    
    
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static Integer[] generateRandomIntegerArray() {
        return generateRandomIntegerArray(100_000);
    }

    public static Integer[] generateRandomIntegerArray(int capacity) {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[capacity];
        for (Integer i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(capacity) + capacity;
        }
        return arr;
    }

    public static String getMd5(String input) {
        try {
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);
            return null;
        }
    }

    public static String customReplaceAll(String str, String oldStr, String newStr) {

        if ("".equals(str) || "".equals(oldStr) || oldStr.equals(newStr)) {
            return str;
        }
        if (newStr == null) {
            newStr = "";
        }
        final int strLength = str.length();
        final int oldStrLength = oldStr.length();
        StringBuilder builder = new StringBuilder(str);

        for (int i = 0; i < strLength; i++) {
            int index = builder.indexOf(oldStr, i);

            if (index == -1) {
                if (i == 0) {
                    return str;
                }
                return builder.toString();
            }
            builder = builder.replace(index, index + oldStrLength, newStr);

        }
        return builder.toString();
    }

    public static String transliterate(String inpStr) {
        String[] abcCyr = {" ", "щ", "ё", "ш", "ц", "ж", "ч", "а", "б", "в", "г", "д", "е", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ъ", "ы", "ь", "э", "ю", "я", "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] abcLat = {" ", "sch", "yo", "sh", "ts", "zh", "ch", "a", "b", "v", "g", "d", "e", "z", "i", "y", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "", "i", "", "e", "ju", "ja", "A", "B", "V", "G", "D", "E", "E", "Zh", "Z", "I", "Y", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "Ts", "Ch", "Sh", "Sch", "", "I", "", "E", "Ju", "Ja", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int x = 0; x < abcLat.length; x++) {
            inpStr = customReplaceAll(inpStr, abcCyr[x], abcLat[x]);
        }
        return inpStr;
    }

    public static String untransliterate(String inpStr) {
        String[] abcCyr = {" ", "щ", "ё", "ш", "ц", "ж", "ч", "а", "б", "в", "г", "д", "е", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ъ", "ы", "ь", "э", "ю", "я", "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] abcLat = {" ", "sch", "yo", "sh", "ts", "zh", "ch", "a", "b", "v", "g", "d", "e", "z", "i", "y", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "", "i", "", "e", "ju", "ja", "A", "B", "V", "G", "D", "E", "E", "Zh", "Z", "I", "Y", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "Ts", "Ch", "Sh", "Sch", "", "I", "", "E", "Ju", "Ja", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int x = 0; x < abcLat.length; x++) {
            inpStr = customReplaceAll(inpStr, abcLat[x], abcCyr[x]);
        }
        return inpStr;
    }

    public static boolean isUnicodeFilled(String... strField) {
        boolean isFilledVar = true;
        for (int i = 0; i < strField.length; i++) {
            isFilledVar = isFilledVar &&
                    StringUtils.isAlpha(strField[i]) &&
                    !(strField[i] == null ||
                            strField[i].isBlank());
        }
        if (!isFilledVar){
            throw new HttpException("Key params not contains only Unicode letters", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static boolean isFilled(Object... obj) {
        for (int i = 0; i < obj.length; i++) {
            return !(obj[i] == null || (obj[i].toString().equals("")));
        }
        return true;
    }

    public static void hwCaption(String caption, boolean isReady, int linkNum) {
        String strIsReady = "not passed yet";
        if (isReady) {
            strIsReady = "passed";
        }
        System.out.println("\nHomework for the lesson \"" + caption + "\" " + strIsReady);
        System.out.println("https://my.sky.pro/student-cabinet/stream-lesson/" + linkNum + "/homework");
    }

    public static String hwCaption(String caption, boolean isReady, String linkSkyproNum) {
        String strIsReady = "not passed yet";
        if (isReady) {
            strIsReady = "passed";
        }
        String result = null;
        result = hrefPrep("https://my.sky.pro/student-cabinet/stream-lesson/" +
                        linkSkyproNum + "/homework",
                "Homework for the lesson \"" + caption + "\"") +
                " " +
                strIsReady;
        return result;
    }

    public static String hwCaption(String caption, boolean isReady, String linkSkyproNum, int prNum) {
        String strIsReady = "not passed yet";
        if (isReady) {
            strIsReady = "passed";
        }
        String result = null;
        result = hrefPrep("https://github.com/alrepin/education/pull/" +
                        prNum,
                "Homework for the lesson \"" + caption + "\"") +
                " " +
                hrefPrep("https://my.sky.pro/student-cabinet/stream-lesson/" +
                        linkSkyproNum + "/homework",strIsReady)
                ;
        return result;
    }

    public static String randomBookName() {
        String[] arrWords = {"Война", "Мир", "Лёд", "Пламя", "Зима", "Лето", "Добро", "Зло"};
        java.util.Random random = new java.util.Random();
        return arrWords[random.nextInt(7) + 1] + " и " + arrWords[random.nextInt(7) + 1];
    }

    public static String randomName() {
        String[] arrName = {"Петр", "Иван", "Василий", "Сидор", "Евгений", "Федор"};
        java.util.Random random = new java.util.Random();
        return arrName[random.nextInt(5) + 1];
    }

    public static String randomSurname() {
        String[] arrSurname = {"Петров", "Иванов", "Пупкин", "Сидоров", "Пушкин", "Федоров"};
        java.util.Random random = new java.util.Random();
        return arrSurname[random.nextInt(5) + 1];
    }

    public static String randomUnicalFI() {
        if (rndJsonFI.size() > 9) {
            rndJsonFI.clear();
        }
        int initSize = rndJsonFI.size();
        String currentRandom;
        String result = "";
        while (rndJsonFI.size() == initSize) {
            currentRandom =
                    "firstName=" +
                            randomName() +
                            "&lastName=" +
                            randomSurname() +
                            "";
            ;
            if (!rndJsonFI.contains(currentRandom)) {
                rndJsonFI.add(currentRandom);
                result = currentRandom;
            }
        }
        return result;
    }

    public static String randomJsonFI() {
        if (rndJsonFI.size() > 9) {
            rndJsonFI.clear();
        }
        int initSize = rndJsonFI.size();
        String currentRandom;
        String result = "";
        while (rndJsonFI.size() == initSize) {
            currentRandom =
                    "firstName=" +
                            randomName() +
                            "&lastName=" +
                            randomSurname() +
                            "";
            ;
            if (!rndJsonFI.contains(currentRandom)) {
                rndJsonFI.add(currentRandom);
                result = currentRandom;
            }
        }
        return result;
    }

    public static int randomValuePositive() {
        java.util.Random random = new java.util.Random();
        int initSize = rndIntGenerated.size();
        int currentRandom;
        int result = -1;
        while (rndIntGenerated.size() == initSize) {
            currentRandom = random.nextInt(2147483647) + 0;
            if (!rndIntGenerated.contains(currentRandom)) {
                rndIntGenerated.add(currentRandom);
                result = currentRandom;
            }
        }
        return result;
    }

    public static int randomValueIn0_100interval() {
        java.util.Random random = new java.util.Random();
        if (rnd0_100Generated.size() > 95) {
            rnd0_100Generated.clear();
        }
        int initSize = rnd0_100Generated.size();
        int currentRandom;
        int result = -1;
        while (rnd0_100Generated.size() == initSize) {
            currentRandom = random.nextInt(100) + 0;
            if (!rnd0_100Generated.contains(currentRandom)) {
                rnd0_100Generated.add(currentRandom);
                result = currentRandom;
            }
        }
        return result;
    }
    
    public static double markTheTime(boolean finish) {
        if (finish) {
            return (System.currentTimeMillis() - measurementStartTime) / 1000.0;
        } else {
            measurementStartTime = System.currentTimeMillis();
        }
        return measurementStartTime;
    }
    
    public static HttpStatus statusByException(String exceptionMsg) {
        HttpStatus result = HttpStatus.I_AM_A_TEAPOT;
        result = exceptionMsg.matches("(?i).*" + "SQL" + ".*") ? HttpStatus.BAD_REQUEST : result;
        result = exceptionMsg.matches("(?i).*" + "constraint" + ".*") ? HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE : result;
        return result;
    }
}
