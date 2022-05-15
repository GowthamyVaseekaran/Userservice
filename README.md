# user-service application

[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Applications for managing users

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- Application should be a run with a user having permission to create directories

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