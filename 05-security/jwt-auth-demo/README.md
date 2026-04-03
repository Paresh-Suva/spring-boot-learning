# JWT Auth Demo

## What is JWT?

JWT (JSON Web Token) is a **signed string** the server gives after login.  
The client sends it on every protected request in the **`Authorization`** header.  
The server checks the signature and reads **who** is calling **without** keeping login state in server memory (stateless).

## How login works

1. Client sends **POST /login** with username and password (JSON).
2. Server finds the user in **MySQL**, checks password with **BCrypt**.
3. If OK, server builds a **JWT** string and returns `{ "token": "..." }`.

## How the token is used

1. Client sends **GET /profile** with header:  
   `Authorization: Bearer <paste_token_here>`
2. **JwtAuthenticationFilter** reads the header, checks the token, and tells Spring **which username** is calling.
3. Controller returns JSON with that username.

## Database setup

1. Install **MySQL** and create database:

```sql
CREATE DATABASE spring_boot_db;
```

2. Edit `src/main/resources/application.properties`:

- Set `spring.datasource.password` to your MySQL root password (replace `your_password`).

3. Run **`JwtAuthDemoApplication`**.

Hibernate will create table **`users`** (from the `User` entity) when `ddl-auto=update`.

## API (JSON only)

### Register

`POST http://localhost:8080/register`

Body:

```json
{
  "username": "rahul",
  "password": "1234"
}
```

Success response (201):

```json
{
  "message": "User registered successfully"
}
```

### Login

`POST http://localhost:8080/login`

Body:

```json
{
  "username": "rahul",
  "password": "1234"
}
```

Response:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...."
}
```

### Profile (protected)

`GET http://localhost:8080/profile`  

Header:

```
Authorization: Bearer <token_from_login>
```

Response:

```json
{
  "username": "rahul",
  "message": "This is protected data"
}
```

## How to test in Postman

1. **Register** — POST `/register` with raw JSON body.
2. **Login** — POST `/login` with same user; copy **`token`** from response.
3. **Profile** — GET `/profile`, tab **Authorization** → Type **Bearer Token**, paste token **or** add header manually:  
   `Authorization` = `Bearer <token>`.

If `/profile` returns **403**, the token is missing, wrong, or expired.

## Security notes (student summary)

- Passwords are stored as **BCrypt hashes**, not plain text.
- **CSRF is disabled** because this API uses **Bearer JWT**, not browser cookie login for this demo.
- **JWT secret** must stay private in real apps (use env vars, not public repos).
