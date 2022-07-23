import course00.topic00.lesson.Lesson00;
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
        hwCaption("", false, 168);
        course00.topic00.hw.Hw00.main();
        course00.topic00.lesson.Lesson00.main();
    }
}