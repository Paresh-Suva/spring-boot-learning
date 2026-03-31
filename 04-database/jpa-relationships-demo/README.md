# JPA Relationships Demo (Beginner Notes)

## WHAT IS JPA
JPA helps Java talk to a database using objects.

## WHAT IS A RELATIONSHIP
A relationship means tables connect to each other.
Here:
- ONE student can have MANY courses.

## HOW WE LINK DATA
We use one-to-many:
- `Student` has a list of `Course`
- `Course` points back to one `Student`

## WHAT WE LEARNED
- `@OneToMany` connects Student -> Courses
- `@ManyToOne` connects Course -> Student
- Saving Student with `cascade = ALL` also saves Courses

## API ENDPOINT
- `GET /test`

## SAMPLE OUTPUT
- `STUDENT SAVED WITH 2 COURSES`

