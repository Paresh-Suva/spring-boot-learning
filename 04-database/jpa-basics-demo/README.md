# JPA Basics Demo (Beginner Notes)

## WHAT IS JPA
JPA is a way to work with databases using Java classes.

## WHAT IS AN ENTITY
An entity is a Java class that matches a database table.
Spring and JPA create the table for us using settings in `application.properties`.

## WHAT THE DATABASE DOES
We use H2 (a simple in-memory database).
When you call `/save`, we save one `Student` to the database.
When you call `/all`, we read all students from the database.

## WHAT WE LEARNED
- `@Entity` maps a class to a table.
- `@Id` and `@GeneratedValue` create the primary key.
- `JpaRepository` gives simple methods like `save()` and `findAll()`.
- REST endpoints call repository methods.

## API ENDPOINTS
- `GET /save`
- `GET /all`

## SAMPLE OUTPUT
- `/save` -> `STUDENT SAVED`

