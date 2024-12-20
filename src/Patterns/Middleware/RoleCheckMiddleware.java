package Patterns.Middleware;

public class RoleCheckMiddleware extends Middleware {
    @Override
    public boolean check(String email, String password) {
        if ("admin@example.com".equals(email)) {
            System.out.println("Role check passed: Admin access granted.");
        } else {
            System.out.println("Role check passed: User access granted.");
        }
        return checkNext(email, password);
    }
}