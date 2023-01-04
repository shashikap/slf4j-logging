package com.parrotanalytics.logging;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ServiceLoader;

public final class LoggerFactory implements Serializable {

    private LoggerFactory() {
    }

    public static Logger getLogger(String actor) {
        LogFacadeFactory facadeFactory = (LogFacadeFactory) load(LogFacadeFactory.class);
        LogFacade logFacade = facadeFactory.create(actor);
        return new Logger(actor, logFacade);
    }

    public static Logger getLogger(Class<?> classz) {
        return getLogger(classz.getName());
    }

    static <T> T load(Class<T> clz) {
        Iterator<T> iter = ServiceLoader.load(clz).iterator();
        if (iter.hasNext()) {
            return iter.next();
        } else {
            throw new RuntimeException((String.format("no backing logger implementation found for %s", clz.getName())));
        }
    }
}
