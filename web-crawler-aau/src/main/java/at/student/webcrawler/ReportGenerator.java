package at.aau.student.webcrawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {

    public void generateReport(List<WebsiteData> crawledData, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (WebsiteData data : crawledData) {
                String indentation = "----".repeat(data.getDepth());
                writer.write("# " + indentation + data.getUrl() + "\n");
                for (WebsiteData.Heading heading : data.getHeadings()) {
                    writer.write(heading.getTag() + " " + indentation + heading.getText() + "\n");
                }
                for (WebsiteData.Link link : data.getLinks()) {
                    writer.write(indentation + "--> " + (link.isBroken() ? "**broken link** " : "link to ") + "<" + link.getUrl() + ">\n");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Berichtdatei: " + e.getMessage());
        }
    }
}