import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	
	private Queue<String> queue;
	private List<String> discoveredWebsitesList;
	
	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebsitesList = new ArrayList<>();
	}
	
	public void discoveredWeb(String rootURL) {
		this.queue.add(rootURL);
		this.discoveredWebsitesList.add(rootURL);
		
		while(!queue.isEmpty()) {
			String v = this.queue.remove();
			String rawHTML = readURL(v);
			
			String regexp = "http://(\\w+\\.)*(\\w+)*";
			
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(rawHTML);
			
			while(matcher.find()) {
				String actualURL = matcher.group();
				
				if(!discoveredWebsitesList.contains(actualURL)) {
					discoveredWebsitesList.add(actualURL);
					System.out.println("Website found: " + actualURL);
					queue.add(actualURL);
				}
			}
		}
	}

	private String readURL(String v) {
		
		String rawHTML = "";
		try {
			URL url = new URL(v);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";
			
			while((inputLine = in.readLine()) != null) {
				rawHTML += inputLine;
			}
			
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rawHTML;
	}
	
}
