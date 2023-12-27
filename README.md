# Lead-Details
REST API to Create a Lead details in Postgres DB using Spring boot, Spring Data JPA for querying, regex for validation, exception handling.

1. Create a REST Api to Create a Lead in Postgres DB using Spring boot and Spring Data JPA for querying.  


Validations handled: 
1. leadId should be unique, integer and mandatory
2. firstName should strictly contain Alphabets, no spaces and mandatory.
3. middleName should strictly contain Alphabets, no spaces and non-mandatory.
4. lastName should strictly contain Alphabets, no spaces and mandatory.
5. mobileNumber should strictly contain integer, first digit should be greater than 5, no spaces and mandatory.
6. Gender Male/Female/Others, no spaces and mandatory.
7. DOB should strictly be in Date Format, no spaces and mandatory.
8. ADD proper validation for email

Write JUnit Test using Mockito for Controllers and Services.




Following will be the Request Body.
Req:

{
  "leadId": "4567",
  "firstName": "Vivek",
  "middleName": "",
  "lastName": "HJ",
  "mobileNumber": "9999999999",
  "Gender": "Male",
  "DOB": dd/mm/yyyy
  "email": "v@gmail.com"
}


Following will be the Response Body.
Response:
{
  "status": "success",
  "data": "Created Leads Successfully"
}


If leadId already exists in the Database then return error response in the following manner

{
  "status": "error",
  "errorResponse": {
    "code": "E10010",
    "messages": [
      "Lead Already Exists in the database with the lead id"
    ]
  }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------


2. Create a REST Api to Fetch a Lead in Postgres DB using Spring boot and Spring Data JPA for querying on the basis of the mobileNumber of a lead. 
There can be more than 1 lead in DB with a same mobileNumber. If no lead is obtained with mobileNumber, then return a response with a proper message.

Write JUnit Test using Mockito for Controllers and Services.



Following is the Response body of API.

Response:

{
  "status": "success",
  "data": [
  {
  "leadId": "1234",
  "firstName": "Abc",
  "middleName": "",
  "lastName": "JK",
  "mobileNumber": "9999999999",
  "Gender": "Male",
  "DOB": dd/mm/yyyy
  "email": "v@gmail.com"
  },
  "leadId": "5679",
  "firstName": "Kli",
  "middleName": "",
  "lastName": "Jkj",
  "mobileNumber": "9999999999",
  "Gender": "Male",
  "DOB": dd/mm/yyyy
  "email": "vi@gmail.com"
  }]
}


If No lead is found then Return below Response:

Response:

{
  "status": "error",
  "errorResponse": {
    "code": "E10011",
    "messages": [
      "No Lead found with the Mobile Number "
    ]
  }
}

---------------------------------------------------------------------------------------------------------------------







