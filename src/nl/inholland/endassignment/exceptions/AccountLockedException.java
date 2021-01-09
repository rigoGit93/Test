package nl.inholland.endassignment.exceptions;

public class AccountLockedException extends NullPointerException {
    public AccountLockedException(String errorMessage){
        super(errorMessage);
    }
}
