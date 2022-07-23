package course02.topic01.hw;
/*
Задание 5
Будет распечатано 33 - исходное значение переменной value примитивного типа int с обл. видимости внутри метода main(),
т.к. в метод changeValue(int value) будет передано значение 33 и присвоено переменной метода value,
изменено в этой переменной на 22, но не возвращено в метод main().

Задание 6
Так же как и в 5 задании будет распечатано исходное значение переменной 33 объектного типа Integer, т.к.
в метод changeValue(int value) будет передано значение ссылки на объект со значением 33, однако при выполнении
присваивания переменной метода нового значения 22 будет создан новый объект, соответственно исходное значение объекта,
ссылка которого передавалась не изменится, а ссылка на новый объект не будет возвращена методом.

Задание 7
Как и в 6 задании в переменную параметра метода changeValue сначала передается ссылка на массив value {3,4} метода main,
которой затем в методе changeValue присваивается ссылка на вновь созданный массив {1,2} и из метода не возвращается.
Массив метода main value {3,4} остается неизменным.
Ответ: если распечатать массив в методе main, то будут выведены значения 3,4

Задание 8
{3,99} т.к.по ссылке переданной в параметр метод изменит значение первой ячейки (не нулевой) исходного массива,
в отличие от примера из задания 7 новый массив методом создаваться не будет.

Задание 9
Lyapis Trubetskoy, т.к. новый объект останется в методе changePerson, а ссылка на него в параметре метода changePerson,
в исходный объект класса person Ilya Lagutenko метода main изменения внесены не будут.

Задание 10
Ilya Lagutenko, т.к. методом changePerson будут внесены изменения в объект класса person метода main по переданной
в метод changePerson через параметр ссылке.
*/

public class Hw01 {
    public static void changeValueInt(int value) {
        value = 22;
    }

    public static void changeValueInteger(Integer value) {
         value = 22;
    }

    public static void changeValueIntegerArr(Integer[] value) {
        Integer[] valueNew = {1,2};
        value = valueNew;
    }

    public static void main() {
        int valueInt = 33;
        Integer valueInteger = 33;
        changeValueInt(valueInt);
        changeValueInteger(valueInteger);
        System.out.println("value = " + valueInt);
        System.out.println("value2 = " + valueInteger);

        Integer[] valueArr = {3,4};
        for (int i = 0; i < valueArr.length; i++) {
            System.out.println("valueArr = " + valueArr[i]);
        }
        changeValueIntegerArr(valueArr);
        for (int i = 0; i < valueArr.length; i++) {
            System.out.println("valueArr = " + valueArr[i]);
        }
    }

}
