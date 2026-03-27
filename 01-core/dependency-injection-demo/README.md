# Dependency Injection Demo

## SIMPLE DEFINITION
Dependency Injection means Spring gives service object to controller.

## STEP-BY-STEP EXPLANATION
- STEP 1: We create `GreetingService` and `SimpleGreetingService`.
- STEP 2: Spring sees `@Service` and creates service object.
- STEP 3: Spring gives that object to controller.
- STEP 4: API `/field`, `/setter`, `/constructor` is called.
- STEP 5: Controller calls `greet()` method.
- STEP 6: Controller returns simple response.

## REAL LIFE EXAMPLE
In school, teacher gives a notebook to student.  
Student does not make notebook at that time.  
Same way, Spring gives object to controller.

## WHAT WE LEARNED
- Spring creates service object.
- Controller uses service object.
- We can inject in 3 ways.
- API call -> controller -> service method -> response.
