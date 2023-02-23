public class LambdaTest {
    public static void main(String[] args) {
        int a=-10;
        int b = 2;
        int c=30;

        System.out.println("Test lambda");
// заводим переменную типа функциональный интерфейс.
        Operationsble oper;
// согласно декларации интерфейс принимает два целых значения и возврящает одно целое значение
// в следующей строке пишем чего именно делается с полученными числами
        oper = (x,y) -> a+x-b-y;
        System.out.println(oper.calc(10,12));
//при необходимости формулу вычисления можем поменять
        oper = (x,y) -> a*x-b*y+c;
        System.out.println(oper.calc(10,12));

// класс SquareEquation содержит значения коэффициентов, которые задаются через конструктор при создании класса и
// интерфейс solve который по умолчанию является получением значения квадратного техчлена
// согласно декларации интерфейса он получает одно число и возвращает одно число
        SquareEquation squareEquation = new SquareEquation(-2,3,10);
        for (int i = -10; i < 10; i++) {
            System.out.printf("%.1f,\t",squareEquation.solve.calc((double)i));
        }
//точно также как в предыдущем примре формулу для вычисления можно изменить
        System.out.println("\n===================");
        squareEquation.solve = x1 -> squareEquation.a*x1;

        for (int i = -10; i < 10; i++) {
            System.out.printf("%.1f,\t",squareEquation.solve.calc((double)i));
        }
    }
    @FunctionalInterface
    interface Operationsble {
        int calc(int x,int y);
    }

}
