# Pantry Pal 
Our project goal is to create a userfriendly website that helps user to organize food in their fridge. Also, recommend food recipe according to their previous choice.

## Front-end 
## Back-end

## Database 
The database creation code is stored in : `./Database`
Our project using postgres SQL database. Currently, the database consists of three schemas: users, fridges, and ingredients 
- `sequence.sql`: sequence creation code
- `tables.sql`: table initilization code 

## Scraping
The scraping code is stored in: `./Scraping`
Currently, our project used  `https://www.food.com/` to get the recipe informations.  

- `config.ini`: Stores the configuration parameters for the scraping process, including the URL, page range, and output file name.
- `food_scraper.py`: Contains the scraping methods.
- `recipe.py`: Defines the data structure of the `Recipe` object.
- `file_storage.py`: Serializes the scraped data into a pickle object, which will later be imported into a PostgreSQL database.




