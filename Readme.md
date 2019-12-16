How to run it
===
Load the mongodb instance on localhost:27017 or change the config file "application.properties"<br/>
$: java -jar joan3thProblem-1.0-SNAPSHOT.jar
<h1>Endpoints</h1>
curl -X GET \
  'http://localhost:8080/book/search?q=Fiction' 