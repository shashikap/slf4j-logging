package com.parrotanalytics.logging;

import java.util.Map;

public interface LogFacade {

    void debug(Map<String, Object> var1);

    void info(Map<String, Object> var1);

    void warn(Map<String, Object> var1);

    void error(Map<String, Object> var1);

    boolean isDebugEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    boolean isErrorEnabled();
}
