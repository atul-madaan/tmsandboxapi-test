# About - assurity-tmssandbox-apitest
This project was developed in Eclipse IDE to Test tmsandbox api.   
Below are the details of the target uri and Acceptance criteria.  
API= https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false  
Acceptance criteria:  
Response should include:-  
#### 1. Name= "Carbon credits"
#### 2. CanRelist="true"
#### 3. The Promotions element with Name = "Gallery" has a Description that containts the test "2x larger image"  
*Please note the sysout statement in the project are only for assesment purpose.

## Prerequisite to execute the test-  
1. Make sure TestNG plugin is installed(in your IDE).  
2. If your IDE is Eclipse, install TestNG plugin from Eclipse marketplace under "Help" menu.  
3. After installation wait until you get "Eclipse restart"  
4. Restart Eclipse  

## How to Execute the test-  
1. Import the project in Eclipse. Refresh the pom.xml (just in-case).  
2. go to /src/test/java/tmssandbox/api/CategoriesGetDetailsCatalouge.java  
3. Right-click and Run as "TestNG test" in Eclipse.  

