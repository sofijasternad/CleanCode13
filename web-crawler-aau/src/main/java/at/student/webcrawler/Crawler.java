package at.aau.student.webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Crawler {

    private final int maxDepth;
    private final Set<String> visitedUrls;
    private final List<WebsiteData> crawledData;
    private final List<String> allowedDomains;
    private final LinkChecker linkChecker;

    public Crawler(int maxDepth, List<String> allowedDomains) {
        this.maxDepth = maxDepth;
        this.visitedUrls = new HashSet<>();
        this.crawledData = new LinkedList<>();
        this.allowedDomains = allowedDomains;
        this.linkChecker = new LinkChecker();
    }

    public List<WebsiteData> crawl(String startUrl) {
        crawlPage(startUrl, 0);
        return crawledData;
    }

    private void crawlPage(String url, int depth) {
        if (depth > maxDepth || visitedUrls.contains(url) || !isInAllowedDomain(url)) {
            return;
        }

        visitedUrls.add(url);

        try {
            Document doc = Jsoup.connect(url).get();
            Elements headings = doc.select("h1, h2, h3, h4, h5, h6");
            Elements links = doc.select("a[href]");

            WebsiteData data = new WebsiteData(url, depth);
            for (Element heading : headings) {
                data.addHeading(heading.tagName(), heading.text());
            }

            for (Element link : links) {
                String absoluteLink = link.absUrl("href");
                data.addLink(absoluteLink, linkChecker.isBrokenLink(absoluteLink));
                crawlPage(absoluteLink, depth + 1);
            }

            crawledData.add(data);

        } catch (IOException e) {
            System.err.println("Fehler beim Crawlen von " + url + ": " + e.getMessage());
            crawledData.add(new WebsiteData(url, depth, true)); // Markiere als fehlerhaft
        }
    }

    private boolean isInAllowedDomain(String url) {
        if (allowedDomains.isEmpty()) {
            return true;
        }
        for (String domain : allowedDomains) {
            if (url.contains(domain)) {
                return true;
            }
        }
        return false;
    }
}