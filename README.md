# Consumer Services

It consumes data exposed by `https://xkcd.com/json.html` and `http://feeds.feedburner.com/PoorlyDrawnLines`. 
The fetched data is formated using model [Feed.java](blob/main/src/main/java/org/ss/model/Feed.java).

### Execution

- Gradle Build:
   - Linux: `sh ./gradlew build`
   - Windows: `gradlew build`
- Docker Compose: `docker-compose up`


### Docker

- [Docker-Compose](blob/main/doc/docker-compose.md)
- [Docker](blob/main/doc/docker.md)
  