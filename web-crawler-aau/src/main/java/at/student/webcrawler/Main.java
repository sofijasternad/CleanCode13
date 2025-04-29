package at.aau.student.webcrawler;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Verwendung: java Main <URL> <Tiefe> <Domains (kommagetrennt)>");
            return;
        }

        String startUrl = args[0];
        int depth = Integer.parseInt(args[1]);
        List<String> domains = Arrays.asList(args[2].split(","));

        Crawler crawler = new Crawler(depth, domains);
        List<WebsiteData> crawledData = crawler.crawl(startUrl);

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport(crawledData, "crawler-report.md");

        System.out.println("Crawling abgeschlossen. Bericht gespeichert in crawler-report.md");
    }
}