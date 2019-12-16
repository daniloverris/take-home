How to run it
===
Load the mongodb instance on localhost:27017 or change the config file "application.properties"<br/>
$: java -jar joan2ndProblem-0.0.1-SNAPSHOT.jar
<h1>Endpoints</h1>
curl -X POST \
  http://localhost:8080/uploadfile \
  -H 'content-type: multipart/form-data; \
  -F file=@/[your-path]/books.json
  <br/>
  curl -X GET \
    http://localhost:8080/book/all
<br/>
curl -X PATCH \
  http://localhost:8080/book/update/399226907 \
  -H 'content-type: multipart/form-data; \
  -F qty=500