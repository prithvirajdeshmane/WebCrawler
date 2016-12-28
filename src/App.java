
public class App {
	public static void main(String[] args) {
		WebCrawler webCrawler = new WebCrawler();
		
		String rootURL = "http://www.bbc.com";
		
		webCrawler.discoveredWeb(rootURL);
	}
}
