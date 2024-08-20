public class Logger {
   
    private static Logger instance;

   
    private Logger() {
        
    }

    
    public static synchronized Logger getInstance() {
        // Create the instance if it doesn't exist
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

   
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
