# Architecture Design

## 1. System Components

### Frontend (React + Vite)
- Customer web app
- Worker web app
- Admin dashboard
- Shared component library + API client

### Backend (Spring Boot)
- Auth & RBAC service
- User/Profile service
- Job service
- Chat service
- Subscription & Wallet service
- Payment service (Razorpay)
- Admin moderation/reporting service

### Database (MySQL)
- Normalized relational schema
- Financial entities (wallet + payment) with immutable ledger records

## 2. Core Domain Model
- `users` (role: ADMIN, WORKER, CUSTOMER)
- `worker_profiles` (verification status, skills, city/area)
- `jobs` (posted by customers)
- `job_applications` (worker responses)
- `conversations` + `messages`
- `subscriptions` (FREE / PRO)
- `wallets` + `wallet_transactions`
- `payments` (Razorpay linkage)
- `ratings`

## 3. Business Rules
- Worker can contact customers for first **10 job interactions** on free tier.
- Worker upgrades to paid plan (**₹100**) to continue expanded messaging.
- Admin must verify worker profile before full visibility in search ranking.
- Ranking formula suggestion:
  - 40% rating score
  - 30% completed jobs
  - 30% city/area relevance

## 4. API Security
- JWT auth (access + refresh token)
- Role-based endpoint guards
- Ownership checks for data access
- Rate limit messaging APIs

## 5. Payment Flow (Razorpay)
1. Worker initiates plan upgrade / wallet top-up
2. Backend creates Razorpay order
3. Frontend opens Razorpay checkout
4. Backend verifies signature on callback/webhook
5. Mark payment SUCCESS/FAILED and update wallet/subscription atomically

## 6. Admin Dashboard Modules
- Worker verification queue
- Jobs moderation and status
- Customer and worker directory
- Payments and subscription reports
- Fraud and abuse reports

## 7. Deployment Recommendation
- Frontend: Vercel/Netlify
- Backend: Render/AWS ECS/DigitalOcean
- DB: Managed MySQL (or XAMPP local for development)
- Redis: caching/session/rate limit support
