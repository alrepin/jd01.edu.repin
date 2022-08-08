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
        hwCaption("Объекты и классы", true, 16827);
        course01.topic09.hw.Hw09.main();
    }
}