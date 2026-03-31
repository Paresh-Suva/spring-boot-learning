# Spring Boot demos (IntelliJ + Maven)

## Why everything was red

IntelliJ did not load **Maven** for this folder, so Spring JARs were never downloaded.  
Also some demos used **Spring Boot 4** and **`spring-boot-starter-webmvc`**, which can fail to resolve on some PCs.

## What we fixed in this repo

1. **Root `pom.xml`** — lists all demo apps as Maven modules so one import loads everything.
2. **Spring Boot `3.4.2`** — stable on Maven Central.
3. **`spring-boot-starter-web`** and **`spring-boot-starter-test`** — usual names that always resolve.

## Open this repo in IntelliJ IDEA (important)

### Option A (best)

1. **File → Close Project** (if you already opened the folder).
2. **File → Open…**
3. Select **`D:\Spring-Boot\pom.xml`** (the file at the repo root).
4. Choose **Open as Project**.
5. Wait until the **Maven** tool window shows all modules and the progress bar finishes.

### Option B (you already opened `D:\Spring-Boot` as a folder)

1. Open the **Maven** tool window.
2. Click **Reload All Maven Projects** (circular arrows).
3. If it still says *“There are no Maven projects”*:
   - Right‑click the root **`pom.xml`** in the Project tree → **Add as Maven Project**.

## Run a demo

1. Open any `*Application.java` (for example `AnnotationsDemoApplication`).
2. Click the green **Run** gutter icon next to `main`.

Use **JDK 21** (matches `pom.xml`).

## If modules still look wrong

1. **File → Project Structure → Modules**  
   Remove any module whose **Content Root** does not contain a real **`src/main/java`** folder.  
   Then reload Maven again (step above).

## About red “JavaDoc” paths in Libraries

A missing **`-javadoc.jar`** does **not** stop compile or run. You can ignore it or turn off JavaDoc attachment for libraries in IDE settings.
