# miniRest
Code kata mini rest project

# Requirement
We will need a new Java app to read in a CSV file from a directory. The contents will then need to be sent to a REST API endpoint, in JSON format, and saved to a SQL database.
1. Create a console app to read in a CSV file from a directory.
2. Parse the CSV file of which the contents are:
- Customer Ref
- Customer Name
- Address Line 1
- Address Line 2
- Town
- County
- Country
- Postcode
3. Loop through the rows of the CSV file and send each row to a REST API POST endpoint, in JSON format.
4. The REST API should then save the content to a database table. Format can match the CSV file.
5. Create a REST API GET endpoint to retrieve the customer information, passing in a customer ref to filter the data. Contents should be returned in JSON format.
6. Some documentation or Wiki to explain the approach taken.

# database
- PostgreSQL
### url
- jdbc:postgresql://132.145.57.124:5432/katadb
### user
- katauser
# URL
### adminer
- http://132.145.57.124:8080/
# Test
### POST customerInformation
curl --location --request POST 'http://localhost:8080/customerInformation' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customer_ref": "CR7",
    "customer_name": "Jackson Morgan",
    "address_line_1": "22 Albert Rd",
    "address_line_2": "",
    "town": "Tamworth",
    "county": "Staffordshire",
    "country": "United Kingdom",
    "postcode": "B79 7JS"
}'
### GET customerInformation
curl --location --request GET 'http://localhost:8080/customerInformation?customerRef=1'
