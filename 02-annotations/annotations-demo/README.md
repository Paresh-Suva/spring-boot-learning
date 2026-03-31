# Annotations Demo

## WHAT IS ANNOTATION

Annotation is a small label we write above class or method.  
Spring reads these labels and does work for us.

## WHY WE USE IT

We tell Spring what each class is for.  
Then Spring creates objects and connects them without us writing `new` everywhere.

## SIMPLE EXAMPLES

- `@Component` — Spring makes one object of this class.
- `@Service` — Same idea; we use it for service-style classes.
- `@Repository` — Same idea; we use it for data-style classes.
- `@Autowired` — Spring puts the correct object into this field.
- `@RestController` — This class answers HTTP requests.

## WHAT WE LEARNED

- Annotations are instructions for Spring.
- Spring creates beans for `@Component`, `@Service`, `@Repository`.
- Controller uses `@Autowired` to get those beans.
- Calling `/component`, `/service`, `/repository` runs different methods.
