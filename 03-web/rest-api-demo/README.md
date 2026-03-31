# Rest Api Demo (Beginner Notes)

## WHAT IS REST API
REST API is a way to get data using a URL.
Example: `GET /hello`

## WHAT IS CONTROLLER
Controller is a class that answers HTTP requests.
When browser calls an endpoint, Spring calls the controller method.

## HOW REQUEST WORKS
1. Browser calls `GET /hello`
2. Spring finds `@GetMapping("/hello")` method
3. Spring runs that method
4. The returned string goes back to browser

## SIMPLE EXAMPLES
- `GET /hello` -> `HELLO WORLD`
- `GET /student` -> `HELLO STUDENT`
- `GET /java` -> `JAVA IS WORKING`

## WHAT WE LEARNED
- `@RestController` means controller returns data as response.
- `@GetMapping` connects URL to Java method.
