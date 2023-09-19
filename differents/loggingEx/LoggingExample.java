package differents.loggingEx;

import java.io.IOException;
import java.util.logging.*;

public class LoggingExample {
    private static Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) throws IOException {
        //LogManager.getLogManager().readConfiguration();
        //-Djava.util.logging.config.file=myfile=C:\Users\wwwgl\IdeaProjects\train\differents\loggingEx\log.properties
        //System.out.println(System.getProperty("java.util.logging.config.file"));
        //logger.info("message");
        logger.log(Level.FINER, "fine");
        logger.log(Level.WARNING, "warn", new Throwable("example"));
        logger.log(Level.INFO, "fine");

        //ConsoleHandler consoleHandler = new ConsoleHandler();
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilter(new MyFilter());
        logger.addHandler(fileHandler);
        //StreamHandler streamHandler = new StreamHandler();
        //SocketHandler socketHandler = new SocketHandler();
        //logger.setUseParentHandlers(false);
        logger.info("info message");
        logger.info("info not logged");


    }
    static class MyFilter implements Filter{
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("logged");
        }
    }
    static class Formatter extends java.util.logging.Formatter{
        @Override
        public String format(LogRecord record) {
            return record.getLevel()+": "+record.getMessage();
        }
    }
}
