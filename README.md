# speed-cameras
Processing speed cameras data

This folder concains two applicatin filders: sender and central. Both are to be built via maven. They were written using Sprint Tool Suite.

"central" contains the application for camera message processing. It is organized as web application and should be built into .war file. It should be started firstly

"sender" is simple application just to send REST-queries to "central".

The "central" application will save the messages about over-limit speed into a sqlite-database.
The database is to be located in Java temporary file directory. 
Sqlite was chosen because it allows to create databases without any passwords/logins and save it simply to a file which seemed enough.
