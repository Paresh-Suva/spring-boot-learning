# Request Handling Demo (Beginner Notes)

## WHAT IS REST API (SHORT)
Request handling means: Spring reads data from URL or body and gives it to our code.

## WHAT WE LEARNED
- `@PathVariable` reads data from URL path.
- `@RequestParam` reads data from URL query.
- `@RequestBody` reads data from JSON body.
- Controller method returns a simple string response.

## REAL LIFE EXAMPLE
You open a website page with a name.
The URL contains the name.
The server reads the name and returns a message.

## SIMPLE API CALLS
- `GET /name` -> `HELLO USER`
- `GET /name/alice` -> `HELLO alice`
- `GET /age?value=20` -> `AGE IS 20`
- `POST /student` with JSON ->
  `{"name":"Sam","age":12}`
  -> `STUDENT RECEIVED`
