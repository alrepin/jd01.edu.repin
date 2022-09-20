package ga.repin.education.creation;

public class HtmlWrappers {
    public static boolean nightTheme = false;
    public static String mainTheme(String unformattedString) {
        String bgcolor = "";
        String textcolor = "";
        String caption = "";
        if (nightTheme) {
            bgcolor = "\"darkblue\"";
            textcolor = "\"lightblue\"";
            caption = "ДЕНЬ";
        } else {
            bgcolor = "\"olive\"";
            textcolor = "\"Yellow\"";
            caption = "НОЧЬ";
        }
        return "<html><body link=" + textcolor +
                "vlink=" + textcolor +
                "bgcolor=" + bgcolor +
                "text=" + textcolor +
                "><h2>" +
                unformattedString +
                "<hr><a href=\"/.\">[ДОМОЙ]</a> | " +
                "<a href=\"javascript:history.back()\">[НАЗАД]</a> | " +
                "<a href=\"/switchtheme\">[" +
                caption +
                "]</a><hr>" +
                "</h2></body></html>";
    }

}
