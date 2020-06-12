package ds.graph;

import util.InputStreamUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> webLinks;
    private Set<String> discoveredWebLinks;

    private final int USED_MEMORY_THRESHOLD=80;

    private String root;

    WebCrawler(String root) {
        this.root = root;
        this.webLinks = new LinkedList<>();
        this.discoveredWebLinks = new HashSet<>();
        init();
    }

    private void init(){
        webLinks.offer(root);
        discoveredWebLinks.add(root);
    }

    public void crawl() {
        while (!webLinks.isEmpty()){

            //This can result in out of memory, so putting memory check
            if(!isMemoryUsageExceededThreshold()) {
                String webLink = webLinks.poll();

                System.out.println(webLink);

                String pageContent="";

                try {
                    pageContent = InputStreamUtil.getWebPageContentAsString(webLink);
                } catch (IOException e) {
                    //Eating up Exception, as we just need to list down urls
                }

                Matcher webLinkMatcher = getUrlMatcher(pageContent);

                while (webLinkMatcher.find()) {
                    String url = webLinkMatcher.group();

                    if(!discoveredWebLinks.contains(url)){
                        discoveredWebLinks.add(url);
                        webLinks.offer(url);
                    }
                }
            } else {
                break;
            }

        }
    }

    private Matcher getUrlMatcher(String input){

        String regEx = "http://(\\w+\\.)*(\\w+)";

        Pattern httpPattern = Pattern.compile(regEx);

        return httpPattern.matcher(input);
    }

    public boolean isMemoryUsageExceededThreshold() {
        Runtime runtime = Runtime.getRuntime();
        long memoryMax = runtime.maxMemory();
        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        double memoryUsedPercent = (memoryUsed * 100.0) / memoryMax;

        if (memoryUsedPercent > USED_MEMORY_THRESHOLD){
            System.out.println("memoryUsedPercent: " + memoryUsedPercent);
            return true;
        }
        return false;
    }
}
