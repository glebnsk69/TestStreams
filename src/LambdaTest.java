public class LambdaTest {
    public static void main(String[] args) {
        System.out.println("Test lambda");
        Operationsble oper;
        int a=-10;
        int b = 2;
        int c=30;

        oper = (x,y) -> a+x-b-y;

        System.out.println(oper.calc(10,12));


    }
    @FunctionalInterface
    interface Operationsble {
        int calc(int x,int y);
    }

}
