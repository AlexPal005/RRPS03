import Patterns.Decorator.Coffee;
import Patterns.Decorator.MilkDecorator;
import Patterns.Decorator.SugarDecorator;
import Patterns.FactoryMethod.Document;
import Patterns.FactoryMethod.DocumentFactory;
import Patterns.FactoryMethod.PDFDocumentFactory;
import Patterns.FactoryMethod.TextDocumentFactory;
import Patterns.Middleware.*;
import Patterns.Builder.Product;
import Patterns.Decorator.SimpleCoffee;
import Patterns.Singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        //Singleton
        Singleton singleton = Singleton.getInstance("Hello Alex!");
        Singleton secondSingleton = Singleton.getInstance("Hello Dima!");
        System.out.println(singleton.text);
        System.out.println(secondSingleton.text);
        System.out.println();

        //Builder
        Product product = new Product.Builder()
                .setName("Smartphone")
                .setPrice(699.99)
                .setDescription("Flagship smartphone")
                .setQuantity(15)
                .build();
        System.out.println(product);
        System.out.println();

        //Decorator
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription());
        System.out.println();

        //Chain of Responsibility
        Middleware middleware = new LoggingMiddleware();
        middleware.linkWith(new AuthenticationMiddleware())
                .linkWith(new RoleCheckMiddleware());
        Server server = new Server();
        server.setMiddleware(middleware);
        server.logIn("user@example.com", "password123");  // Успішний вхід
        System.out.println();
        server.logIn("admin@example.com", "password123"); // Невдала автентифікація
        System.out.println();
        server.logIn("user@example.com", "wrongpassword"); // Невірний пароль
        System.out.println();
        //Factory Method
        DocumentFactory textFactory = new TextDocumentFactory();
        Document textDoc = textFactory.createDocument();
        textDoc.print();

        DocumentFactory pdfFactory = new PDFDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.print();
    }
}