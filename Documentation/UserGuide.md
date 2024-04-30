# User Guide: Running the Program Locally and Reproducing Results

This user guide provides step-by-step instructions on how to set up, run the program locally, and reproduce the results.

## Prerequisites

Before you begin, ensure you have the following installed:
- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - Ensure you download the correct version for your operating system.
- [Git](https://git-scm.com/downloads) - Required for version control and source code management.
- [Node.js and NPM](https://nodejs.org/en/download/) - Necessary for running and managing JavaScript forntend runtime environments.
- [MySQL Workbench and MySQL Community Server](https://dev.mysql.com/downloads/) - For database management and development.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) - Recommended IDE for editing and running the source code.
- [Visual Studio Code](https://code.visualstudio.com/download) - A lightweight but powerful source code editor for running the front end.


## Run the Backend
Follow these steps to set up and run the backend of the application:

1. **Clone the Repository**:
   Start by cloning the repository to your local machine using Git.

2. **Set Up the Database**:
   - Open MySQL Workbench and create a new schema named `fridge_app`.
   - Run the SQL script located at `Database\fridge_app.sql` to set up your database tables and initial data.

3. **Configure the Project**:
   - Open the `\Backend` directory as a project in IntelliJ IDEA.
   - Build the project to resolve dependencies and prepare for execution.

4. **Update Configuration Files**:
   - Navigate to `Backend/src/main/resources/application.properties`.
   - Fill in your SQL server password and AWS keys to ensure all external services are correctly configured.

5. **Run the Application**:
   - Execute the file `Backend/src/main/java/com/end/fridge/FridgeEndApplication.java` to start the backend server.
   - The server should now be running, typically accessible via `http://localhost:8080` or another port defined in your `application.properties`.



## Run the frontend 
Follow these steps to set up and run the frontend of the application:
1. Open the `\frontend` directory in Visual Studio Code or your preferred code editor.
2. Open a terminal within the code editor or use your system's command line.
3. Execute the following commands to install dependencies and start the frontend server:
   ```bash
   npm install       # Install project dependencies
   npm run dev       # Start the development server
