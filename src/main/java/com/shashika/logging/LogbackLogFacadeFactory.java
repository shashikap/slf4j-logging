package com.shashika.logging;

import org.slf4j.LoggerFactory;

public class LogbackLogFacadeFactory implements LogFacadeFactory{
    @Override
    public LogFacade create(String name) {
        return new LogBackLogFacade(LoggerFactory.getLogger(name));
    }
}
