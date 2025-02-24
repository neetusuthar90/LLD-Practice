package ChainOfResponsibility;

public class Main {
    public static void main(String[] args){
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor
                    (new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.ERROR, "Exception Handle");
        logProcessor.log(LogProcessor.DEBUG, "need to debug this");
        logProcessor.log(LogProcessor.INFO, "Just for info");
    }
}
