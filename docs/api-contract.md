# API Contract (MVP)

Base URL: `/api/v1`

## Auth
- `POST /auth/register`
- `POST /auth/login`
- `POST /auth/refresh`

## Worker
- `GET /workers/me`
- `PUT /workers/me`
- `POST /workers/me/verification-docs`
- `GET /workers/jobs/feed?city=&area=&page=`
- `POST /workers/jobs/{jobId}/messages` (consumes free quota or paid quota)
- `GET /workers/subscription`
- `POST /workers/subscription/upgrade` (₹100 plan)
- `POST /workers/wallet/topup/order`
- `POST /workers/wallet/topup/confirm`

## Customer
- `POST /customers/jobs`
- `GET /customers/jobs`
- `GET /customers/jobs/{id}`
- `PUT /customers/jobs/{id}`
- `POST /customers/jobs/{id}/invite-worker/{workerId}`
- `GET /customers/conversations/{conversationId}/messages`
- `POST /customers/conversations/{conversationId}/messages`

## Public Search
- `GET /search/workers?city=&area=&skill=&sort=rating`

## Ratings
- `POST /ratings`
- `GET /workers/{workerId}/ratings`

## Admin
- `GET /admin/workers?verificationStatus=PENDING`
- `POST /admin/workers/{workerId}/verify`
- `POST /admin/workers/{workerId}/reject`
- `GET /admin/jobs`
- `GET /admin/customers`
- `GET /admin/payments`
- `GET /admin/subscriptions`

## Suggested Response Shape
```json
{
  "success": true,
  "message": "Operation successful",
  "data": {}
}
```

## Error Shape
```json
{
  "success": false,
  "message": "Validation failed",
  "errors": [
    { "field": "phone", "message": "Invalid phone number" }
  ]
}
```
