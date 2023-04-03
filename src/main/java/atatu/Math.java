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

    public static long division(long a, long b) throws DivideByZeroException {
        if(b == 0)
            throw new DivideByZeroException("Divide by zero Exception");
        return a / b;
    }
    
    
}