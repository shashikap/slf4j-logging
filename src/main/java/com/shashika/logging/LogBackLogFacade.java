package com.shashika.logging;

import net.logstash.logback.marker.LogstashMarker;
import net.logstash.logback.marker.Markers;
import org.slf4j.Logger;

import java.util.Map;
import java.util.stream.Collectors;

public class LogBackLogFacade implements LogFacade {

    private final Logger backingLogger;

    LogBackLogFacade(Logger backingLogger) {
        this.backingLogger = backingLogger;
    }

    private LogstashMarker createMarker(Map<String, Object> ctx) {
        return Markers.appendEntries((Map) ctx
                .entrySet()
                .stream()
                .filter((kv) -> !((String) kv.getKey()).equals("message") && !((String) kv.getKey()).equals("stack_trace"))
                .collect(Collectors.toMap((km) -> (String) km.getKey(), (vm) -> vm.getValue())));
    }

    @Override
    public void debug(Map<String, Object> context) {
        this.backingLogger.debug(this.createMarker(context), String.valueOf(context.getOrDefault("message", "")));
    }

    @Override
    public void info(Map<String, Object> context) {
        this.backingLogger.info(this.createMarker(context), String.valueOf(context.getOrDefault("message", "")));
    }

    @Override
    public void warn(Map<String, Object> context) {
        this.backingLogger.warn(this.createMarker(context), String.valueOf(context.getOrDefault("message", "")));
    }

    @Override
    public void error(Map<String, Object> context) {
        this.backingLogger.error(this.createMarker(context), String.valueOf(context.getOrDefault("message", "")));
    }

    @Override
    public boolean isDebugEnabled() {
        return this.backingLogger.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return this.backingLogger.isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return this.backingLogger.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return this.backingLogger.isErrorEnabled();
    }
}
