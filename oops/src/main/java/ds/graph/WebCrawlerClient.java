package ds.graph;

import java.io.IOException;

public class WebCrawlerClient {

    public static void main(String args[]) throws IOException {

        String url ="https://github.com/amberdas";
        WebCrawler webCrawler = new WebCrawler(url);
        webCrawler.crawl();
    }
}
