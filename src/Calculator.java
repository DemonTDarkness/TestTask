import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        int a,b;
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] arguments;
        arguments = expression.split(" ");
        if (arguments.length != 3){
            throw new IllegalArgumentException();
        }

        try {
             RimNum arg1 = RimNum.valueOf(arguments[0]);
             RimNum arg2 = RimNum.valueOf(arguments[2]);
             RimNumAri(arg1, arg2, arguments[1]);
        }catch (IllegalArgumentException e){
            boolean bool = true;
            a = Integer.parseInt(arguments[0]);
            b = Integer.parseInt(arguments[2]);

            if (!(a >= 1 && a <=10) || !(b >= 1 && b <=10)){
                throw new IOException();
            }

            Operation(a, b, arguments[1], bool);
        }
    }
    static void ArityPlus(int a, int b, boolean bool) throws Exception {
        int res = a + b;
        if (bool){
            System.out.println(res);
        } else {
            PrintRim(res);
        }
    }
    static void ArityMinus(int a, int b, boolean bool) throws Exception {
        int res = a - b;
        if (bool){
            System.out.println(res);
        } else {
            PrintRim(res);
        }

    }
    static void ArityMulti(int a, int b, boolean bool) throws Exception {
        int res = a * b;
        if (bool){
            System.out.println(res);
        } else {
            PrintRim(res);
        }
    }
    static void ArityDiv(int a, int b, boolean bool) throws Exception {
        int res = a / b;
        if (bool){
            System.out.println(res);
        } else {
            PrintRim(res);
        }
    }

    static void RimNumAri(RimNum arg1, RimNum arg2, String arg3) throws Exception {
        int a,b;
        a = arg1.getNum();
        b = arg2.getNum();
        boolean bool = false;
        Operation(a, b, arg3, bool);
    }

    static  void Operation(int a, int b, String c, boolean bool) throws Exception {
        switch (c) {
            case "+" -> ArityPlus(a, b, bool);
            case "-" -> ArityMinus(a, b, bool);
            case "*" -> ArityMulti(a, b, bool);
            case "/" -> ArityDiv(a, b, bool);
            default -> throw new IOException();
        }
    }

    static void PrintRim(int res) throws Exception {
        RimNum[] rim = RimNum.values();
        String resR = "";
        if (res > 0){
            for (RimNum i:rim){
                if (res >= i.getNum()){
                    resR += i.toString();
                    res -= i.getNum();
                }
            }
            System.out.println(resR);
        } else {
            throw new Exception();
        }
    }
}
