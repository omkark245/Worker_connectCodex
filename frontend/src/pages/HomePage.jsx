const steps = [
  {
    title: 'Post your job with photo',
    desc: 'Customer can add title, budget, skill type, image and Google Maps location.'
  },
  {
    title: 'Workers within 10 km discover jobs',
    desc: 'Workers get local jobs for plumbing, painting, electric, cleaning and more.'
  },
  {
    title: 'Chat and hire quickly',
    desc: 'First 10 customer messages are free, then ₹10 per customer message via Razorpay.'
  },
  {
    title: 'Rate and grow trust',
    desc: 'Customer ratings help others find best verified workers in their area.'
  }
];

export default function HomePage() {
  return (
    <main>
      <section className="hero split">
        <div>
          <p className="pill">Trusted by 50,000+ local experts</p>
          <h1>Connect with the best professionals in your area.</h1>
          <p>
            Local marketplace like OLX for workers and customers. Search by skill and distance,
            post jobs, chat safely, and hire verified experts.
          </p>
          <div className="button-row">
            <button>Join WorkConnect</button>
            <button className="secondary">How it works</button>
          </div>
        </div>
        <div className="card mock-image">Worker hero image area</div>
      </section>

      <section className="section">
        <h2>Your service journey made simple</h2>
        <div className="grid-2">
          {steps.map((step, index) => (
            <article key={step.title} className="card">
              <span className="step">Step 0{index + 1}</span>
              <h3>{step.title}</h3>
              <p>{step.desc}</p>
            </article>
          ))}
        </div>
      </section>
    </main>
  );
}
