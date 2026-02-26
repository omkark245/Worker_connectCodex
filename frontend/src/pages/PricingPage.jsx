const plans = [
  { name: 'Free', price: '₹0', features: ['10 free customer messages', 'Basic worker profile'] },
  { name: 'Pro', price: '₹100 / month', features: ['Unlimited messaging', 'Priority listing'] },
  { name: 'Pay-as-you-go', price: '₹10 / message', features: ['After first 10 free messages'] }
];

export default function PricingPage() {
  return (
    <main className="section">
      <h1>Simple, Transparent Pricing</h1>
      <p>Start free, then pay only when you scale your customer outreach.</p>
      <div className="grid-3">
        {plans.map((plan) => (
          <article className="card" key={plan.name}>
            <h3>{plan.name}</h3>
            <p className="price">{plan.price}</p>
            <ul>
              {plan.features.map((feature) => (
                <li key={feature}>{feature}</li>
              ))}
            </ul>
          </article>
        ))}
      </div>
    </main>
  );
}
