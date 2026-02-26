export default function LoginPage() {
  return (
    <main className="auth-layout">
      <section className="auth-banner">
        <div className="pill">Trusted by 50,000+ local experts</div>
        <h2>Welcome to WorkConnect</h2>
        <p>Find reliable local experts and grow your service business with verified jobs.</p>
      </section>
      <section className="auth-form card">
        <h1>Welcome back</h1>
        <p>Enter your credentials to access your account.</p>
        <form>
          <label>Email Address</label>
          <input placeholder="name@example.com" />
          <label>Password</label>
          <input placeholder="••••••••" type="password" />
          <button type="button">Sign In</button>
        </form>
      </section>
    </main>
  );
}
