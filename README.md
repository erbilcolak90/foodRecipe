# Food Recipe

Bu proje, kullanıcıların yemek yapmak istedikleri malzemeleri seçip, seçtiği malzemeler üzerinden, dünya mutfağına ait yemek tariflerine ulaşabilmelerini hedefleyen projedir.

### Postman Collections

skjgfskjglskj

## Entities
- Ingredient
- Food
- User
- FoodCategory
- IngredientCategory

### Ingredient 

It is the class created for Ingredient in the system.

- Id : `` String``
- name : ``String``
- pictureURL : ``String``
- foodCategory : ``List<String>``
- createDate : ``Date``
- isDeleted : ``boolean``

### Food

It is the class created for Food in the system.

- Id : ``String``
- name : ``String``
- ingredients : ``List<String>``
- pictureURL : ``String``
- recipe : ``String``
- foodCategory : ``List<String>``
- createDate : ``Date``
- isDeleted : ``boolean``

### User

It is the class created for User in the system.

- Id : ``String``
- name : ``String``
- surname : ``String``
- username :  ``String``
- password : ``String``
- createDate : ``Date``
- isDeleted : ``boolean``

### IngredientCategory

It is the class created for Ingredient Category in the system.

- Id : ``String``
- name : ``String``
- isDeleted : ``boolean``

### FoodCategory

It is the class created for Food Category in the system.

- Id : ``String``
- name : ``String``
- isDeleted : ``boolean``


### Rest Api

````
RestController("/ingredient")
RestController("/food")
RestController("/user")
RestController("/foodCategory")
RestController("/ingredientCategory")

````

## Get IngredientById

### Request

````
method: GET
url: /ingredient/getIngredientById
requestSample: herokuapp.com/ingredient/getIngredientById
requestParams: id : String
requestBody: {}
````

### Response

````
{
    "id": "63adf1fe9e6ce06f15ed22f3",
    "name": "makarna",
    "pictureURL": "https://www.aygingurmimg/urun/59u-.jpg",
    "ingredientCategory": [
    "63ade61677f797086d8f44ea",
    "63ade62b77f797086d8f44ec"
            ],
            "foodCategory": [
    "63ade61fwf437f797086d8f3ea",
    "63ade624277f797086d8f44123c"
            ],
            "createDate": "2022-12-29T20:01:02.499+00:00",
            "deleted": false
}
````

---

## Get IngredientByName

### Request

````
method: GET
url: /ingredient/getIngredientByName
requestSample: herokuapp.com/ingredient/getIngredientByName
requestParams: name : String
requestBody: {}
````

### Response

````

{
    "id": "63adf1fe9e6ce06f15ed22f3",
    "name": "makarna",
    "pictureURL": "https://www.aygingurmimg/urun/59u-.jpg",
    "ingredientCategory": [
    "63ade61677f797086d8f44ea",
    "63ade62b77f797086d8f44ec"
            ],
            "foodCategory": [
    "63ade61fwf437f797086d8f3ea",
    "63ade624277f797086d8f44123c"
            ],
            "createDate": "2022-12-29T20:01:02.499+00:00",
            "deleted": false
}
````

---

## Get IngredientById

### Request

````
method: GET
url: /ingredient/getIngredientById
requestSample: herokuapp.com/ingredient/getIngredientById
requestParams: id : String
requestBody: {}
````

### Response

````
{
    "id": "63adf1fe9e6ce06f15ed22f3",
    "name": "makarna",
    "pictureURL": "https://www.aygingurmimg/urun/59u-.jpg",
    "ingredientCategory": [
    "63ade61677f797086d8f44ea",
    "63ade62b77f797086d8f44ec"
            ],
            "foodCategory": [
    "63ade61fwf437f797086d8f3ea",
    "63ade624277f797086d8f44123c"
            ],
            "createDate": "2022-12-29T20:01:02.499+00:00",
            "deleted": false
}
````

---

## Get All Ingredients

### Request

````
method: GET
url: /ingredient/getAllIngredients
requestSample: herokuapp.com/ingredient/getAllIngredients
requestParams:
requestBody: {
  "page" : int,
  "size" : int,
  "sortBy" : String
}
````

### Response

````
{
    "content": [
       {
    "id": "63adf1fe9e6ce06f15ed22f3",
    "name": "makarna",
    "pictureURL": "https://www.aygingurmimg/urun/59u-.jpg",
    "ingredientCategory": [
    "63ade61677f797086d8f44ea",
    "63ade62b77f797086d8f44ec"
            ],
            "foodCategory": [
    "63ade61fwf437f797086d8f3ea",
    "63ade624277f797086d8f44123c"
            ],
            "createDate": "2022-12-29T20:01:02.499+00:00",
            "deleted": false
        },
        
        ...
        ],
}        

````

---

## Findby ContainsIngredientCategory

### Request

````
method: GET
url: /ingredient/findByContainsIngredientCategory
requestSample: herokuapp.com/ingredient/findByContainsIngredientCategory
requestParams: id : String
requestBody: {}
````

### Response

````
 {
        "id": "63ae027edef2861547e6f7e0",
        "name": "mercimek",
        "pictureURL": null,
        "ingredientCategory": [
            "63ade61677f797086d8f44ea",
            "63ade62b77f797086d8f44ec",
            "63ade63b77f797086d8f44ed"
        ],
        "foodCategory": [
            "63ae01e9def2861547e6f7d9",
            "63ae01ffdef2861547e6f7dd",
            "63ae0205def2861547e6f7de"
        ],
        "createDate": "2022-12-29T20:01:02.499+00:00",
        "deleted": false
    }

````

---

## Findby Containing

### Request

````
method: GET
url: /ingredient/findByNameContaining
requestSample: herokuapp.com/ingredient/findByNameContaining
requestParams: name : String
requestBody: {}
````

### Response

````
 [
    {
        "id": "63ac44fd25f11448d5a45ce4",
        "name": "sivri biber",
        "pictureURL": "https://www.aygingurme.com/dimg/urun/59u-.jpg",
        "ingredientCategory": "63ae01e9def2861547e6f7d9",
        "foodCategory": "63ae01e9def2861547e6f7d9",
        "createDate": "2022-12-28T13:30:37.348+00:00",
        "deleted": false
    },
    {
        "id": "63ac450625f11448d5a45ce5",
        "name": "dolmalık biber",
        "pictureURL": "https://www.aygingurme.com/dimg/urun/59u-.jpg",
        "ingredientCategory": "63ae01e9def2861547e6f7d9",
        "foodCategory": "63ae01e9def2861547e6f7d9",
        "createDate": "2022-12-28T13:30:46.455+00:00",
        "deleted": false
    },
  ...

````

---


## Findby Name And Food Category

### Request

````
method: GET
url: /ingredient/findByNameAndFoodCategoryContaining
requestSample: herokuapp.com/ingredient/findByNameAndFoodCategoryContaining
requestParams: name : String , foodCategory : String
requestBody: {}
````

### Response

````
 [
    {
        "id": "63ac44fd25f11448d5a45ce4",
        "name": "sivri biber",
        "pictureURL": "https://www.aygingurme.com/dimg/urun/59u-.jpg",
        "ingredientCategory": "63ae01e9def2861547e6f7d9",
        "foodCategory": "63ae01e9def2861547e6f7d9",
        "createDate": "2022-12-28T13:30:37.348+00:00",
        "deleted": false
    },
    {
        "id": "63ac450625f11448d5a45ce5",
        "name": "dolmalık biber",
        "pictureURL": "https://www.aygingurme.com/dimg/urun/59u-.jpg",
        "ingredientCategory": "63ae01e9def2861547e6f7d9",
        "foodCategory": "63ae01e9def2861547e6f7d9",
        "createDate": "2022-12-28T13:30:46.455+00:00",
        "deleted": false
    },
  ...

````

---

## Add Ingredient

### Request

````
method: POST
url: /ingredient/addIngredient
requestSample: herokuapp.com/ingredient/addIngredient
requestParams: -
requestBody: {
    name : String,
    pictureURL: String ,
    ingredientCategory : List<String>,
    foodCategory : List<String>
}
````

### Response

````
{
    "id": "63ae027edef2861547e6f7e0",
    "name": "mercimek",
    "pictureURL": "https://www.aygingurmimg/urun/59u-.jpg",
    "ingredientCategory": [
        "63ade61677f797086d8f44ea",
        "63ade62b77f797086d8f44ec",
        "63ade63b77f797086d8f44ed"
    ],
    "foodCategory": [
        "63ae01e9def2861547e6f7d9",
        "63ae01ffdef2861547e6f7dd",
        "63ae0205def2861547e6f7de"
    ],
    "createDate": "2022-12-29T21:11:26.449+00:00",
    "deleted": false
}
````

---


## Update Ingredient

### Request

````
method: POST
url: /ingredient/updateIngredient
requestSample: herokuapp.com/ingredient/updateIngredient
requestParams: -
requestBody: {
    id : String,
    name : String,
    pictureURL: String ,
    ingredientCategory : List<String>,
    foodCategory : List<String>
}
````

### Response

````
{
    "id": "63ae027edef2861547e6f7e0",
    "name": "mercimek",
    "pictureURL": "https://www.aygingurmimg/urun/59u-.jpg",
    "ingredientCategory": [
        "63ade61677f797086d8f44ea",
        "63ade62b77f797086d8f44ec",
        "63ade63b77f797086d8f44ed"
    ],
    "foodCategory": [
        "63ae01e9def2861547e6f7d9",
        "63ae01ffdef2861547e6f7dd",
        "63ae0205def2861547e6f7de"
    ],
    "createDate": "2022-12-29T21:11:26.449+00:00",
    "deleted": false
}
````

---


## Delete Ingredient

### Request

````
method: POST
url: /ingredient/deleteIngredient
requestSample: herokuapp.com/ingredient/deleteIngredient
requestParams: id : String
requestBody: {}
````

### Response

````
ingredient deleted.

````

---

## Get UserById

### Request

````
method: GET
url: /user/getUserById
requestSample: herokuapp.com/user/getUserById
requestParams: id : String
requestBody: {}
````

### Response

````
{
    "id": "63aaf6eaf047b5afe0bb7ed5",
    "name": "erbil",
    "surname": "colak",
    "username": "erbil123",
    "createDate": "2022-12-27T12:48:35.000+00:00",
    "deleted": false
}
````

---


## Get UserByName

### Request

````
method: GET
url: /user/getUserByName
requestSample: herokuapp.com/user/getUserByName
requestParams: name : String
requestBody: {}
````

### Response

````
{
    "id": "63aaf6eaf047b5afe0bb7ed5",
    "name": "erbil",
    "surname": "colak",
    "username": "erbil123",
    "createDate": "2022-12-27T12:48:35.000+00:00",
    "deleted": false
}
````

---


## Get AllUsers

### Request

````
method: GET
url: /user/getAllUsers
requestSample: herokuapp.com/user/getAllUsers
requestParams: -
requestBody: {}
````

### Response

````
[
    {
        "id": "63aaea96f047b5afe0bb7ed3",
        "name": "erbil",
        "surname": "colak",
        "username": "erbil123",
        "createDate": "2022-12-27T12:48:35.000+00:00",
        "deleted": false
    },
    {
        "id": "63aaf6eaf047b5afe0bb7ed5",
        "name": "erel",
        "surname": "colak",
        "username": "erel123",
        "createDate": "2022-12-27T12:48:35.000+00:00",
        "deleted": false
    },
````

---



    "id": "63ae027edef2861547e6f7e0",
    "name": "mercimek",
    "pictureURL": "https://www.aygingurmimg/urun/59u-.jpg",
    "ingredientCategory": [
        "63ade61677f797086d8f44ea",
        "63ade62b77f797086d8f44ec",
        "63ade63b77f797086d8f44ed"
    ],
    "foodCategory": [
        "63ae01e9def2861547e6f7d9",
        "63ae01ffdef2861547e6f7dd",
        "63ae0205def2861547e6f7de"
    ],
    "createDate": "2022-12-29T21:11:26.449+00:00",
    "deleted": false
}
````

---

## Add USer

### Request

````
method: POST
url: /user/addUser
requestSample: herokuapp.com/user/addUser
requestParams: -
requestBody: {
    name : String,
    surname: String ,
    username : String,
    password : String
}
````

### Response

````
{
    "id": "63b35da8ae54bb66978390d7",
    "name": "Halide Edip",
    "surname": "Adıvar",
    "username": "halide123",
    "createDate": "2023-01-02T22:41:44.119+00:00",
    "deleted": false
}
````

---

## Update User

### Request

````
method: POST
url: /user/updateUser
requestSample: herokuapp.com/user/updateUser
requestParams: -
requestBody: {
    id : String,
    name : String,
    surname: String ,
    username : String,
    password : String
}
````

### Response

````
{
    "id": "63b35da8ae54bb66978390d7",
    "name": "Halide Edip",
    "surname": "Adıvar",
    "username": "halide123",
    "createDate": "2023-01-02T22:41:44.119+00:00",
    "deleted": false
}
````

---


## Delete User

### Request

````
method: POST
url: /user/deleteUser
requestSample: herokuapp.com/user/deleteUser
requestParams: id : String
requestBody: {}

````

### Response

````
user deleted.

````

---

## Get FoodById

### Request

````
method: GET
url: /food/getFoodById
requestSample: herokuapp.com/food/getFoodById
requestParams: id : String
requestBody: {}
````

### Response

````
{
    "id": "63ab500778e76b190fcb94e6",
    "name": "çakallı menemeni",
    "ingredients": [
        "63ab33d1b46fb044740a567d",
        "63ab3645c86ef74732789e08",
        "63ab369ec86ef74732789e0a"
    ],
    "pictureURL": "https://d17wu0fn6x6rgz.cloudfront.net/img/w/tarif/mgt/ykvmayiswebsite23.webp",
    "recipe": "1. Yumurtaları tuz ve karabiberi bir kase çerinde el çırpıcısı veya bir çatal yardımıyla birbirine karıştırın. Kenarda bekletin. \n  2. Sıvı yağı pişirme tavasına alın, kısık ateşte ısıtın. 3. Eğer soğan ekleyecek iseniz soğanı yemeklik doğrayın ve tavaya alarak 4-5 dakika kavurun. Soğan eklemeyecek iseniz bu adımı atlayarak bir sonraki adıma geçin.4. Sivri biberleri yarıya keserek önce tohumlarını çıkarın sonra ince ince doğrayın ve tavaya alarak soğanlarla birlikte yumuşayıncaya kadar kavurun.5. Domateslerin kabuklarını soyun, küp şeklinde doğrayın. Domatesleri de tavaya alın ve suyunu çekinceye kadar pişirin.6. Fazla suyunu çektikten sonra önceden karıştırıp hazırladığınız yumurtayı da kavrulan sebzelerin üzerine dökün.7. Biraz karıştırarak yumurtaların sebzelere eşit dağılımını sağlayın.8. Birkaç dakika daha pişirin.Menemen hazır, arzunuza göre üzerine pul biber ekleyerek, sıcak servis yapın. Afiyet olsun.",
    "foodCategory": "63ab3645c86ef74732789e08",
    "createDate": "2022-12-27T20:05:27.577+00:00",
    "deleted": false
}
````

---

## Get FoodByName

### Request

````
method: GET
url: /food/getFoodByName
requestSample: herokuapp.com/food/getFoodByName
requestParams: name : String
requestBody: {}
````

### Response

````
{
    "id": "63ab500778e76b190fcb94e6",
    "name": "çakallı menemeni",
    "ingredients": [
        "63ab33d1b46fb044740a567d",
        "63ab3645c86ef74732789e08",
        "63ab369ec86ef74732789e0a"
    ],
    "pictureURL": "https://d17wu0fn6x6rgz.cloudfront.net/img/w/tarif/mgt/ykvmayiswebsite23.webp",
    "recipe": "1. Yumurtaları tuz ve karabiberi bir kase çerinde el çırpıcısı veya bir çatal yardımıyla birbirine karıştırın. Kenarda bekletin. \n  2. Sıvı yağı pişirme tavasına alın, kısık ateşte ısıtın. 3. Eğer soğan ekleyecek iseniz soğanı yemeklik doğrayın ve tavaya alarak 4-5 dakika kavurun. Soğan eklemeyecek iseniz bu adımı atlayarak bir sonraki adıma geçin.4. Sivri biberleri yarıya keserek önce tohumlarını çıkarın sonra ince ince doğrayın ve tavaya alarak soğanlarla birlikte yumuşayıncaya kadar kavurun.5. Domateslerin kabuklarını soyun, küp şeklinde doğrayın. Domatesleri de tavaya alın ve suyunu çekinceye kadar pişirin.6. Fazla suyunu çektikten sonra önceden karıştırıp hazırladığınız yumurtayı da kavrulan sebzelerin üzerine dökün.7. Biraz karıştırarak yumurtaların sebzelere eşit dağılımını sağlayın.8. Birkaç dakika daha pişirin.Menemen hazır, arzunuza göre üzerine pul biber ekleyerek, sıcak servis yapın. Afiyet olsun.",
    "foodCategory": "63ab3645c86ef74732789e08",
    "createDate": "2022-12-27T20:05:27.577+00:00",
    "deleted": false
}
````

---


## Get AllFoods

### Request

````
method: GET
url: /food/getAllFoods
requestSample: herokuapp.com//food/getAllFoods
requestParams: - 
requestBody: {
  "page" : int,
  "size" : int,
  "sortBy" : String
}
````

### Response

````
{
    "content": [
        {
            "id": "63ad91ec84648733f12ae01f",
            "name": "menemen",
            "ingredients": [
                "63ab366fc86ef74732789e09",
                "63ab33d1b46fb044740a567d"
            ],
            "pictureURL": "https://d17wu0fn6x6rgz.cloudfront.webp",
            "recipe": "suyunu çekinceye kadar pişi dakika daha pişirin.Menemen hazır, arzunuza göre üzerine pul biber ekleyerek, sıcak servis yapın. Afiyet olsun.",
            "createDate": "2022-12-29T13:11:08.582+00:00",
            "deleted": false
        },
     ...
     ]
}     
````

---

## Add Food

### Request

````
method: POST
url: /food/addFood
requestSample: herokuapp.com/food/addFood
requestParams: -
requestBody: {
    {
    "name": "bolognese makarna",
    "ingredients":["63ab366fc86ef74732789e09","63ab33d1b46fb044740a567d"],
    "foodCategory": ["63ab366fc86ef74732789e09","63ab33d1b46fb044740a567d"]
    "pictureURL":"https://d17wu0fn6x6rgz.cloudfront.webp",
    "recipe":"food recipe"
}
}
````

### Response

````
{
    "id": "63b362c4ae54bb66978390d8",
    "name": "bolognese makarna",
    "ingredients": [
        "63ab366fc86ef74732789e09",
        "63ab33d1b46fb044740a567d"
    ],
    "pictureURL": "https://d17wu0fn6x6rgz.cloudfront.webp",
    "recipe": "food recipe",
    "foodCategory": [
        "63ab366fc86ef74732789e09",
        "63ab33d1b46fb044740a567d"
    ],
    "createDate": "2023-01-02T23:03:32.471+00:00",
    "deleted": false
}
````

---

## Update Food

### Request

````
method: POST
url: /food/updateFood
requestSample: herokuapp.com/food/updateFood
requestParams: -
requestBody: {
    {
    "name": "bolognese makarna",
    "ingredients":["63ab366fc86ef74732789e09","63ab33d1b46fb044740a567d"],
    "foodCategory": ["63ab366fc86ef74732789e09","63ab33d1b46fb044740a567d"]
    "pictureURL":"https://d17wu0fn6x6rgz.cloudfront.webp",
    "recipe":"food recipe"
}
}
````

### Response

````
{
    "id": "63b362c4ae54bb66978390d8",
    "name": "bolognese makarna",
    "ingredients": [
        "63ab366fc86ef74732789e09",
        "63ab33d1b46fb044740a567d"
    ],
    "pictureURL": "https://d17wu0fn6x6rgz.cloudfront.webp",
    "recipe": "food recipe",
    "foodCategory": [
        "63ab366fc86ef74732789e09",
        "63ab33d1b46fb044740a567d"
    ],
    "createDate": "2023-01-02T23:03:32.471+00:00",
    "deleted": false
}
````

---

## Delete Food

### Request

````
method: POST
url: /food/deleteFood
requestSample: herokuapp.com/food/deleteFood
requestParams: id : String
requestBody: {}
````

### Response

````

food deleted.

````

---


## Get IngredientCategoryById

### Request

````
method: GET
url: /ingredientCategory/getIngredientCategoryById
requestSample: herokuapp.com/ingredientCategory/getIngredientCategoryById
requestParams: -
requestBody: {
  id : String
}

````

### Response

````
{
    "id": "63ade62577f797086d8f44eb",
    "name": "süt ve süt ürünleri",
    "deleted": false
}

````

---

## Get AllIngredientCategories

### Request

````
method: GET
url: /ingredientCategory/getAllIngredientCategories
requestSample: herokuapp.com/ingredientCategory/getAllIngredientCategories
requestParams: -
requestBody: {
  "page" : int,
  "size" : int,
  "sortBy" : String
}

````

### Response

````
{
    "content": [
        {
            "id": "63ade62b77f797086d8f44ec",
            "name": "baharat",
            "deleted": false
        },
        {
            "id": "63ade61677f797086d8f44ea",
            "name": "bakliyat",
            "deleted": false
        },
        ...
        ]
}

````

---

## Add IngredientCategory

### Request

````
method: POST
url: /ingredientCategory/addIngredientCategory
requestSample: herokuapp.com/ingredientCategory/addIngredientCategory
requestParams: -
requestBody: 
{
    "name": String,
}
````

### Response

````
{
    "id": "63ade66277f797086d8f44f0",
    "name": "tatlılar",
    "deleted": false
}
````

---

## Update IngredientCategory

### Request

````
method: POST
url: /ingredientCategory/updateIngredientCategory
requestSample: herokuapp.com/ingredientCategory/updateIngredientCategory
requestParams: -
requestBody: 
{
    "id" : String,
    "name": String
}
````

### Response

````
{
    "id": "63ade66277f797086d8f44f0",
    "name": "tatlılar",
    "deleted": false
}
````

---

## Delete IngredientCategory

### Request

````
method: POST
url: /ingredientCategory/deleteIngredientCategory
requestSample: herokuapp.com/ingredientCategory/deleteIngredientCategory
requestParams: -
requestBody: 
{
    "id" : String,
}
````

### Response

````
{
    ingredient category deleted.
}
````

---


## Get FoodCategoryById

### Request

````
method: GET
url: /foodCategory/getFoodCategoryById
requestSample: herokuapp.com/foodCategory/getFoodCategoryById
requestParams: -
requestBody: {
  id : String
}

````

### Response

````
{
    "id": "63ade62577f797086d8f44eb",
    "name": "ana yemekler",
    "deleted": false
}

````

---

## Get AllFoodCategories

### Request

````
method: GET
url: /foodCategory/getAllFoodCategories
requestSample: herokuapp.com//foodCategory/getAllFoodCategories
requestParams: -
requestBody: {
  "page" : int,
  "size" : int,
  "sortBy" : String
}

````

### Response

````
{
    "content": [
        {
            "id": "63b32b2d9618550cd16b31bb",
            "name": "ana yemekler",
            "deleted": false
        },
        {
            "id": "63b32b359618550cd16b31bc",
            "name": "atıştırmalık",
            "deleted": false
        },
       ...
       ]
}

````

---

## Add FoodCategory

### Request

````
method: POST
url: /foodCategory/addFoodCategory
requestSample: herokuapp.com/foodCategory/addFoodCategory
requestParams: -
requestBody: 
{
    "name": String,
}
````

### Response

````
{
    "id": "63ade66277f797086d8f44f0",
    "name": "tatlılar",
    "deleted": false
}
````

---

## Update IngredientCategory

### Request

````
method: POST
url: /foodCategory/addFoodCategory
requestSample: herokuapp.com/foodCategory/addFoodCategory
requestParams: -
requestBody: 
{
    "id" : String,
    "name": String
}
````

### Response

````
{
    "id": "63ade66277f797086d8f44f0",
    "name": "tatlılar",
    "deleted": false
}
````

---

## Delete IngredientCategory

### Request

````
method: POST
url: /foodCategory/deleteFoodCategory
requestSample: herokuapp.com/foodCategory/deleteFoodCategory
requestParams: -
requestBody: 
{
    "id" : String,
}
````

### Response

````
{
    food category deleted.
}
````

---

