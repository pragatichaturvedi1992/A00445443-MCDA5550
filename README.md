# A00445443-MCDA5550

This repo will have the version of hotel reservation system.

This System is build on Java/SpringBoot framework and war is deployed on AWS Elastic Beanstalk.

An API is a set of programming code that enables data transmission between one software product and another. It also contains the terms of this data exchange.
![image](https://user-images.githubusercontent.com/77502679/125179171-2d9b7580-e1c2-11eb-841e-5bf81ce0e902.png)

Application programming interfaces consist of two components:

1. Technical specification describing the data exchange options between solutions with the specification done in the form of a request for processing and data delivery protocols
2. Software interface written to the specification that represents it.

To Test the API, Postman is used and sample result set is provided in case of Get and Post calls.
Get request will Fetch the HotelName, Price and Availability details. 

![image](https://user-images.githubusercontent.com/77502679/125179216-dea21000-e1c2-11eb-88fc-9dec63fadc13.png)

Post Request will display the hotel booking confirmation number.

![image](https://user-images.githubusercontent.com/77502679/125179220-ef528600-e1c2-11eb-8272-28779c74d160.png)

This system uses ControllerAdvice to handle the exception caused at runtime when provided with mismatch Gender String.
