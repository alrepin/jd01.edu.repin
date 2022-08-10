import course01.topic10.hw.Hw10;
import course01.topic10.lesson.Lesson10;
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
        hwCaption("Методы объектов", false, 16828);
        Hw10.main();
        Lesson10.main();
    }
}