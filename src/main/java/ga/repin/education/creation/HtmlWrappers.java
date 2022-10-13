package ga.repin.education.creation;

public class HtmlWrappers {
    public static final String BR="<br>";
    public static final String HR="<hr>";
    public static boolean nightTheme = false;

    public static String hrefPrep(String link, String text) {
        if (text == null) {
            text = link;
        }
        return "<a href=\"" +
                link +
                "\">" +
                text +
                "</a>";
    }

    public static String commentPrep(String text, Integer size ) {
        String result = null;
        if (size == null) {
            size = 3;
        }
        result = "<br><i><font face=\"Times New Roman\" size=\"" +
                size +
                "\">" +
                text + "</font></i><br>";
        return result;
    }

    public static String textFieldPrep(String text){
        String result =
                "<br><textarea cols=\"90\" rows=\"1\">" + text + "</textarea><br>";
        return result;
    }

    public static String mainTheme(String unformattedString) {
        String bgcolor = "";
        String textcolor = "";
        String caption = "";
        if (nightTheme) {
            bgcolor = "\"DimGray\"";
            textcolor = "\"WhiteSmoke\"";
            caption = "☀️";
        } else {
            bgcolor = "\"Gainsboro\"";
            textcolor = "\"DimGray\"";
            caption = "\uD83C\uDF19";
        }
        return "<html><head><style type=\"text/css\"> " +
                "A { text-decoration: none; " +
                "color: " + textcolor +
                "; background: " + bgcolor +
                ";} " +
                "A:hover { text-decoration: none; " +
                "color: black" + //bgcolor +
                "; background: " + textcolor +
                "; } </style></head>" + //+ "<body " +
                "<body link=" + textcolor +
                "vlink=" + textcolor +
                "bgcolor=" + bgcolor +
                "text=" + textcolor +
                "><h2>" +
                "<a href=\"/exit?pass=\">❌</a> | " +
                "<a href=\"/.\">\uD83C\uDFE0</a> | " +
                "<a href=\"javascript:history.back()\">◀️</a> | " +
                "<a href=\"/switchtheme\">" +
                caption +
                "</a><hr>" +
                unformattedString +
                "<hr>" +
                /*"<a href=\"/exit?pass=\">❌</a> | " +
                "<a href=\"/.\">\uD83C\uDFE0</a> | " +
                "<a href=\"javascript:history.back()\">◀️</a> | " +
                "<a href=\"/switchtheme\">" +
                caption +
                "</a><hr>" +*/
                "</h2></body></html>";
    }

}
