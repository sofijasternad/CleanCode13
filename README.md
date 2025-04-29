The task of this assignment is to develop a Web-Crawler in Java, which provides a compact overview of the given website and linked websites by only listing the headings and the links. The attached example-report.md shows an example of how the overview could look (feel free to improve the suggested layout).
Must have features
How to start the application:

on the command line that also contains the input arguments URL, depth, domains
The crawler MUST implement at least the following features:

input the URL, the depth of websites to crawl, and the domain(s) of websites to be crawled
create a compact overview of the crawled websites 
record only the headings
represent the depth of the crawled websites with proper indentation (see example)
record the URLs of the crawled sites
highlight broken links
find the links to other websites and recursively do the analysis for those websites
that can be reached within the given depth (to avoid very long runtimes)
and is located in one of the specified domain(s)
also note, each website should be crawled only once
store the results in a single markdown file (.md extension, see the example-report.md)
Note, also provide automated unit tests for each feature (we will not accept submissions without unit tests).

Implementation
Regarding the implementation, please use a modern IDE (Eclipse, IntelliJ, Visual Code, etc. ) and GitHub, GitLab, or BitBucket to version and share your sources. The repository must contain a README file briefly describing the steps to build, run, and test your crawler.
Use a Java testing framework, e.g., JUnit for automating the tests. Also, use a build tool like Maven or Gradle to automate the build and testing of your solution. Furthermore, we suggest using an existing library, such as jsoup, for parsing HTML. 
Submission
Please tag the submitted release in your code repository (e.g., create a release tag on GitHub) and submit a pdf (1 A4-page) that contains the link to your released/tagged version and the names of your group members via Moodle. The deadline is: 29. April 2025, 23:59

Grading
The assignment will be evaluated based on the following criteria:

How well you named functions, variables, and classes (how descriptive the code is)
The functions you implemented and if they follow certain clean code principles (single responsibility etc.)
How well is your code tested and how clean Unit tests are written
The overall structure of the code (formatting).
Correct and appropriate use of comments.
Remember that the 2nd Assignment will build upon this one, so do yourself a favor and write clean code.
Questions
Please use the "Diskussionsforum" to post and discuss your questions. The forum will be overseen by our tutor.
