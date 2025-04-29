package at.aau.student.webcrawler;

import java.util.LinkedList;
import java.util.List;

public class WebsiteData {
    private final String url;
    private final int depth;
    private final List<Heading> headings;
    private final List<Link> links;
    private final boolean isBroken;

    public WebsiteData(String url, int depth) {
        this(url, depth, false);
    }

    public WebsiteData(String url, int depth, boolean isBroken) {
        this.url = url;
        this.depth = depth;
        this.headings = new LinkedList<>();
        this.links = new LinkedList<>();
        this.isBroken = isBroken;
    }

    public String getUrl() {
        return url;
    }

    public int getDepth() {
        return depth;
    }

    public List<Heading> getHeadings() {
        return headings;
    }

    public List<Link> getLinks() {
        return links;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void addHeading(String tag, String text) {
        this.headings.add(new Heading(tag, text));
    }

    public void addLink(String url, boolean isBroken) {
        this.links.add(new Link(url, isBroken));
    }

    public static class Heading {
        private final String tag;
        private final String text;

        public Heading(String tag, String text) {
            this.tag = tag;
            this.text = text;
        }

        public String getTag() {
            return tag;
        }

        public String getText() {
            return text;
        }
    }

    public static class Link {
        private final String url;
        private final boolean isBroken;

        public Link(String url, boolean isBroken) {
            this.url = url;
            this.isBroken = isBroken;
        }

        public String getUrl() {
            return url;
        }

        public boolean isBroken() {
            return isBroken;
        }
    }
}