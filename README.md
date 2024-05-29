# SVT Utvecklartest Fullstack

Bygg en webbapp för att presentera olika karaktärer från “star wars”-universumet.
Frontend ska vara byggd i ReactJS, och backend i Kotlin/Java. Utöver det kan du välja teknologier fritt.

I det här repository:t finns det data om karaktärer från star wars; rymdskepp med mera. Den hittar du i `data.json`.

Vidare finns det bilder att hämta i katalogen **bilder**. De är namngivna för att matcha id för respektive entitet.
Exempel: `people/1.jpg` är bilden för people-objektet med id/nyckel: `people/1`.

Applikationen ska innehålla:

- [ ] En startsida där karaktärerna ur star wars listas
- [ ] En detaljsida där man kan läsa mer om en specifik karaktär (medverkan i filmer, rymdskepp, längd och
  ögonfärg osv)

Gör uppgiften i mån om tid och prioritera. Du får gärna utöka uppgiften med något du tycker är viktigt eller kul.
För oss är det viktiga att du kan resonera kring de val du gjort och hur du tänkt när du löst uppgiften.

Lycka till!



-----------

## Overview

Project Name is a web application designed to solve the task described above. The frontend is built using React, and the
backend is developed using Kotlin. This README provides instructions on setting up and running the project, as well as
an overview of the project structure and technologies used.

## Technologies Used

- **Frontend:**
    - React
    - React Router
    - Axios (for HTTP requests)
    - CSS/SCSS

- **Backend:**
    - Kotlin

## Prerequisites

- Node.js and npm (for frontend)
- Java 17+ (for backend)
- Maven (for backend)

## Getting Started

### Backend Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/zebra02-11/dev-test.git
   cd dev-test
    ```

2. Build the backend using bash or your IDE.

   ```bash
    mvn clean
   ```
3. Run the backend running `StarWarsApplication`

The backend should now be running at http://localhost:8080.

### Frontend Setup

1. Navigate to the frontend directory:

    ```bash
    cd web/
    ```

2. Install dependencies:

    ```bash
    npm install
    ```

3. Start the development server:
   ```bash
   npm run dev
   ```

The frontend should now be running at http://localhost:5173.


