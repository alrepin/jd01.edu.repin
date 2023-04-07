package ga.repin.education.common;

import java.util.Arrays;

import static ga.repin.education.peripheral.PeripheralConstants.*;

public class HtmlWrappers {
    public static final String BR = "<br>";
    public static final String HR = "<hr>";
    public static boolean nightTheme = false;
    
    public static String coursesTabs(int courseNum) {
        String[] underlineTagOpen = new String[10];
        String[] underlineTagClose = new String[10];
        Arrays.fill(underlineTagOpen, "");
        Arrays.fill(underlineTagClose, "");
        
        underlineTagOpen[courseNum] = "<u>";
        underlineTagClose[courseNum] = "</u>";
        
        return "Courses: " +
                underlineTagOpen[1] +
                hrefPrep(ROOT_URL_01, "First") +
                underlineTagClose[1] +
                " | " +
                underlineTagOpen[2] +
                hrefPrep(ROOT_URL_02, "Second") +
                underlineTagClose[2] +
                " | " +
                underlineTagOpen[3] +
                hrefPrep(ROOT_URL_03, "Third") +
                underlineTagClose[3] +
                " | " +
                underlineTagOpen[4] +
                hrefPrep(ROOT_URL_04, "Fourth") +
                underlineTagClose[4] +
                " | " +
                underlineTagOpen[5] +
                hrefPrep(ROOT_URL_05, "Fifth") +
                underlineTagClose[5] +
                " | " +
                underlineTagOpen[6] +
                hrefPrep(ROOT_URL_06, "Sixth") +
                underlineTagClose[6] +
        
                " | " +
                underlineTagOpen[7] +
                hrefPrep(ROOT_URL_07, "Seventh") +
                underlineTagClose[7] +
        
                " | " +
                underlineTagOpen[8] +
                hrefPrep(ROOT_URL_08, "Eighth") +
                underlineTagClose[8] +
        
                " | " +
                underlineTagOpen[9] +
                hrefPrep(ROOT_URL_09, "Ninth") +
                underlineTagClose[9] +
                
                HR +
                "The presented tasks were solved as a part of the educational process: " + BR
                ;
    }
    
    public static String orderFormSnippet(String sessionId) {
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
    
    public static String notificationListSnippet() {
        return
                "<div id=\"output2\"></div>\n" +
                        "\t\t\t<div id=\"output\"></div>\n" +
                        "\t\t\t<script>\n" +
                        "\t\t\t\twindow.onload = function () {\n" +
                        "\t\t\t\t\tdemo();\n" +
                        "\t\t\t\t};\n" +
                        "\n" +
                        "\t\t\t\tasync function demo() {\n" +
                        "\t\t\t\t\twhile (true) {\n" +
                        "\t\t\t\t\t\tdocument.getElementById(\"output2\").innerHTML = \" actualizing notification list...\";\n" +
                        "\t\t\t\t\t\tawait pause(2000);\n" +
                        "\t\t\t\t\t\tdocument.getElementById(\"output2\").innerHTML = \"<br>\";\n" +
                        "\t\t\t\t\t\tawait pause(2000);\n" +
                        "\t\t\t\t\t\tsendReqt(\"/notificationlist\");\n" +
                        "\t\t\t\t\t\tawait pause(5000);\n" +
                        "\t\t\t\t\t}\n" +
                        "\t\t\t\t}\n" +
                        "\n" +
                        "\t\t\t\tfunction pause(ms) {\n" +
                        "\t\t\t\t\treturn new Promise(resolve => setTimeout(resolve, ms));\n" +
                        "\t\t\t\t}\n" +
                        "\n" +
                        "\t\t\t\tfunction show(strOut) {\n" +
                        "\t\t\t\t\tvar myObj,\n" +
                        "\t\t\t\t\t\tx,\n" +
                        "\t\t\t\t\t\ttxt = \"\";\n" +
                        "\n" +
                        "\t\t\t\t\tmyObj = JSON.parse(strOut);\n" +
                        "\t\t\t\t\tfor (x in myObj) {\n" +
                        "\t\t\t\t\t\tlet date = new Date(Date.parse(myObj[x].dateTime));\n" +
                        "\t\t\t\t\t\tlet diff = date - new Date();\n" +
                        "\t\t\t\t\t\tconst days = diff > 0 ? Math.floor(diff / 1000 / 60 / 60 / 24) : 0;\n" +
                        "\t\t\t\t\t\tconst hours = diff > 0 ? Math.floor(diff / 1000 / 60 / 60) % 24 : 0;\n" +
                        "\t\t\t\t\t\tconst minutes = diff > 0 ? Math.floor(diff / 1000 / 60) % 60 : 0;\n" +
                        "\n" +
                        "\t\t\t\t\t\ttxt += \"<table width='500' cellspacing='0' cellpadding='10' border='1'>\";\n" +
                        "\n" +
                        "\t\t\t\t\t\ttxt +=\n" +
                        "\t\t\t\t\t\t\t\"<tr>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td width='100%' colspan='2'>\" +\n" +
                        "\t\t\t\t\t\t\t\" \" +\n" +
                        "\t\t\t\t\t\t\tmyObj[x].text.toUpperCase() +\n" +
                        "\t\t\t\t\t\t\t\"</td>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td>\" +\n" +
                        "\t\t\t\t\t\t\tdate.toLocaleDateString().slice(0, 15) +\n" +
                        "\t\t\t\t\t\t\t\" \" +\n" +
                        "\t\t\t\t\t\t\tdate.toLocaleTimeString().slice(0, 5) +\n" +
                        "\t\t\t\t\t\t\t\"</td>\" +\n" +
                        "\t\t\t\t\t\t\t\"</tr><tr>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td width='30%' align='center'>days\" +\n" +
                        "\t\t\t\t\t\t\t\"</td>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td width='30%' align='center'>hours\" +\n" +
                        "\t\t\t\t\t\t\t\"</td>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td width='30%' align='center'>minutes\" +\n" +
                        "\t\t\t\t\t\t\t\"</tr><tr>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td width='30%' align='center'>\" +\n" +
                        "\t\t\t\t\t\t\tdays +\n" +
                        "\t\t\t\t\t\t\t\"</td>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td width='30%' align='center'>\" +\n" +
                        "\t\t\t\t\t\t\thours +\n" +
                        "\t\t\t\t\t\t\t\"</td>\" +\n" +
                        "\t\t\t\t\t\t\t\"<td width='30%' align='center'>\" +\n" +
                        "\t\t\t\t\t\t\tminutes +\n" +
                        "\t\t\t\t\t\t\t\"</tr>\";\n" +
                        "\t\t\t\t\t}\n" +
                        "\t\t\t\t\ttxt += \"</table>\";\n" +
                        "\t\t\t\t\tdocument.getElementById(\"output\").innerHTML = txt;\n" +
                        "\t\t\t\t}\n" +
                        "\n" +
                        "\t\t\t\tfunction sendReqt(url) {\n" +
                        "\t\t\t\t\tlet xhttp = new XMLHttpRequest();\n" +
                        "\t\t\t\t\txhttp.onload = function () {\n" +
                        "\t\t\t\t\t\tlet result = this.responseText;\n" +
                        "\t\t\t\t\t\tshow(result);\n" +
                        "\t\t\t\t\t};\n" +
                        "\t\t\t\t\txhttp.open(\"GET\", url);\n" +
                        "\t\t\t\t\txhttp.send();\n" +
                        "\t\t\t\t}\n" +
                        "\t\t\t</script>";
    }
    
    
    
    public static String questionsSnippet(String sessionId) {
        return
                "<style>\n" +
                        "\t\t\ttextarea {\n" +
                        "\t\t\t\twidth: 400px;\n" +
                        "\t\t\t\tcolor: lightgreen;\n" +
                        "\t\t\t\theight: 400px;\n" +
                        "\t\t\t\tpadding: 12px 20px;\n" +
                        "\t\t\t\tbox-sizing: border-box;\n" +
                        "\t\t\t\tborder: 2px solid #ccc;\n" +
                        "\t\t\t\tborder-radius: 4px;\n" +
                        "\t\t\t\tbackground-color: black;\n" +
                        "\t\t\t\tfont-size: 14px;\n" +
                        "\t\t\t\tresize: none;\n" +
                        "\t\t\t}\n" +
                        "\t\t</style>\n" +
                        "\t\t<textarea id=\"output\"></textarea>\n" +
                        "\t\t<br />\n" +
                        "\t\t<script>\n" +
                        "\t\t\twindow.onload = function () {\n" +
                        "\t\t\t\tdemo();\n" +
                        "\t\t\t};\n" +
                        "\n" +
                        "\t\t\tlet counter = 0;\n" +
                        "\n" +
                        "\t\t\tasync function demo() {\n" +
                        "\t\t\t\twhile (true) {\n" +
                        "\t\t\t\t\tslideToOutput(\"WELCOME TO\");\n" +
                        "\t\t\t\t\tawait pause(2000);\n" +
                        "\t\t\t\t\tslideToOutput(\"QUESTION API DEMO\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tslideToOutput(\"Let add several questions\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/add?question=QT1&answer=QA1\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/add?question=QT2&answer=QA2\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/add?question=QT3&answer=QA3\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/add?question=QT4&answer=QA4\");\n" +
                        "\t\t\t\t\tawait pause(5000);\n" +
                        "\n" +
                        "\t\t\t\t\tslideToOutput(\"Let get all added questions\");\n" +
                        "\t\t\t\t\tawait pause(5000);\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java\");\n" +
                        "\t\t\t\t\tawait pause(8000);\n" +
                        "\n" +
                        "\t\t\t\t\tslideToOutput(\"Let get two random questions\");\n" +
                        "\t\t\t\t\tawait pause(5000);\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/get/2\");\n" +
                        "\t\t\t\t\tawait pause(8000);\n" +
                        "\n" +
                        "\t\t\t\t\tslideToOutput(\"If we will try get more questions than we added we will get exception\");\n" +
                        "\t\t\t\t\tawait pause(5000);\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/get/5\");\n" +
                        "\t\t\t\t\tawait pause(10000);\n" +
                        "\n" +
                        "\t\t\t\t\tslideToOutput(\"Let remove first added question\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/remove?question=QT1&answer=QA1\");\n" +
                        "\t\t\t\t\tawait pause(8000);\n" +
                        "\n" +
                        "\t\t\t\t\tslideToOutput(\"If we will try to delete it again we will get exception\");\n" +
                        "\t\t\t\t\tawait pause(4000);\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/remove?question=QT1&answer=QA1\");\n" +
                        "\t\t\t\t\tawait pause(10000);\n" +
                        "\n" +
                        "\t\t\t\t\tslideToOutput(\"Let remove remaining added questions\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/remove?question=QT2&answer=QA2\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/remove?question=QT3&answer=QA3\");\n" +
                        "\t\t\t\t\tawait pause(3000);\n" +
                        "\t\t\t\t\tsendReqt(\"/exam/java/remove?question=QT4&answer=QA4\");\n" +
                        "\t\t\t\t\tawait pause(10000);\n" +
                        "\n" +
                        "\t\t\t\t\tclearOutput();\n" +
                        "\t\t\t\t\tawait pause(1000);\n" +
                        "\t\t\t\t}\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\tfunction pause(ms) {\n" +
                        "\t\t\t\treturn new Promise(resolve => setTimeout(resolve, ms));\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\tfunction reportToOutput(strOut) {\n" +
                        "\t\t\t\tlet DT = new Date();\n" +
                        "\t\t\t\tDT = DT.toLocaleDateString().slice(0, 15) + \" \" + DT.toLocaleTimeString().slice(0, 8);\n" +
                        "\t\t\t\tdocument.getElementById(\"output\").innerHTML =\n" +
                        "\t\t\t\t\t\"[\" +\n" +
                        "\t\t\t\t\tDT +\n" +
                        "\t\t\t\t\t\"]\\n\\n\" +\n" +
                        "\t\t\t\t\tstrOut +\n" +
                        "\t\t\t\t\t\"\\n------------------------------------\" +\n" +
                        "\t\t\t\t\t\"\\n\" +\n" +
                        "\t\t\t\t\tdocument.getElementById(\"output\").innerHTML;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\tfunction sendReqt(url) {\n" +
                        "\t\t\t\tlet xhttp = new XMLHttpRequest();\n" +
                        "\t\t\t\txhttp.onload = function () {\n" +
                        "\t\t\t\t\tlet result =\n" +
                        "\t\t\t\t\t\t\"Request \\n   GET \" + url + \"\\n\\nResponse \\n   code: \" + this.status + \"\\n   body: \" + this.responseText;\n" +
                        "\t\t\t\t\treportToOutput(result);\n" +
                        "\t\t\t\t};\n" +
                        "\t\t\t\txhttp.open(\"GET\", url);\n" +
                        "\t\t\t\txhttp.send();\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\tfunction clearOutput() {\n" +
                        "\t\t\t\tdocument.getElementById(\"output\").innerHTML = null;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\tasync function slideToOutput(textOut) {\n" +
                        "\t\t\t\tclearOutput();\n" +
                        "\t\t\t\tdocument.getElementById(\"output\").innerHTML = \"\\n\\n\\n       \" + textOut;\n" +
                        "\t\t\t}\n" +
                        "\t\t</script>";
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
    
    public static String commentPrep(String text, Integer size) {
        String result = null;
        if (size == null) {
            size = 4;
        }
        result = "<i><font face=\"'Montserrat', sans-serif\" size=\"" +
                size +
                "\">" +
                text + "</font></i>";
        return result;
    }
    
    public static String textFieldPrep(String text) {
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
        return "<html><head>" +
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />" +
                "<style type=\"text/css\"> " +
                "" +
                "" +
                "" +
                "" +
                "A { text-decoration: none; " +
                "color: " + textcolor +
                "; background: " + bgcolor +
                ";} " +
                "A:hover { text-decoration: none; " +
                "color: black" + //bgcolor +
                "; background: " + textcolor +
                "; } </style>" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap\" rel=\"stylesheet\" />" +
                "<link rel=\"icon\" type=\"image/jpeg\" href=\"/school/student/2/avatar/preview\" />" +
                "</head>" + //+ "<body " +
                "<body link=" + textcolor +
                "vlink=" + textcolor +
                "bgcolor=" + bgcolor +
                "text=" + textcolor +
                ">" +
                "<h2>" +
                "<a href=\"/exit?pass=\">❌</a> | " +
                "<a href=\"/.\">\uD83C\uDFE0</a> | " +
                "<a href=\"javascript:history.back()\">◀️</a> | " +
                "<a href=\"/switchtheme\">" +
                caption +
                "</a>" +
                "</h2>" +
                hrefPrep("/swagger-ui.html",
                        "SWAGGER-UI") + " | " +
                hrefPrep("/openapi.json",
                        "OPENAPI JSON") +
                "<hr>" +
                unformattedString +
                "<hr>" +
                "</body></html>";
    }
    
}
