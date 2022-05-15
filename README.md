# user-service application

[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Applications for managing users

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- Application should be run with the user who is having a permission to create the directory in the specified location

## Requirement
The application accepts the below array as JSON request and perform the following tasks
1. Create directory “Users”, If not exist at specified path in a config file
   a. Create Sub Directory “IN”.
2. Store the Request as JSON file in “IN” directory” created above

## Implemented Solution
The output file name will the  <b>current date_sequence_number.json </b> <br>
The sequence number will be re-setted at the end of the day <br>
Eg: 2022_5_15_3.json

Two approaches are implemented. <br>
<b> 1. Synchronous approach </b><br>
The file will be created (I/O) synchronously with the runtime <br>
EndPoint: http://localhost:8005/v1/user <br>
<b>2. Asynchronous approach </b><br>
The file will be created asynchronously in background. <br>
Endpoint: http://localhost:8005/v2/user

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. 

1. Using Intellij
2. Run as service

```shell
   mvn clean install
   cp target/user-service-{version}.zip /apps/
   cd /apps/
   unzip user-service-{version}.zip
   cd ser-service-{version}/bin/
   ././user-service-application start.

```

## Curl
curl --location --request POST 'http://localhost:8005/v1/user' \
--header 'Content-Type: application/json' \
--data-raw '[
{
"ID": 64,
"UserID": 7,
"EmployeeID": "CLGAXO",
"SiteName": "MULGRAVE",
"BusinessUnitName": "Telstra Logistics - Melbourne",
"AccountName": "IBM AUSTRALIA LTD",
"GroupName": "Transport",
"CategoryName": "Activity - Productive",
"TypeName": "Transport - Freight Sorting",
"Date": "2018-02-14",
"Duration": "00:30",
"IsProcessed": false
},
{
"ID": 66,
"UserID": 7,
"EmployeeID": "e",
"SiteName": "MULGRAVE",
"BusinessUnitName": "Telstra Logistics - Melbourne",
"AccountName": "IBM AUSTRALIA LTD",
"GroupName": "Picking",
"CategoryName": "Activity - Productive",
"TypeName": "Picking - Bulk",
"Date": "2018-02-15",
"Duration": "00:30",
"IsProcessed": false
}
]'