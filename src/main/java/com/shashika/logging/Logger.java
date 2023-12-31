package com.shashika.logging;

import java.io.Serializable;

public final class Logger implements Serializable {
    private final String actor;
    private final LogFacade logFacade;

    Logger(String actor, LogFacade logFacade) {
        this.actor = actor;
        this.logFacade = logFacade;
    }

    public Log.Builder withTask(String task) {
        return Log.newBuilder(this.logFacade).withTask(this.actor, task);
    }

    public boolean isDebugEnabled() {
        return this.logFacade.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return this.logFacade.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return this.logFacade.isWarnEnabled();
    }

    public boolean isErrorEnabled() {
        return this.logFacade.isErrorEnabled();
    }
}
