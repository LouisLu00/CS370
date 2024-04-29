# Pantry Pal 
Our project goal is to create a user-friendly website that helps users to organize food in their fridges. Also, recommend food recipes according to their previous choice.

## Features
- Virtual Fridge: The virtual fridge allows you to store and organize your ingredients. You can add items through image recognition or manual input, and it records each ingredient's quantity and expiration date. It reminds you when your food is nearing its expiration, helping to reduce waste.
- Automatic Recipe Generation: Our website can automatically generate recipes based on the contents of your virtual fridge. This feature provides you with meal ideas that use the ingredients you already have, making meal planning and cooking more efficient.
- Personalized Recipe Recommendations: Using your past choices, the website offers personalized recipe recommendations. This feature suggests meals that align with your preferences, enhancing your cooking experience with tailored suggestions.
- Image Recognition: Our website leverages AWS Rekognition to allow users to add ingredients to their virtual fridge by taking quick snapshots or uploading images of the ingredients. This image recognition feature makes it quick and easy to upload food data without manual entry, enabling a smoother user experience. It enhances the speed and accuracy of adding ingredients, helping to keep your virtual fridge up-to-date with minimal effort.
- User Registration and Login: Our website offers a seamless registration and login process. Users can create an account to access personalized features like a virtual fridge and tailored recipe recommendations. Our JWT authentication ensures secure user login and registration.

## Front-end 

## Back-end
Our project uses the Java SpringBoot framework. All the backend codes are stored in: `./Backend` following the Spring Boot structure 

- `./Backend/java`: Backend Java Code
  -  `./Backend/java/FridgeEndApplication.java`: Main function to run the whole application backend 
  -  `./Backend/java/controller`: 
  -  `./Backend/java/domain`: Define the structure of four entities: Users, Fridges, Ingredients, and Recipes
  -  `./Backend/java/repository` Define Data Access Operations
  -  `./Backend/java/service`:
  

## Scraping
The scraping code is stored in: `./Scraping`
Currently, our project used  `https://www.food.com/` to get the recipe information.  

- `config.ini`: Stores the configuration parameters for the scraping process, including the URL, page range, and output file name.
- `food_scraper.py`: Contains the scraping methods.
- `recipe.py`: Defines the data structure of the `Recipe` object.
- `file_storage.py`: Serializes the scraped data into a pickle object, which will later be imported into a PostgreSQL database.

Currently, our project uses `https://foodb.ca/` to get ingredient information.
- `config.ini`: Configuration for scraping, including base URL, page range, and output file.

- `ingredient_scraper.py`: Web scraping logic to fetch and parse ingredient details from web pages, utilizing `requests` and `BeautifulSoup`.

- `ingredient.py`: Data structure for `Ingredient` objects, detailing name, scientific name, food group, food subgroup, and image URL.

- `file_storage.py`: File management for serializing and deserializing `Ingredient` objects to/from a pickle file for persistent data storage.

## Database
- `fridge_app.sql`: Keep track of the current database structure and data inside
- `Scrapping Results`: Save pickle file of the scarp results 





