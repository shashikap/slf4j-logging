package com.parrotanalytics.logging;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Log {

    public Log() {

    }

    static Log.Builder newBuilder(LogFacade logFacade) {
        return new Log.Builder(logFacade);
    }

    public static class Builder implements Serializable {
        private final Map<String, Object> attributes;
        private final LogFacade logFacade;

        private Builder(LogFacade facade) {
            this.attributes = new LinkedHashMap<>();
            this.logFacade = facade;
        }

        public Log.Builder withTask(String loggerName, String task) {
            this.attributes.put("task", task);
            this.attributes.put("event_source", task);
            return this;
        }


        public Log.Builder withMessage(String value) {
            this.attributes.put("message", value);
            return this;
        }

        public Log.Builder withAttribute(String name, String value) {
            this.attributes.put(name, value);
            return this;
        }

        public Log.Builder withAttribute(String name, Integer value) {
            this.attributes.put(name, value);
            return this;
        }

        public Log.Builder withAttribute(String name, Long value) {
            this.attributes.put(name, value);
            return this;
        }

        public Log.Builder withAttribute(String name, Float value) {
            this.attributes.put(name, value);
            return this;
        }

        public Log.Builder withAttribute(String name, Boolean value) {
            this.attributes.put(name, value);
            return this;
        }

        public void info(){
            this.logFacade.info(this.build());

        }

        public void warn(){
            this.logFacade.warn(this.build());

        }

        public void error(){
            this.logFacade.error(this.build());

        }

        public void debug(){
            this.logFacade.debug(this.build());

        }
        // build method can be used to mask any sensitive information
        Map<String, Object> build(){
            return new HashMap<>(this.attributes);
        }
    }
}
