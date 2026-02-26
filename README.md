# WorkConnect - Local Worker Hiring Platform

WorkConnect is a marketplace platform where customers post local jobs and workers discover and message nearby customers (similar to OLX for services).

## Tech Stack
- **Frontend:** React.js + Vite
- **Backend:** Java Spring Boot (REST API)
- **Database:** MySQL / XAMPP (`createDatabaseIfNotExist=true` enables automatic DB creation)
- **Payments:** Razorpay (stubbed order/verify API endpoints, ready for integration)
- **Maps:** Latitude/longitude matching with 10km filter (Google Maps-ready coordinates)

## Implemented Core Features
- Customer can post job ads with skill, location and image URL.
- Worker can find open jobs within a 10km radius.
- Worker messaging billing:
  - first **10 messages free**
  - then **₹10 per customer message**
- Customer can rate workers.
- Admin can:
  - view all customers, workers, jobs
  - approve workers after verification
  - block workers from login.
- Job auto-removal when marked `COMPLETED`.

## Project Structure
```text
frontend/  # React + Vite UI inspired by shared WorkConnect design
backend/   # Spring Boot API + JPA domain
database/  # SQL reference schema
docs/      # architecture and API contract references
```

## Run Frontend
```bash
cd frontend
npm install
npm run dev
```

## Run Backend
```bash
cd backend
mvn spring-boot:run
```

Backend runs at `http://localhost:8080`.

## Important API Endpoints
- `POST /api/v1/customers/jobs`
- `GET /api/v1/search/jobs-nearby?lat=..&lng=..&maxKm=10`
- `POST /api/v1/workers/messages`
- `POST /api/v1/ratings`
- `GET /api/v1/admin/workers`
- `POST /api/v1/admin/workers/{workerId}/approve`
- `POST /api/v1/admin/workers/{workerId}/block`
- `POST /api/v1/payments/razorpay/order`

## Next Recommended Steps
- Add secure JWT auth and role guards.
- Add real Razorpay signature validation and webhook updates.
- Integrate Google Maps Places autocomplete + reverse geocoding.
- Add image upload storage (S3/local storage) and cleanup scheduler.
