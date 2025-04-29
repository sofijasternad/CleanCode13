# Web-Crawler (AAU)

Dieses Projekt implementiert einen Web-Crawler in Java, der eine kompakte Übersicht einer gegebenen Website und verlinkter Websites erstellt.

## Voraussetzungen

* Java Development Kit (JDK) 17 oder höher
* Maven
* IntelliJ IDEA (oder eine andere moderne Java IDE)
* Git (optional, für die Versionsverwaltung)

## Bauen

1.  Öffnen Sie das Projekt in IntelliJ IDEA.
2.  Öffnen Sie das Maven-Fenster (normalerweise auf der rechten Seite).
3.  Führen Sie den Lifecycle-Befehl `clean install` aus. Alternativ können Sie das Maven-Terminal verwenden und `mvn clean install` eingeben.

## Ausführen

Der Crawler kann über die Kommandozeile ausgeführt werden. Öffnen Sie ein Terminal im Hauptverzeichnis des Projekts (oder verwenden Sie das integrierte Terminal in IntelliJ IDEA) und führen Sie den folgenden Befehl aus:

```bash
java -cp target/webcrawler-1.0-SNAPSHOT.jar at.aau.student.webcrawler.Main <Start-URL> <Tiefe> <Domänen (kommagetrennt)>