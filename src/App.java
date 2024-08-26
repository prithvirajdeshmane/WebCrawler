import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Main application class that initiates the web crawler
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url;

        while (true) {
            // Prompt the user to enter a URL
            System.out.print("Enter URL to start crawling from: ");
            url = scanner.nextLine();

            // Validate the URL
            if (isValidURL(url)) {
                break;
            } else {
                System.out.println("Invalid URL. Please enter a valid URL.");
            }
        }
        
        // Close the scanner
        scanner.close();

        // Start the web crawler
        BFS_WebCrawler webCrawler = new BFS_WebCrawler();
        webCrawler.discoverWeb(url);
    }

    // Method to validate the URL format
    private static boolean isValidURL(String url) {
        try {
            new URL(url);
            return true;  // URL is valid
        } catch (MalformedURLException e) {
            return false; // URL is invalid
        }
    }
}
