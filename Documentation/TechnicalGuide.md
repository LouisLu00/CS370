## Front-end 


## Back-end
Our project uses the Java SpringBoot framework for the backend. All the backend codes are stored in: `./Backend` following the Spring Boot structure. The backend basically covers the core application functions using different objects. 

The 'User' object stores users' information and work togerther with JWT authentication to allow users logging in and out. The 'recipe' and 'ingredient' objects store various features of specific ingredients and recipes. The fridge objects keeps track of the different ngreidents in a user's fridge. And the recommendation result object calculates the recommended recipe based on the available ingredients in the fridge. Lastly, the preference history object collects user feedback (like or dislike for a specific recommended recipe).

- `Backend/src/main`: Backend Java Code
  -  `Backend/src/main/resources/application.properties`: Defines the necessary properties to run the program locally, such as AWS API key and local SQL server passwords
  -  `Backend/src/main/java/com/end/fridge/FridgeEndApplication.java`: Main function to run the whole application backend 
  -  `Backend/src/main/java/com/end/fridge/Controller`: Defines how the backend handles requests from the client sude
  -  `Backend/src/main/java/com/end/fridge/domain`: Defines the structure of four entities: Users, Fridges, Ingredients, Recipes, Recommendation Results and Preference History
  -  `Backend/src/main/java/com/end/fridge/repository`: Abstracts the data access layer, providing direct interaction with the database
  -  `Backend/src/main/java/com/end/fridge/service`: Builds the backend operation logic for user registration, recipe recommendation, and recording preference history
  -  `Backend/src/main/java/com/end/fridge/util`: Uses JWT authentication to verify the identity of a user by using a signed token, supporting the user logging and logging out function
  
## Database
- `fridge_app.sql`: Keep track of the current database structure and data inside
- `Scrapping Results`: Save pickle file of the scarp results

## Scraping
The scraping code is stored in: `/Scraping`
Currently, our project used  `https://www.food.com/` to get the recipe information. The soruce code are stored at  `Scraping/Recipe_Scrap`
- `config.ini`: Stores the configuration parameters for the scraping process, including the URL, page range, and output file name.
- `food_scraper.py`: Contains the scraping methods.
- `recipe.py`: Defines the data structure of the `Recipe` object.
- `file_storage.py`: Serializes the scraped data into a pickle object, which will later be imported into a PostgreSQL database.

Currently, our project uses `https://foodb.ca/` to get ingredient information. The soruce code are stored at  `Scraping/Ingredients_Scrap`
- `config.ini`: Configuration for scraping, including base URL, page range, and output file.
- `ingredient_scraper.py`: Web scraping logic to fetch and parse ingredient details from web pages, utilizing `requests` and `BeautifulSoup`.
- `ingredient.py`: Data structure for `Ingredient` objects, detailing name, scientific name, food group, food subgroup, and image URL.
- `file_storage.py`: File management for serializing and deserializing `Ingredient` objects to/from a pickle file for persistent data storage.

