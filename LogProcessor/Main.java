package LogProcessor;

import LogProcessor.Processors.*;;

public class Main {
    public static void main(String[] args) {
        LogProcessor logger = new InfoLogProcessor(
                new DebugLogProcessor(
                        new ErrorLogProcessor(null)
                )
        );

        logger.log(LogProcessor.DEBUG, "This is a debug message.");
        logger.log(LogProcessor.ERROR, "This is an error message.");
        logger.log(LogProcessor.INFO, "This is an info message.");
    }
}
