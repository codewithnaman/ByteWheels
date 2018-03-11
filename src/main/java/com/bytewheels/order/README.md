1.1 Create Order
     
       | Endpoint        | /order
       | HttpMethod      | POST
       | Description     | This API creates order.
       | Sample Request  | {
                           	"customerId" :"4a83916c-0666-44bd-99ca-e6ae58885876",
                           	"itemId" : "3f8dbfec-3a7b-41d1-84c1-cc71d0a35e13",
                           	"fromDate":"11/03/2018",
                           	"toDate":"13/03/2018"
                           }
       | Sample Response | {
                           	"orderId": "f91ba8cc-eee0-4e77-9272-23719de05e74",
                           	"customerFirstName": "Yaseen",
                           	"customerLastName": "Khan",
                           	"customerEmail": "myaseen.khan@hotmail.com",
                           	"customerMobileNumber": "123458657",
                           	"carName": "BMW 328i",
                           	"carDescription": "The BMW 3 Series is an entry-level luxury car manufactured by the German automaker BMW since May 1975.",
                           	"carCategory": "Luxury",
                           	"allocatedCarRegistrationNumber": "MH12PT1575",
                           	"totalAmount": 150.0,
                           	"fromDate": "11/03/2018",
                           	"toDate": "13/03/2018"
                           }
     
  1.2 List of all order
     
        | Endpoint        | /order
        | HttpMethod      | GET
        | Description     | Returns all order in our System.
        | Sample Response | [
                            	{
                            		"orderId": "fa323cf5-69b6-4bfc-b6e1-96313f1e371e",
                            		"customerFirstName": "Naman",
                            		"customerLastName": "Gupta",
                            		"customerEmail": "naman.gupta810@hotmail.com",
                            		"customerMobileNumber": "1234567890",
                            		"carName": "BMW X5",
                            		"carDescription": "The BMW X5 is a mid-size luxury SUV produced by BMW.",
                            		"carCategory": "Luxury",
                            		"allocatedCarRegistrationNumber": "MH12JD2020",
                            		"totalAmount": 150.0,
                            		"fromDate": "13/03/2018",
                            		"toDate": "15/03/2018"
                            	},
                            	{
                            		"orderId": "46082da1-0975-4986-8fad-4abd1ec57e48",
                            		"customerFirstName": "Naman",
                            		"customerLastName": "Gupta",
                            		"customerEmail": "naman.gupta810@hotmail.com",
                            		"customerMobileNumber": "1234567890",
                            		"carName": "BMW X5",
                            		"carDescription": "The BMW X5 is a mid-size luxury SUV produced by BMW.",
                            		"carCategory": "Luxury",
                            		"allocatedCarRegistrationNumber": "MH12JD3030",
                            		"totalAmount": 300.0,
                            		"fromDate": "16/03/2018",
                            		"toDate": "20/03/2018"
                            	},
                            	{
                            		"orderId": "2d32ddeb-d5bb-4ee3-b052-4e9a52a9b41d",
                            		"customerFirstName": "Naman",
                            		"customerLastName": "Gupta",
                            		"customerEmail": "naman.gupta810@hotmail.com",
                            		"customerMobileNumber": "1234567890",
                            		"carName": "BMW 328i",
                            		"carDescription": "The BMW 3 Series is an entry-level luxury car manufactured by the German automaker BMW since May 1975.",
                            		"carCategory": "Luxury",
                            		"allocatedCarRegistrationNumber": "MH12PT1572",
                            		"totalAmount": 150.0,
                            		"fromDate": "11/03/2018",
                            		"toDate": "13/03/2018"
                            	},
                            	{
                            		"orderId": "f91ba8cc-eee0-4e77-9272-23719de05e74",
                            		"customerFirstName": "Yaseen",
                            		"customerLastName": "Khan",
                            		"customerEmail": "myaseen.khan@hotmail.com",
                            		"customerMobileNumber": "123458657",
                            		"carName": "BMW 328i",
                            		"carDescription": "The BMW 3 Series is an entry-level luxury car manufactured by the German automaker BMW since May 1975.",
                            		"carCategory": "Luxury",
                            		"allocatedCarRegistrationNumber": "MH12PT1575",
                            		"totalAmount": 150.0,
                            		"fromDate": "11/03/2018",
                            		"toDate": "13/03/2018"
                            	}
                            ]
  1.3 Search Order by ID
  
       
        | Endpoint        | /order/{OrderId}
        | HttpMethod      | POST
        | Description     | Search order by orderId
        | Sample Response | {
                            	"orderId": "2d32ddeb-d5bb-4ee3-b052-4e9a52a9b41d",
                            	"customerFirstName": "Naman",
                            	"customerLastName": "Gupta",
                            	"customerEmail": "naman.gupta810@hotmail.com",
                            	"customerMobileNumber": "1234567890",
                            	"carName": "BMW 328i",
                            	"carDescription": "The BMW 3 Series is an entry-level luxury car manufactured by the German automaker BMW since May 1975.",
                            	"carCategory": "Luxury",
                            	"allocatedCarRegistrationNumber": "MH12PT1572",
                            	"totalAmount": 150.0,
                            	"fromDate": "11/03/2018",
                            	"toDate": "13/03/2018"
                            }
    
  1.3 Delete order by ID
  
       
        | Endpoint        | /order/{OrderId}
        | HttpMethod      | DELETE
        | Description     | DELETE order by orderId
        | Sample Response |