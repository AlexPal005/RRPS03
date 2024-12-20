package Patterns.Middleware;

public class AuthenticationMiddleware extends Middleware {
    @Override
    public boolean check(String email, String password) {
        if (!"user@example.com".equals(email) || !"password123".equals(password)) {
            System.out.println("Authentication failed: Invalid email or password.");
            return false;
        }
        System.out.println("Authentication successful.");
        return checkNext(email, password);
    }
}