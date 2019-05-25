# colors-hex-JAXRS-Service

Here is a test project I did to get familiar with JAX-RS, Java API for xml-RESTful service for Java. In the project, I'm using plain text for displaying to the screen instead of xml for simplicity. Since we had to do one for an assignment, I did this as extra practice.

## What you need to test this out?
1. Clone the repo.
2. Download Netbeans 8.0.2 with Apache Tomcat build into the installation process: https://netbeans.org/downloads/8.0.2/.
3. Open up Command Prompt in Windows or Terminal on a Mac. 
4. Make sure you have cURL installed into it. If not, go install it from https://curl.haxx.se/.
5. Go into where you Apache Tomcat is installed (for example C: drive) and open the conf/tomcat-users.xml file.
6. Change username and password info to something you'll remember.
7. Open up Netbeans, import project and hit the run button to run the service which initializes the data. It will ask you for your login credentials from the tomcat-users.xml file you changed, type those into the prompt.
8. Make tests with the following cURL commands:

#### GET ALL -> 
`curl -X GET http://localhost:8080/TestingJAX/example/colors/`

#### GET COLOR BY ID  ->
`curl -X GET http://localhost:8080/TestingJAX/example/colors/{id} `

#### POST COLOR ->
`curl --data "name=white&hex=#FFFFFF" http://localhost:8080/TestingJAX/example/colors/add`

(you can change the color name value to anything and hex value to anything and it will work)

#### PUT COLOR ->
`curl -X PUT -d "name=red" -d "hex=#E13125" http://localhost:8080/TestingJAX/example/colors/2`

(again, feel free to change the name and hex value to whatever you like, and the id to anything. It checks if the id exists; if it does it displays "Something already exists with this id". If it doesn't, it adds the new values to that id).

In addition, if put at 6 but there's nothing before it, it just takes the spot of an earlier spot, so far three colors, it takes up the fourth spot.

#### DELETE COLOR ->
`curl -X DELETE http://localhost:8080/TestingJAX/example/colors/6`

Deletes the color based on id. Change the id to whatever. If it can't find it, it throws a 404 not found, with a message in console "Cannot find color".

If you find any bugs with the services, feel free to put in an issue and I'll fix it up. Or just enjoy the effort put into it :)
