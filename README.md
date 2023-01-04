# README #

This library provide the structured logging mechanism for java apps

### Features of this logging library ###
* You have the flexibility to implement your own log masking(example if someone is adding password, secrets in the logs the Log.java build method can be used to implement the masking pattern)
* More efficient SRE dashboard can be build, derived from the attributes values we are passing
* More readable log lines
* Fast and easy log search for developers using ELK(using attributes values)

### Sample usage of logging library ###
* withTask - will provide a way to categorize your logging activities
* withAttribute - you can have many attributes as you go, good way to log your metadata
* withMessage - message about the log that you are printing
* <LogLevel> - This will tell you what log level you are using.

### How to write logs with new log library ###

* Info logs
```java
        // import the library
        import com.parrotanalytics.logging.Logger;
        import com.parrotanalytics.logging.LoggerFactory;
        
        //create the Logger
        private static final Logger LOGGER = LoggerFactory.getLogger(BittorrentRawDataProcessor.class);
        
        LOGGER.withTask("Bit-Torrent-Raw-Data-Processor")
                .withAttribute("time-started", stopWatch.getStartTime())
                .withAttribute("started-value", "initial")
                .withMessage("Application started to process data")
                .info();
```
* Error logs
```java
        // import the library
        import com.parrotanalytics.logging.Logger;
        import com.parrotanalytics.logging.LoggerFactory;
        
        //create the Logger
        private static final Logger LOGGER = LoggerFactory.getLogger(BittorrentRawDataProcessor.class);

        LOGGER.withTask("Bit-Torrent-Raw-Data-Processor")
                .withAttribute("time-started", stopWatch.getStartTime())
                .withAttribute("started-value", "initial")
                .withMessage("Error encountered while processing application")
                .error();
```

* Debug logs
```java
        // import the library
        import com.parrotanalytics.logging.Logger;
        import com.parrotanalytics.logging.LoggerFactory;
        
        //create the Logger
        private static final Logger LOGGER = LoggerFactory.getLogger(BittorrentRawDataProcessor.class);

        LOGGER.withTask("Bit-Torrent-Raw-Data-Processor")
                .withAttribute("time-started", stopWatch.getStartTime())
                .withAttribute("started-value", "initial")
                .withMessage("This is a debug log")
                .debug();
```

* Warning logs
```java
        // import the library
        import com.parrotanalytics.logging.Logger;
        import com.parrotanalytics.logging.LoggerFactory;
        
        //create the Logger
        private static final Logger LOGGER = LoggerFactory.getLogger(BittorrentRawDataProcessor.class);

        LOGGER.withTask("Bit-Torrent-Raw-Data-Processor")
                .withAttribute("time-started", stopWatch.getStartTime())
                .withAttribute("started-value", "initial")
                .withMessage("This is a warning log")
                .warn();
```
### Sample log message output ###

```json
{
  "time":"2023-01-04T13:17:36.310+1300",
  "level":"INFO",                                                     // log level passed with logger
  "level_value":40000,
  "thread":"main",
  "logger":"com.parrotanalytics.component.BittorrentRawDataProcessor",
  "context":"default",
  "message":"Application started to process data",                    // message passed withMessage method
  "time-started":1672791456308,                                       // attribute passed withAttribute method
  "started-value":"initial",                                          // attribute passed withAttribute method
  "task":"Bit-Torrent-Raw-Data-Processor",                            // task passed withTask method
  "event_source":"Bit-Torrent-Raw-Data-Processor"
}
```
### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines