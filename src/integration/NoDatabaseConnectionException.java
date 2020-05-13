package integration;
/**
 * Thrown when using getItem() method in the InventorySystem class when
 */

public class NoDatabaseConnectionException extends RuntimeException{

/**
  *  Creates a new instance representing the condition described in the specified message.
  *  @param msg A message that describes what went wrong.
  */

  public NoDatabaseConnectionException(String msg) {
    super(msg);
  }

/**
  * Creates a new instance with the specified message and root cause.
  * @param msg   The exception message.
  * @param cause The exception that caused this exception.
  */

  public NoDatabaseConnectionException(String msg, Exception cause) {
    super(msg, cause);
  }
}
