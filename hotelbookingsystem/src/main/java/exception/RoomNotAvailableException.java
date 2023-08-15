package exception;

public class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException() {
        super("Sorry no room available");
    }
}
