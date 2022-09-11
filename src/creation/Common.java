package creation;

import java.util.ArrayList;

public class Common {
    public static ArrayList<Integer> rndIntGenerated = new ArrayList<Integer>();
    public static ArrayList<Integer> rnd0_100Generated = new ArrayList<Integer>();
    public static void hwCaption(String caption, boolean isReady, int linkNum) {
        String strIsReady = "";
        if (isReady) {
            strIsReady = "зачтено";
        }
        System.out.println("\nДомашнее задание по уроку \"" + caption + "\" " + strIsReady);
        System.out.println("https://my.sky.pro/student-cabinet/stream-lesson/" + linkNum + "/homework");
    }

    public static String randomBookName(){
        String[] arrWords = {"Война", "Мир", "Лёд", "Пламя", "Зима", "Лето", "Добро", "Зло"};
        java.util.Random random = new java.util.Random();
        return arrWords[random.nextInt(7) + 1] + " и " + arrWords[random.nextInt(7) + 1];
    }

    public static String randomName(){
        String[] arrName = {"Петр", "Иван", "Василий", "Сидор", "Евгений", "Федор"};
        java.util.Random random = new java.util.Random();
        return arrName[random.nextInt(5) + 1];
    }

    public static String randomSurname(){
        String[] arrSurname = {"Петров", "Иванов", "Пупкин", "Сидоров", "Пушкин", "Федоров"};
        java.util.Random random = new java.util.Random();
        return arrSurname[random.nextInt(5) + 1];
    }

    public static int randomValuePositive() {
        java.util.Random random = new java.util.Random();
        int initSize = rndIntGenerated.size();
        int currentRandom;
        int result = -1;
        while (rndIntGenerated.size() == initSize){
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
        while (rnd0_100Generated.size() == initSize){
            currentRandom = random.nextInt(100) + 0;
            if (!rnd0_100Generated.contains(currentRandom)) {
                rnd0_100Generated.add(currentRandom);
                result = currentRandom;
            }
        }
        return result;
    }
}
