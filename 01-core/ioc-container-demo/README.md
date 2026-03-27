# IoC Container Demo

## SIMPLE DEFINITION
IoC means Spring controls object creation.

## STEP-BY-STEP EXPLANATION
- STEP 1: We create interface `PaymentService`.
- STEP 2: We create `UPIService` and `CardService`.
- STEP 3: Spring sees `@Component` and creates both objects.
- STEP 4: Spring gives objects to `PaymentController`.
- STEP 5: `/upi` calls method in `UPIService`.
- STEP 6: `/card` calls method in `CardService`.

## REAL LIFE EXAMPLE
In a classroom, teacher gives books to students.  
Students do not create books.  
Spring also gives objects to classes.

## WHAT WE LEARNED
- IoC means Spring makes objects.
- DI means Spring gives objects to another class.
- Controller does not create objects with `new`.
- API call -> controller -> service method -> response.
