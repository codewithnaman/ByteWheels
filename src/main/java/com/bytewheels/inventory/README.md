1.1 Search Available Items on selected Dates
     
       | Endpoint        | /iteminventory/search/date
       | HttpMethod      | POST
       | Description     | This API return list of items with status which is available AND which is not.UNAVILABLE will be used to show in grayed out in UI.
       | Sample Request  | {
                           	"fromDate" : "13/03/2018",
                           	"toDate" : "20/03/2018"
                           }
       | Sample Response | {
                           	"Compact": [
                           		{
                           			"itemId": "256fd6d0-8aaa-4ddf-9202-af61e77af9b2",
                           			"carName": "Ford Fiesta",
                           			"carDescription": "Most popular Ford Car",
                           			"carCategory": "Compact",
                           			"carPrice": 20.0,
                           			"availabilityStatus": "AVAILABLE"
                           		},
                           		{
                           			"itemId": "90bac9d7-0fbf-42bc-887b-c7d7626ba27f",
                           			"carName": "Ford Focus",
                           			"carDescription": "Most Performing car in this range",
                           			"carCategory": "Compact",
                           			"carPrice": 20.0,
                           			"availabilityStatus": "AVAILABLE"
                           		}
                           	],
                           	"Full": [
                           		{
                           			"itemId": "a17c8cc0-07f3-4668-baa8-7860765a530d",
                           			"carName": "Chevrolet Malibu",
                           			"carDescription": "It unites a passion for driving with exceptional efficiency.",
                           			"carCategory": "Full",
                           			"carPrice": 30.0,
                           			"availabilityStatus": "AVAILABLE"
                           		},
                           		{
                           			"itemId": "53d6fbf8-b2c5-4193-9542-6471cfae58a5",
                           			"carName": "Volkswagen Jetta",
                           			"carDescription": "Volkswagen Jetta is as inspiring to look at as it is to drive.",
                           			"carCategory": "Full",
                           			"carPrice": 30.0,
                           			"availabilityStatus": "AVAILABLE"
                           		}
                           	],
                           	"Large": [
                           		{
                           			"itemId": "f2e2a407-369d-4c42-8813-88eb1f581b20",
                           			"carName": "Ford Egde",
                           			"carDescription": "The Ford Edge is a Midsize crossover SUV that is manufactured by Ford Motor Company.",
                           			"carCategory": "Large",
                           			"carPrice": 40.0,
                           			"availabilityStatus": "AVAILABLE"
                           		},
                           		{
                           			"itemId": "f3d89a04-fae9-4cb9-b464-0e610e4777a9",
                           			"carName": "Ford Escape",
                           			"carDescription": "The Ford Escape is a compact crossover vehicle sold by Ford since 2000 over three generations.",
                           			"carCategory": "Large",
                           			"carPrice": 40.0,
                           			"availabilityStatus": "AVAILABLE"
                           		}
                           	],
                           	"Luxury": [
                           		{
                           			"itemId": "3f8dbfec-3a7b-41d1-84c1-cc71d0a35e13",
                           			"carName": "BMW 328i",
                           			"carDescription": "The BMW 3 Series is an entry-level luxury car manufactured by the German automaker BMW since May 1975.",
                           			"carCategory": "Luxury",
                           			"carPrice": 50.0,
                           			"availabilityStatus": "UNAVAILABLE"
                           		},
                           		{
                           			"itemId": "0dc81dba-536b-44da-b194-5728db0b3f5b",
                           			"carName": "BMW X5",
                           			"carDescription": "The BMW X5 is a mid-size luxury SUV produced by BMW.",
                           			"carCategory": "Luxury",
                           			"carPrice": 50.0,
                           			"availabilityStatus": "UNAVAILABLE"
                           		}
                           	]
                           }
     
  1.2 Get all categories.
     
        | Endpoint        | /itemcategory
        | HttpMethod      | GET
        | Description     | This API return all item categories and their data.
        | Sample Response | [
                            	{
                            		"id": "d6ef396b-82ea-4232-ae19-92f0af15e16a",
                            		"name": "Compact",
                            		"price": 20.0
                            	},
                            	{
                            		"id": "5cb66b49-7027-45cf-b6d5-bb3b0ef9ea0e",
                            		"name": "Full",
                            		"price": 30.0
                            	},
                            	{
                            		"id": "44aba215-0fbc-4dbf-b86c-d502820117fe",
                            		"name": "Large",
                            		"price": 40.0
                            	},
                            	{
                            		"id": "d96506b8-1bfc-442a-ad3e-cfeabc539223",
                            		"name": "Luxury",
                            		"price": 50.0
                            	}
                            ]
  1.3 Create new category 
  
       
        | Endpoint        | /itemcategory
        | HttpMethod      | POST
        | Description     | This API creates a new category
        | Sample Request  | {
                            	"price": 50.00,
                                "name":"Double Luxury1"
                            }
        | Sample Response | {
                            	"id": "015b940d-2e54-4c22-928f-f71a48e361b5",
                            	"name": "Double Luxury1",
                            	"price": 50.0
                            }
     
            
  1.4 Update category
          
                | Endpoint        | /itemcategory
                | HttpMethod      | PUT
                | Description     | This API update itemcategory
                | Sample Request  | {
                                        "id": "015b940d-2e54-4c22-928f-f71a48e361b5",
                                    	"price": 50.00,
                                        "name":"Double Luxury1"
                                    }
                 
  1.5 Delete category
            
                  | Endpoint        | /itemcategory/{itemCategoryId}
                  | HttpMethod      | DELETE
                  | Description     | This API update itemcategory
                  | Sample Response | 
  
   1.6 Get All Items
              
                    | Endpoint        | /item
                    | HttpMethod      | GET
                    | Description     | This API update itemcategory
                    | Sample Response | [
                                        	{
                                        		"id": "256fd6d0-8aaa-4ddf-9202-af61e77af9b2",
                                        		"name": "Ford Fiesta",
                                        		"description": "Most popular Ford Car",
                                        		"itemCategoryData": {
                                        			"id": "d6ef396b-82ea-4232-ae19-92f0af15e16a",
                                        			"name": "Compact",
                                        			"price": 20.0
                                        		},
                                        		"price": null
                                        	},
                                        	{
                                        		"id": "90bac9d7-0fbf-42bc-887b-c7d7626ba27f",
                                        		"name": "Ford Focus",
                                        		"description": "Most Performing car in this range",
                                        		"itemCategoryData": {
                                        			"id": "d6ef396b-82ea-4232-ae19-92f0af15e16a",
                                        			"name": "Compact",
                                        			"price": 20.0
                                        		},
                                        		"price": null
                                        	},
                                        	{
                                        		"id": "a17c8cc0-07f3-4668-baa8-7860765a530d",
                                        		"name": "Chevrolet Malibu",
                                        		"description": "It unites a passion for driving with exceptional efficiency.",
                                        		"itemCategoryData": {
                                        			"id": "5cb66b49-7027-45cf-b6d5-bb3b0ef9ea0e",
                                        			"name": "Full",
                                        			"price": 30.0
                                        		},
                                        		"price": null
                                        	},
                                        	{
                                        		"id": "53d6fbf8-b2c5-4193-9542-6471cfae58a5",
                                        		"name": "Volkswagen Jetta",
                                        		"description": "Volkswagen Jetta is as inspiring to look at as it is to drive.",
                                        		"itemCategoryData": {
                                        			"id": "5cb66b49-7027-45cf-b6d5-bb3b0ef9ea0e",
                                        			"name": "Full",
                                        			"price": 30.0
                                        		},
                                        		"price": null
                                        	},
                                        	{
                                        		"id": "f2e2a407-369d-4c42-8813-88eb1f581b20",
                                        		"name": "Ford Egde",
                                        		"description": "The Ford Edge is a Midsize crossover SUV that is manufactured by Ford Motor Company.",
                                        		"itemCategoryData": {
                                        			"id": "44aba215-0fbc-4dbf-b86c-d502820117fe",
                                        			"name": "Large",
                                        			"price": 40.0
                                        		},
                                        		"price": null
                                        	},
                                        	{
                                        		"id": "f3d89a04-fae9-4cb9-b464-0e610e4777a9",
                                        		"name": "Ford Escape",
                                        		"description": "The Ford Escape is a compact crossover vehicle sold by Ford since 2000 over three generations.",
                                        		"itemCategoryData": {
                                        			"id": "44aba215-0fbc-4dbf-b86c-d502820117fe",
                                        			"name": "Large",
                                        			"price": 40.0
                                        		},
                                        		"price": null
                                        	},
                                        	{
                                        		"id": "3f8dbfec-3a7b-41d1-84c1-cc71d0a35e13",
                                        		"name": "BMW 328i",
                                        		"description": "The BMW 3 Series is an entry-level luxury car manufactured by the German automaker BMW since May 1975.",
                                        		"itemCategoryData": {
                                        			"id": "d96506b8-1bfc-442a-ad3e-cfeabc539223",
                                        			"name": "Luxury",
                                        			"price": 50.0
                                        		},
                                        		"price": null
                                        	},
                                        	{
                                        		"id": "0dc81dba-536b-44da-b194-5728db0b3f5b",
                                        		"name": "BMW X5",
                                        		"description": "The BMW X5 is a mid-size luxury SUV produced by BMW.",
                                        		"itemCategoryData": {
                                        			"id": "d96506b8-1bfc-442a-ad3e-cfeabc539223",
                                        			"name": "Luxury",
                                        			"price": 50.0
                                        		},
                                        		"price": null
                                        	}
                                        ]
              
  1.7 Get item by ID
              
                    | Endpoint        | /item/{itemId}
                    | HttpMethod      | GET
                    | Description     | This API get item by id.
                    | Sample Response | {
                                        	"id": "0dc81dba-536b-44da-b194-5728db0b3f5b",
                                        	"name": "BMW X5",
                                        	"description": "The BMW X5 is a mid-size luxury SUV produced by BMW.",
                                        	"itemCategoryData": {
                                        		"id": "d96506b8-1bfc-442a-ad3e-cfeabc539223",
                                        		"name": "Luxury",
                                        		"price": 50.0
                                        	},
                                        	"price": null
                                        }
  
  1.8 Create Item
                
                      | Endpoint        | /item
                      | HttpMethod      | POST
                      | Description     | This API creates an item.
                      | Sample Response | {
                                          	"id": "0dc81dba-536b-44da-b194-5728db0b3f5b",
                                          	"name": "BMW X5",
                                          	"description": "The BMW X5 is a mid-size luxury SUV produced by BMW.",
                                          	"itemCategoryData": {
                                          		"id": "d96506b8-1bfc-442a-ad3e-cfeabc539223",
                                          		"name": "Luxury",
                                          		"price": 50.0
                                          	},
                                          	"price": null
                                          }