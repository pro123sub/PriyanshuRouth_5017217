public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a Word document.");
    }
}
 class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}
 class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening an Excel document.");
    }
}
 abstract class DocumentFactory {
    public abstract Document createDocument();
}
