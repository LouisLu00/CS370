# Pantry Pal 
Our project goal is to create a userfriendly website that helps user to organize food in their fridge. Also, recommend food recipe according to their previous choice.

## Front-end 

## Back-end
Our project uses Java SpringBoot framework. All the backend codes are stored in: `./Backend` following Spring Boot strcture 

- `./Backend/java`: Backend Java Code
  -  `./Backend/java/FridgeEndApplication.java`: Main function to run the whole application backend 
  -  `./Backend/java/controller`: 
  -  `./Backend/java/domain` : Define the structure of four entities: Users, Fridges, Ingredients, and Recipes
  -  `./Backend/java/repository` Define Data Access Operations
  -  `./Backend/java/service`:
  

## Scraping
The scraping code is stored in: `./Scraping`
Currently, our project used  `https://www.food.com/` to get the recipe informations.  

- `config.ini`: Stores the configuration parameters for the scraping process, including the URL, page range, and output file name.
- `food_scraper.py`: Contains the scraping methods.
- `recipe.py`: Defines the data structure of the `Recipe` object.
- `file_storage.py`: Serializes the scraped data into a pickle object, which will later be imported into a PostgreSQL database.

## Database
- `fridge_app.sql`: Keep track of the current database sturcture and data inside
- `Scrapping Results`: Save pickle file of the scarp results 





