# BFS Web Crawler

A simple web crawler implemented in Java using the Breadth-First Search (BFS) algorithm. This program starts crawling from a user-specified URL and discovers all linked websites within the same or across different domains.

## Features

- Prompts the user to input a starting URL for the web crawling process.
- Validates the user's URL input to ensure it's a properly formatted URL.
- Utilizes a BFS approach to explore web pages level by level.
- Extracts and prints discovered URLs in real-time.
- Avoids revisiting already discovered websites by maintaining a set of unique URLs.


## Prerequisites

- **Java 8** or higher
- **Maven** (optional, if you use Maven for building the project)

## Installation

### Step 1: Clone the Repository

```
git clone https://github.com/your-username/bfs-web-crawler.git
cd bfs-web-crawler
```

### Step 2: Compile the Project
Navigate to the project directory and compile the source code:
```
javac src/App.java src/BFS_WebCrawler.java -d out

```

This command compiles the Java files and places the compiled classes in the out directory.

### Step 3: Run the Application
Run the application from the out directory:

```
java -cp out App
```

The program will prompt you to enter a URL to start crawling.

## Usage

1. Enter a URL: When prompted, enter a valid URL (e.g., https://www.bbc.com)
2. View Results: The program will start crawling from the entered URL, discover all linked websites, and print them to the console.

Example
```
Enter URL to start crawling from: https://www.bbc.com
New website found: https://www.bbc.co.uk
New website found: https://www.bbc.com/news
...
```

## How It Works
#### App.java
- **User Input:** The program starts by asking the user to input a URL
- **URL Validation:** The input is validated to ensure it's a well-formed URL using the isValidURL method
- **Starting the Crawler:** Once a valid URL is provided, the BFS_WebCrawler class is instantiated and the crawling process begins from the given URL.

#### BFS_WebCrawler.java
- **Queue and Set:** Uses a Queue to manage URLs to be crawled and a HashSet to track discovered URLs, ensuring each URL is only processed once
- **Crawling Process:** The discoverWeb method begins with the root URL and explores each linked web site by fetching and parsing the HTML content of each URL
- **URL Extraction:** A regular expression is used to find valid URLs within the HTML content, and newly discovered URLs are added to the queue for further exploration

## Optimization & Future Enhancements
- **Parallel Processing:** Consider using multi-threading to fetch multiple URLs simultaneously, reducing the overall crawling time
- **URL Filtering:** Implement domain-specific filtering to crawl only certain types of links (e.g., within the same domain)
- **Depth Limiting:** Introduce a depth limit to control how far the crawler goes from the root URL

## Contributing
Contributions are welcome! Feel free to fork the repository, make improvements, and submit a pull request

## License
This project is licensed under the MIT License - see the LICENSE file for details.
