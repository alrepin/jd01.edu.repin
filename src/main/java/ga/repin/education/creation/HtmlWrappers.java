package ga.repin.education.creation;

public class HtmlWrappers {
    public static boolean nightTheme = false;
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
