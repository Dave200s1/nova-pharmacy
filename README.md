🏥 nova Pharmacy API

Nova Pharmacy API is a RESTful backend application built with Spring Boot for managing pharmacy-related data such as medications, categories, suppliers, and manufacturers.

The project is designed as portfolio project, following REST principles and a clean layered architecture.

## ✨ Features
* CRUD operations for:
  * 📦 Suppliers 
  * 💊 Medication Categories 
  * 🏭 Manufacturers 
  * 💉 Drugs / Medications 

## 🛠 Tech Stack
* OpenJDK 16
* Spring Boot 2.7.x
* Spring Web
* Spring Data JPA
* SQLite
* Maven

## 🔍 Endpoints

| Method    | Endpoint                      | Description                           |
|-----------|-------------------------------|---------------------------------------|
| `POST`    | `/api/drugs/create`           | Creates a drug/medicin                |
| `GET`     | `/api/drugs/read`             | Reads all drugs/medicin avaible       |
| `PUT`     | `/api/drugs/update`           | Updates the date for a medecin        |
| `DELETE`  | `/api/drugs/delete/{name}`    | Deletes a specific drug/medicin       |
| `POST`    | `/api/categories/create`      | Creates a new category                |
| `DELETE`  | `/api/categories/delete{name}`| Deletes the created category          |

### The rest is simular for manufacturer and supplier 

## Test Data JSON
POST
/api/drugs/create

`
{
    "name": "Ibuprofen",
    "verkaufspreis": 12.75,
    "dosis": 400.0,
    "categoryId": 1,
    "companyId": 0
}
`
