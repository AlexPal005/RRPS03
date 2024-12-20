package Patterns.Singleton;

public class Singleton {
    private static Singleton instance;
    public final String text;

    private Singleton(String text) {
        this.text = text;
    }
    public static Singleton getInstance(String text) {
        if(instance == null){
            instance = new Singleton(text);
        }
        return instance;
    }

}
