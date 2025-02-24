package ChainOfResponsibility;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLoggerProcessor;

    LogProcessor(LogProcessor nextLoggerProcessor){
        this.nextLoggerProcessor = nextLoggerProcessor;
    }

    public void log(int logLevel, String msg){
        if(nextLoggerProcessor != null){
            nextLoggerProcessor.log(logLevel, msg);
        }
    }
}
