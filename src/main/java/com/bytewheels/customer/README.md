1.1 List of all customer
     
       | Endpoint        | /customer
       | HttpMethod      | GET
       | Description     | This API return list of customers.
       | Sample Response | [
                           	{
                           		"id": "ad8018c8-250e-46e7-868b-84cdcf37d7b2",
                           		"firstName": "Naman",
                           		"lastName": "Gupta",
                           		"email": "naman.gupta810@hotmail.com",
                           		"mobileNumber": "1234567890"
                           	},
                           	{
                           		"id": "4a83916c-0666-44bd-99ca-e6ae58885876",
                           		"firstName": "Yaseen",
                           		"lastName": "Khan",
                           		"email": "myaseen.khan@hotmail.com",
                           		"mobileNumber": "123458657"
                           	}
                           ]
     
  1.2 Search Customer by email
     
        | Endpoint        | /customer/search/{email}
        | HttpMethod      | GET
        | Description     | This API return customer by email.
        | Sample Response | {
                            	"id": "4a83916c-0666-44bd-99ca-e6ae58885876",
                            	"firstName": "Yaseen",
                            	"lastName": "Khan",
                            	"email": "myaseen.khan@hotmail.com",
                            	"mobileNumber": "123458657"
                            } 
  1.3 Register Customer
  
       
        | Endpoint        | /customer
        | HttpMethod      | POST
        | Description     | Create Customer at server
        | Sample Request  | {
                            	"firstName":"Naman",
                            	"lastName":"Gupta",
                            	"mobileNumber":"840520145",
                            	"email":"naman@hotmail.com"
                            }
        | Sample Response | {
                            	"id": "5f1cd06c-c217-4ff3-9764-6cdc338be26a",
                            	"firstName": "Naman",
                            	"lastName": "Gupta",
                            	"email": "naman@hotmail.com",
                            	"mobileNumber": "840520145"
                            }