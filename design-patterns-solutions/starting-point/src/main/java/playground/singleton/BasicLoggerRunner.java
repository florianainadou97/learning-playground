package playground.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.time.LocalDateTime;

public class BasicLoggerRunner {
    public static void main(String[] args) throws IOException {
//        try {
//            // Initialize the logger with the file name "app.log"
//            BasicLogger logger = new BasicLogger("app.log");
//
//            // Log a few messages
//            logger.log("Starting the application. 2");
//            logger.log("Performing some operations... 2");
//            logger.log("An example warning message. 2");
//            logger.log("Shutting down the application. 2");
//
//            System.out.println("Logging completed. Check the app.log file.");
//        } catch (IOException e) {
//            System.err.println("An error occurred while initializing the logger: " + e.getMessage());
//            e.printStackTrace();
//        }

        // Using the SingletonLogger
      SingletonFileLogger singletonLogger = SingletonFileLogger.getInstance("app.log");
        singletonLogger.log("This is a singleton logger message.");

        // Another call to SingletonLogger, no need to specify the file name
      SingletonFileLogger anotherInstance = SingletonFileLogger.getInstance("ignoredFileName");
        anotherInstance.log("Another message via singleton logger.");
    }
}


class BasicLogger {
    private PrintWriter writer;

    public BasicLogger(String fileName) throws IOException {
        // Open the given file in append mode.
        writer = new PrintWriter(new FileWriter(fileName, true));
    }

    public void log(String message) {
        // Decorate and write the message
        String decoratedMessage = decorate(message);
        writer.println(decoratedMessage);
        writer.flush(); // Ensure the message is written immediately
    }

    private String decorate(String message) {
        try {
            // Decorate the message with the computer name, current time, and the original message
            String computerName = InetAddress.getLocalHost().getHostName();
            LocalDateTime now = LocalDateTime.now();
            return String.format("[%s] [%s] %s", computerName, now, message);
        } catch (IOException e) {
            // Fallback if hostname can't be resolved
            LocalDateTime now = LocalDateTime.now();
            return String.format("[Unknown Host] [%s] %s", now, message);
        }
    }
}

class SingletonLogger {
  private static SingletonLogger instance;
  private final PrintWriter writer;
  private final LogDecorator decorator;

  private SingletonLogger(String fileName, LogDecorator decorator) throws IOException {
    writer = new PrintWriter(new FileWriter(fileName, true));
    this.decorator = decorator;
  }

  public static synchronized SingletonLogger getInstance(String fileName, LogDecorator decorator) throws IOException {
    if (instance == null) {
      instance = new SingletonLogger(fileName, decorator);
    }
    return instance;
  }

  public void log(String message) {
    // Decorate and write the message
    String decoratedMessage = decorator.decorate(message);
    writer.println(decoratedMessage);
    writer.flush(); // Ensure the message is written immediately
  }
}

interface LogDecorator {
  String decorate(String message);
}

class BasicLogDecorator implements LogDecorator {
  @Override
  public String decorate(String message) {
    try {
      // Decorate the message with the computer name, current time, and the original message
      String computerName = InetAddress.getLocalHost().getHostName();
      LocalDateTime now = LocalDateTime.now();
      return String.format("[%s] [%s] %s", computerName, now, message);
    } catch (IOException e) {
      // Fallback if hostname can't be resolved
      LocalDateTime now = LocalDateTime.now();
      return String.format("[Unknown Host] [%s] %s", now, message);
    }
  }
}

abstract class AbstractSingletonLogger {
  protected PrintWriter writer;

  public void log(String message) {
    // Decorate and write the message
    String decoratedMessage = decorate(message);
    writer.println(decoratedMessage);
    writer.flush(); // Ensure the message is written immediately
  }

  protected String decorate(String message){
    try {
      // Decorate the message with the computer name, current time, and the original message
      String computerName = InetAddress.getLocalHost().getHostName();
      LocalDateTime now = LocalDateTime.now();
      return String.format("[%s] [%s] %s", computerName, now, message);
    } catch (IOException e) {
      // Fallback if hostname can't be resolved
      LocalDateTime now = LocalDateTime.now();
      return String.format("[Unknown Host] [%s] %s", now, message);
    }
  }
}

class SingletonFileLogger extends AbstractSingletonLogger {
  private static SingletonFileLogger instance;

  private SingletonFileLogger(String fileName) throws IOException {
    writer = new PrintWriter(new FileWriter(fileName, true));
  }

  public static synchronized SingletonFileLogger getInstance(String fileName) throws IOException {
    if (instance == null) {
      instance = new SingletonFileLogger(fileName);
    }
    return instance;
  }
}

