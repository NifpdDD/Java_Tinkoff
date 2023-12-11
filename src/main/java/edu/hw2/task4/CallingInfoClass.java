package edu.hw2.task4;

public class CallingInfoClass {
    private CallingInfoClass() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return new CallingInfo(stackTrace[1].getClassName(), stackTrace[1].getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
