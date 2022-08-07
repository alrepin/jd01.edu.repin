package topic07.hw;
public class Hw07 {
    static String fullName = "";
    public static String customReplaceAll(String str, String oldStr, String newStr) {

        if ("".equals(str) || "".equals(oldStr) || oldStr.equals(newStr)) {
            return str;
        }
        if (newStr == null) {
            newStr = "";
        }
        final int strLength = str.length();
        final int oldStrLength = oldStr.length();
        StringBuilder builder = new StringBuilder(str);

        for (int i = 0; i < strLength; i++) {
            int index = builder.indexOf(oldStr, i);

            if (index == -1) {
                if (i == 0) {
                    return str;
                }
                return builder.toString();
            }
            builder = builder.replace(index, index + oldStrLength, newStr);

        }
        return builder.toString();
    }
    public static String untransliterate(String inpStr){
        String[] abcCyr =   {" ","щ","ё","ш","ц","ж","ч","а","б","в","г","д","е","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ъ","ы","ь","э", "ю","я","А","Б","В","Г","Д","Е","Ё", "Ж","З","И","Й","К","Л","М","Н","О","П","Р","С","Т","У","Ф","Х", "Ц", "Ч","Ш", "Щ","Ъ","Ы","Ь","Э","Ю","Я","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] abcLat = {" ","sch","yo","sh","ts","zh","ch","a","b","v","g","d","e","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h", "","i", "","e","ju","ja","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        for (int x = 0; x < abcLat.length; x++ ) {
            inpStr = customReplaceAll(inpStr, abcLat[x], abcCyr[x]);
        }
        return inpStr;
    }
    public static void hwCaption() {
        System.out.println("Домашнее задание по уроку \"Строки\"");
    }

    public static void task1() {
        System.out.println("Задача 1");
        /*
Напишите четыре строки:
первая с именем firstName — для хранения имени;
вторая с именем middleName — для хранения отчества;
третья с именем lastName — для хранения фамилии;
четвертая с именем fullName — для хранения Ф. И. О. сотрудника в формате "Фамилия Имя Отчество".
Выведите в консоль фразу: “ФИО сотрудника — ….”
В качестве данных для задачи используйте “Ivanov Semyon Semyonovich”.
        */
        String firstName = "Semyon";
        String middleName = "Semyonovich";
        String lastName = "Ivanov";
        fullName = lastName + ' ' + firstName + ' ' + middleName;
        System.out.println("ФИО сотрудника — " + fullName + '.');
    }
    public static void task2() {
        System.out.println("Задача 2");
        /*
изменить написание Ф. И. О. сотрудника с  “Ivanov Ivan Ivanovich” на полностью заглавные буквы.
В качестве строки с исходными данными используйте строку fullName.
Результат программы выведите в консоль в формате: ”Данные ФИО сотрудника для заполнения отчета — …”
        */
        if (!fullName.isEmpty()) {
            String fullNameRep = fullName.toUpperCase();
            System.out.println("Данные ФИО сотрудника для заполнения отчета — " + fullNameRep + '.');
        } else {
            System.out.println("Данные о сотруднике отсутствуют");
        }
    }
    public static void task3() {
        System.out.println("Задача 3");
        /*
заменить символ “ё” на символ “е”.
В качестве исходных данных используйте строку fullName и данные в ней “Иванов Семён Семёнович”.
Выведите результат программы в консоль в формате: ”Данные ФИО сотрудника — ...”
        */
        //String fullName = "Иванов Семён Семёнович";
        String fullNameCyr = untransliterate(fullName);
        String fullNameCyrFixed = fullNameCyr.replace("ё","е");

        System.out.println("ФИО сотрудника " + fullNameCyr + " с заменой \"ё\" на \"е\" — " + fullNameCyrFixed + '.');
    }
}
