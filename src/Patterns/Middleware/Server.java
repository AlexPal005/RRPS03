package Patterns.Middleware;

public class Server {
    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public void logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization has been successfully completed!");
        } else {
            System.out.println("Authorization failed.");
        }
    }
}
