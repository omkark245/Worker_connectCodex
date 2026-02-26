# Worker Connect (MVP Blueprint)

Worker Connect is a marketplace app where:
- **Customers** post local ads/jobs.
- **Workers** browse ads and message customers.
- **Admin** verifies workers, manages jobs/users, and monitors payments.

This repository currently contains a production-oriented **implementation blueprint** for building the app with:
- **Frontend:** React + Vite
- **Backend:** Java Spring Boot
- **Database:** MySQL (can be hosted using XAMPP stack)
- **Payments:** Razorpay

## Core Product Scope

### 1) Roles
- **Worker**
  - Create profile (skills, city/area, rating, portfolio)
  - View jobs in location
  - First 10 jobs/messages free
  - Upgrade plan (₹100) for extended messaging
  - Wallet top-up via Razorpay
- **Customer**
  - Post job/ads
  - Browse and contact workers
  - Rate worker after completion
- **Admin**
  - Verify workers (KYC/status)
  - View jobs, customers, workers
  - View payment and subscription details

### 2) High-Level Features
- Location-based job matching (city/area)
- Worker ratings and ranking
- In-app chat between customer and worker
- Subscription quota and plan upgrade
- Wallet ledger + payment tracking
- Admin moderation dashboard

## Suggested Monorepo Structure

```text
worker-connect/
  frontend/                   # React + Vite app
  backend/                    # Spring Boot app
  database/
    schema.sql                # Initial SQL schema
  docs/
    architecture.md
    api-contract.md
```

## Build Plan
1. Setup Spring Boot modules (Auth, Users, Jobs, Chat, Payments, Admin)
2. Setup React routes (Worker, Customer, Admin dashboards)
3. Integrate JWT auth and role-based guards
4. Integrate Razorpay order flow + webhook verification
5. Implement job limits and plan upgrade rules
6. Add analytics and moderation screens for admin

## Quick Start (recommended)

### Backend
- Java 17+
- Maven 3.9+
- MySQL 8+

Create DB:
```sql
CREATE DATABASE worker_connect;
```

Use `database/schema.sql` for initial table creation.

### Frontend
- Node 20+
- npm 10+

Create React app with Vite and connect to backend REST APIs in `docs/api-contract.md`.

## Security & Compliance Checklist
- Password hashing with BCrypt/Argon2
- JWT access + refresh token strategy
- Secure Razorpay webhook signature verification
- File upload validation for worker verification docs
- Audit logs for admin actions

## Next Step
Start by implementing authentication and user role onboarding, then jobs and chat, then payments/subscription and admin analytics.
