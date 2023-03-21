package atatu;

public class Math {
    public static long addition(long a, long b) {
        return a + b;
    }

    public static long substraction(long a, long b) {
        return a - b;
    }

    public static long multiplication(long a, long b) {
        return a * b;
    }

    public static long devision(long a, long b) throws DevideByZeroException{
        if(b == 0)
            throw new DevideByZeroException("Devide by zero excpetion!");
        return a / b;
    }
}