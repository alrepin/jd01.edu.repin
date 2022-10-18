package ga.repin.education.creation;

public class HtmlWrappers {
    public static final String BR="<br>";
    public static final String HR="<hr>";
    public static boolean nightTheme = false;

    public static String orderFormSnippet(String sessionId){
        return
                //"    <div id=\"demo\">Select goods and push +</div>\n" +
                        "<form action=\"add\" method=\"GET\" name=\"myForm\">\n" +
                        "\n" +
                        "    <select name=\"db\" id=\"db\">\n" +
                        "        <option value=\"1\"> good 1\n" +
                        "        <option value=\"2\"> good 2\n" +
                        "        <option value=\"3\"> good 3\n" +
                        "        <option value=\"4\"> good 4\n" +
                        "        <option value=\"5\"> good 5\n" +
                        "        <option value=\"6\"> good 6\n" +
                        "        <option value=\"7\"> good 7\n" +
                        "        <option value=\"8\"> good 8\n" +
                        "    </select>\n" +
                        "    <input type=\"button\" name=\"addButton\" value=\"+\"/>\n" +
                        "    <input type=\"button\" name=\"removeButton\" value=\"-\"/>\n" +
                        "    <input type=\"button\" onclick=\"clearOptions()\" value=\"Clear\">\n" +
                        "    <input type=\"button\" onclick=\"addOrder()\" value=\"Execute request\">\n" +
                        "    <br>\n" +
                        "    <select name=\"ids\" id=\"ids\" size=\"15\" style=\"width: 300px !important; min-width: 300px; max-width: 300px;\">\n" +
                        "    </select>\n" +
                        "</form>\n" +
                        "\n" +
                        "<script>\n" +
                        "    var addButton = myForm.addButton,\n" +
                        "        removeButton = myForm.removeButton,\n" +
                        "        ids = myForm.ids;\n" +
                        "\n" +
                        "    function addOrder() {\n" +
                        "        let key = Array.from(document.getElementById(\"ids\").options).map(e => e.value);\n" +
                        "        let url = `/store/order/add?ids=${key}`;\n" +
                        "        let xhr = new XMLHttpRequest();\n" +
                        "        xhr.withCredentials = true;\n" +
                        "        xhr.open('GET', url, true);\n" +
                        "        xhr.send();\n" +
                        "        xhr.onreadystatechange = function() {\n" +
                        "            if (xhr.status != 200) {\n" +
                        "                document.getElementById(\"demo\").innerHTML = `Err ${xhr.status}`;\n" +
                        "            } else {\n" +
                        "                document.getElementById(\"demo\").innerHTML = `Request processed successfully`;\n" +
                        "            }\n" +
                        "        };\n" +
                        "    }\n" +
                        "\n" +
                        "    function clearOptions() {\n" +
                        "        let select_item = document.getElementById('ids');\n" +
                        "        let options = select_item.getElementsByTagName('option');\n" +
                        "\n" +
                        "        for (var i = options.length; i--;) {\n" +
                        "            select_item.removeChild(options[i]);\n" +
                        "        }\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "    function addOption() {\n" +
                        "        var obj = document.getElementById(\"db\");\n" +
                        "        var text = obj.options[obj.selectedIndex].text;\n" +
                        "        var value = myForm.db.value;\n" +
                        "        var newOption = new Option(text, value, false, true);\n" +
                        "        ids.options[ids.options.length] = newOption;\n" +
                        "        document.getElementById(\"demo\").innerHTML =\n" +
                        "            \"Preparing shopping cart adding request\";\n" +
                        "    }\n" +
                        "\n" +
                        "    function removeOption() {\n" +
                        "        var selectedIndex = ids.options.selectedIndex;\n" +
                        "        ids.options[selectedIndex] = null;\n" +
                        "       document.getElementById(\"ids\").options[document.getElementById(\"ids\").length-1].selected = true;\n" +
                        "    }\n" +
                        "    addButton.addEventListener(\"click\", addOption);\n" +
                        "    removeButton.addEventListener(\"click\", removeOption);\n" +
                        "</script>";
    }

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
        result = "<i><font face=\"Times New Roman\" size=\"" +
                size +
                "\">" +
                text + "</font></i>";
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
