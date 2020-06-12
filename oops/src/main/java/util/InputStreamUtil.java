package util;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class InputStreamUtil {

    public static String getWebPageContentAsString(String webLink) throws IOException {

        StringBuffer webPageContent = new StringBuffer();
        URL url = new URL(webLink);

        Scanner webPageInputStream = new Scanner(url.openStream());

        while (webPageInputStream.hasNext()) {
            webPageContent.append(webPageInputStream.next());
        }

        String pageContent = webPageContent.toString();
        return pageContent;
    }
}
