package Patterns.FactoryMethod;

public abstract class Document {
    public abstract void print();
}
class TextDocument extends Document {
    @Override
    public void print() {
        System.out.println("Printing a text document.");
    }
}

class PDFDocument extends Document {
    @Override
    public void print() {
        System.out.println("Printing a PDF document.");
    }
}

