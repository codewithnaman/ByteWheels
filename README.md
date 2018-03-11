# ByteWheels
ByteWheels is a car rental web application.

Below are the flow to rent any car:
1. Customer needs to identify himself/herself.
2. If Customer is not register then he/she needs to register with ByteWheels.
3. Now Customer needs to pick the Dates in which he/she wanted to rent the car.
4. After confirming the car is booked for the given dates and an invoice is sent to customer.

Since every application has Customer facing as well as Customer Service and the Admin panel.
So this application exposes some of the admin and customer service facing APIs as well.

#How to Run
1. CheckOut the project from github
2. Gradle is necessary to run this.
3. Run setupH2 Gradle task
4. Run ApplicationConfig.java

#API Contracts and Error Codes
1. [Customer](src/main/java/com/bytewheels/customer/README.md)
2. [Inventory](src/main/java/com/bytewheels/inventory/README.md)
3. [Order](src/main/java/com/bytewheels/order/README.md)

Evert API exposes error codes in response if the input is not appropriate or any business exception occurs.

The error codes in response are self-explanatory.

#Remaining work TODO
1. JavaDoc
2. Test case and coverage

#Concept
1. The concept behind the package structure which is used in the project to divide the classes in business capabilities(Micro-services).

2. Common contains the classes or utility used throughout all the modules.

3. For email freemarker template is used whose support is provided by spring itself.
