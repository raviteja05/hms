# Hospital Appointment Management System

Setup steps
===========

1. Download and extract the zip file or clone the repository
2.  After extracting the zip, go to src/main/resources/data dumps folder and open the sql file provided
3. Go to mysql workbench and import the data from the opened dump file.
4. Go to application.properties in src/main/resources and update the database url with schema name new_schema(<mysql_url>:3306/new_schema). Update db username and password.
5. Go to application.properties in src/test/resources and update the database url with schema name test_schema(<mysql_url>:3306/test_schema). Update db username and password.
6. Configure SMTP email and password to enable email confirmation functionality
  spring.mail.username=<SMTP Username>
  spring.mail.password=<SMTP Password>
7. Admin login credentials are defaulted to admin@appcal.com/password. Admin user can login with this credentials to access admin dashboard.
8. Go to the parent directory of the project in the command prompt(directory where pom.xml is located). Run build.bat from command prompt.
9. Build takes around 1-2minutes. Once build is done the site can be accessed by typing the URL http://localhost:8080/home
10. The hospital start and end times, and appointment duration are configured by following properties
    appointment.duration.minutes=15
    startTime=08:00
    endTime=18:00
11. The user login session time out can be controlled by the below property:
    server.servlet.session.timeout=15m
