# Bean Lifecycle Demo

## SIMPLE DEFINITION
A bean is an object created by Spring.

## STEP-BY-STEP EXPLANATION
- STEP 1: We create class `MyBean`.
- STEP 2: Spring sees `@Component` and creates `MyBean` object.
- STEP 3: Spring runs `init()` method because of `@PostConstruct`.
- STEP 4: We call `/test` endpoint and controller runs.
- STEP 5: When app stops, Spring runs `destroy()` because of `@PreDestroy`.

## REAL LIFE EXAMPLE
When a shop opens, setup happens first.  
When a shop closes, cleanup happens last.  
Bean lifecycle is also like this.

## WHAT WE LEARNED
- Spring creates bean object.
- Spring runs start method and stop method.
- `@PostConstruct` runs after object creation.
- `@PreDestroy` runs before object removal.
