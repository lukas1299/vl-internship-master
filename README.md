GET /app/getProductFromDataBase

Param: name :  "Apple" 

DISCRIPTION:
Get produkt from database by name.

Example:
Path: http://localhost:8080/app/getProductFromDataBase?name=Apple

Result:
{"name":"Apple","type":"FRUITS","price":2}


POST /app/basket/addToBasket

Param name : "Apple"

DISCRIPTION:
Add product from our database to basket. The product is selected by name.

Path: http://localhost:8080/app/basket/addToBasket?name=Apple


GET /app/basket/getProductsFromBasket

DISCRIPTION:
Get all produkts from basket.

Result:
[
  {
    "name": "Bread",
    "type": "GRAINS",
    "price": 5
  }
]

GET app/basket/generateReceipt

DISCRIPTION:
Generate final recipe including all discounts.


Path: /app/basket/generateReceipt

Result:

Example 1:
INCLUDING ONLY "10PERCENTDISCOUNT" BECAUSE NUMBER OF GRAINS PRODUCTS IS BELOW 3.

{
  "entries": [
    {
      "product": {
        "name": "Bread",
        "type": "GRAINS",
        "price": 5
      },
      "quantity": 2,
      "totalPrice": 10
    },
    {
      "product": {
        "name": "Apple",
        "type": "FRUITS",
        "price": 2
      },
      "quantity": 2,
      "totalPrice": 4
    },
    {
      "product": {
        "name": "Cereals",
        "type": "GRAINS",
        "price": 8
      },
      "quantity": 2,
      "totalPrice": 16
    },
    {
      "product": {
        "name": "Cheese",
        "type": "DAIRY",
        "price": 20.5
      },
      "quantity": 2,
      "totalPrice": 41.0
    }
  ],
  "discounts": [
    "TenPercentDiscount"
  ],
  "totalPrice": 63.90
}

Example 2:
IN THIS CASE, 2 DISCOUNTS WILL BE CONTAINED BECAUSE THERE ARE AT LEAST 3 CEREAL PRODUCTS AND THE PRICE AFTER THE REALIZATION OF "15PERCENTDISCOUNT" IS MORE OR EQUAL TO 50.

{
  "entries": [
    {
      "product": {
        "name": "Bread",
        "type": "GRAINS",
        "price": 5
      },
      "quantity": 2,
      "totalPrice": 10
    },
    {
      "product": {
        "name": "Apple",
        "type": "FRUITS",
        "price": 2
      },
      "quantity": 2,
      "totalPrice": 4
    },
    {
      "product": {
        "name": "Cereals",
        "type": "GRAINS",
        "price": 8
      },
      "quantity": 2,
      "totalPrice": 16
    },
    {
      "product": {
        "name": "Cheese",
        "type": "DAIRY",
        "price": 20.5
      },
      "quantity": 2,
      "totalPrice": 41.0
    },
    {
      "product": {
        "name": "Bread",
        "type": "GRAINS",
        "price": 5
      },
      "quantity": 2,
      "totalPrice": 10
    }
  ],
  "discounts": [
    "FifteenPercentDiscount",
    "TenPercentDiscount"
  ],
  "totalPrice": 61.9650
}

