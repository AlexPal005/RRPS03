package Patterns.Middleware;

public class LoggingMiddleware extends Middleware {
    @Override
    public boolean check(String email, String password) {
        System.out.println("Log: User " + email + " attempted to log in.");
        return checkNext(email, password);
    }
}
