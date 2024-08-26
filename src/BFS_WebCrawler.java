import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Class that implements a Breadth-First Search (BFS) based web crawler
public class BFS_WebCrawler {
    
    // Queue to manage the list of URLs to be explored
	private Queue<String> queue;
    
    // List to keep track of already discovered web sites
	private HashSet<String> discoveredWebsitesSet;
	
    // Constructor that initializes the queue and discovered web sites list
	public BFS_WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebsitesSet = new HashSet<>();
	}
	
    // Method that starts the web crawling process from the given root URL
	public void discoverWeb(String root) {
		
        // Add the root URL to the queue and discovered list
		this.queue.add(root);
		this.discoveredWebsitesSet.add(root);
		
        // Continue exploring until there are no more URLs in the queue
		while(!queue.isEmpty()) {
			
            // Remove the next URL from the queue
			String webAddress = this.queue.remove();
            
            // Fetch the HTML content of the current URL
			String rawHtml = readURL(webAddress);
			
            // Regular expression to find valid URLs in the HTML content
			String regex = "(https?://[\\w-]+(\\.[\\w-]+)+(/[\\w-./?%&=]*)?)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHtml);
			
            // Iterate through all found URLs
			while(matcher.find()) {
				String websiteFound = matcher.group();
				
                // If the URL has not been discovered yet, add it to the queue and discovered list
				if(!discoveredWebsitesSet.contains(websiteFound)) {
					discoveredWebsitesSet.add(websiteFound);
					System.out.println("New website found: " + websiteFound);
					queue.add(websiteFound);
				}			
			}
		}
	}

    // Method to read the HTML content of a given URL
	private String readURL(String webAddr) {
		
        // StringBuilder to store the fetched HTML content
		StringBuilder rawHtml = new StringBuilder("");
		try {
            // Open a connection to the URL
			URL url = new URL(webAddr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			
            // Read the HTML content line by line
			String line = "";
			
			while((line = reader.readLine()) != null) {
				rawHtml.append(line);						
			}
			
            // Close the reader after use
			reader.close();
		} catch (Exception e) {
			System.out.println("Error while web crawling: " + e.getMessage());;
		}
		
        // Return the fetched HTML content as a string
		return rawHtml.toString();
		
	}

}
