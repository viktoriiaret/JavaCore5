package hw6hw6;

public class App {
    public static void main(String[] args) {

        sum(10, 25);


        int xx = sum2(25, 35);
        System.out.println(xx);


        int number = 4;
        System.out.println(isEven(4));

    }

    //    #1
    public static void sum(int a, int b) {
        System.out.println(a + b);
    }

    //    #2
    public static int sum2(int a, int b) {
        int result = a + b;
        return result;
    }

    //    #3
    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

////1. Создайте метод sum - который в качестве аргумента берет 2 целых числа и печатает их результат на экране.
//        вызовите этот метод из функции main() (подсказка - тип функции будет void)
//        2. Создайте метод sum - который в качестве аргумента берет 2 целых числа и возвращает их сумму.
//        вызовите этот метод внутри функии main(), сохраните результат в переменной и выведите результат на экран (подсказка - тип функции будет int)
//        3. Создайте метод isEven - который в качестве аргумента берет целое число и если оно четное возвращает true
//        если нечетное - возвращает false
//        вызовите этот метод внутри функии main(), сохраните результат в переменной и выведите результат на экран
