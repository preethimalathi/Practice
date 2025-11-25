
# Travel Backend (Spring Boot + MySQL)

## Overview
This is a starter backend for the Travel demo. It provides:
- User registration/login (JWT)
- Destination CRUD API
- Booking create/list API
- Admin file upload endpoint (saves to local uploads/ and served at /uploads/)
- CORS enabled for local frontend usage

## Requirements
- Java 17+
- Maven 3.8+
- MySQL server

## Setup
1. Create MySQL database:
   - Run the `schema.sql` file or create a database named `travel_db`.
2. Update `src/main/resources/application.properties` with your MySQL username/password.
3. Build and run:
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```
   The app runs on port 8080 by default.
4. Default admin created on startup: username `admin`, password `adminpass`.
5. Uploads directory: configured by `app.upload.dir` in application.properties (default `uploads`). Files uploaded to `/api/admin/upload` will be available under `/uploads/<filename>`.

## API examples
- Register: POST /api/auth/register { "username": "...", "password": "..." }
- Login: POST /api/auth/login => returns token
- List destinations: GET /api/destinations
- Create booking: POST /api/bookings { booking payload }

## Notes
- JWT secret in application.properties MUST be changed for production.
- For production, consider storing images in object storage (S3) and using HTTPS.
