public class Main {
    public static void hwCaption(String caption, boolean isReady, int linkNum) {
        String strIsReady = "";
        if (isReady) {
            strIsReady = "зачтено";
        }
        System.out.println("\nДомашнее задание по уроку \"" + caption + "\" " + strIsReady);
        System.out.println("https://my.sky.pro/student-cabinet/stream-lesson/" + linkNum + "/homework");
    }
    public static void main(String[] args) {
        hwCaption("Установка инструментов разработчика", true, 16819);
        course01.topic01.hw.Hw01.main();
        hwCaption("Переменные", true, 16820);
        course01.topic02.hw.Hw02.main();
        hwCaption("Условные операторы", true, 16821);
        course01.topic03.hw.Hw03.main();
        hwCaption("Циклы", true, 16822);
        course01.topic04.hw.Hw04.main();
        hwCaption("Массивы", true, 16823);
        course01.topic05.hw.Hw05.main();
        hwCaption("Массивы ч.2", true, 16824);
        course01.topic06.hw.Hw06.main();
        hwCaption("Строки", true, 16825);
        course01.topic07.hw.Hw07.main();
        hwCaption("Методы", true, 16826);
        course01.topic08.hw.Hw08.main();

    }
}