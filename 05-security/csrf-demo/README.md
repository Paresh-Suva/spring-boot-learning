# CSRF Demo

## What is CSRF?

CSRF means a **bad website** tricks your **browser** into sending a request to **our** app.  
If your browser still has a **session cookie**, the server may think **you** wanted that action.

## Why POST failed (before)

With **CSRF turned on** (default):

- **GET /users** works. GET is a “safe” method, so Spring does not require a CSRF token for this demo flow.
- **POST /users** fails with **403 Forbidden** if you send only JSON (no CSRF token).

Spring runs a **CSRF filter** **before** your controller. It blocks the POST, so your code never runs.

## How we “fixed” it (for learning only)

We added a setting in `application.properties`:

```properties
app.security.csrf.enabled=false
```

When this is **false**, `SecurityConfig` calls `http.csrf(csrf -> csrf.disable())`.  
Then **POST /users** reaches `UserController`, the user is added to the list, and **GET /users** shows the new row.

**Important:** Turning off CSRF is only for this classroom demo. Real browser apps should keep CSRF on or use a proper API security design.

## Before vs after

| Step | CSRF ON (`true`) | CSRF OFF (`false`) |
|------|-------------------|---------------------|
| GET /users | Works — JSON list | Works — JSON list |
| POST /users (JSON only) | **403** | **201** — user added |
| GET /users again | Same list | List includes new user |

## Example JSON

**GET /users**

```json
[
  { "id": 1, "name": "Rahul" },
  { "id": 2, "name": "Amit" }
]
```

**POST /users** (request body)

```json
{ "id": 3, "name": "Neha" }
```

**POST /users** (response)

```json
{ "id": 3, "name": "Neha" }
```

If you omit `id`, the server picks the next number (starts at **3** after Rahul and Amit).

## Try with curl (port 8080)

```bash
curl -s http://localhost:8080/users
```

CSRF **on** — POST should fail:

```bash
curl -i -X POST http://localhost:8080/users ^
  -H "Content-Type: application/json" ^
  -d "{\"id\":3,\"name\":\"Neha\"}"
```

Set `app.security.csrf.enabled=false`, restart, run the same POST again — you should see **201** and JSON, then:

```bash
curl -s http://localhost:8080/users
```

should include Neha.
