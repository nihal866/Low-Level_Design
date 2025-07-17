package LogProcessor.Processors;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int ERROR = 3;
    public static int DEBUG = 2;

    LogProcessor nextProcessor;

    LogProcessor(LogProcessor logProcessor) {
        this.nextProcessor = logProcessor;
    }

    public void log(int logLevel, String message){
        if(nextProcessor != null){
            nextProcessor.log(logLevel, message);
        }
    }
}
