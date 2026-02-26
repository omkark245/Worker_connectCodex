export default function SupportPage() {
  return (
    <main className="section split">
      <section>
        <h1>How can we help you today?</h1>
        <p>Find answers about verification, payments, worker search, and customer support.</p>
        <div className="card">
          <h3>FAQ</h3>
          <p>How verification works?</p>
          <p>How do I add Razorpay payment?</p>
          <p>How to report unsafe worker?</p>
        </div>
      </section>
      <section className="card">
        <h2>Send us a message</h2>
        <form>
          <label>Name</label>
          <input placeholder="Your name" />
          <label>Email</label>
          <input placeholder="you@example.com" />
          <label>Message</label>
          <textarea rows="5" placeholder="Tell us how we can help..." />
          <button type="button">Send Message</button>
        </form>
      </section>
    </main>
  );
}
