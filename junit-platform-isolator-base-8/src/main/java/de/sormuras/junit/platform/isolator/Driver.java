package de.sormuras.junit.platform.isolator;

public interface Driver {

  /** Log a message formatted in {@link java.text.MessageFormat} style at debug level. */
  void debug(String format, Object... args);

  /** Log a message formatted in {@link java.text.MessageFormat} style at info level. */
  void info(String format, Object... args);

  /** Log a message formatted in {@link java.text.MessageFormat} style at warning level. */
  void warn(String format, Object... args);

  /** Log a message formatted in {@link java.text.MessageFormat} style at error level. */
  void error(String format, Object... args);
}
