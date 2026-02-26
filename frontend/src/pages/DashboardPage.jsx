const jobs = [
  { title: 'Kitchen plumbing repair', area: 'Nashik Road', skill: 'Plumbing', status: 'OPEN' },
  { title: '2BHK wall painting', area: 'Indira Nagar', skill: 'Painting', status: 'OPEN' },
  { title: 'Office deep cleaning', area: 'College Road', skill: 'Cleaning', status: 'IN_PROGRESS' }
];

export default function DashboardPage() {
  return (
    <main className="section">
      <h1>Worker Dashboard</h1>
      <p>Jobs in your 10 km range based on Google Maps location coordinates.</p>
      <div className="table-wrap card">
        <table>
          <thead>
            <tr>
              <th>Job</th>
              <th>Area</th>
              <th>Skill</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {jobs.map((job) => (
              <tr key={job.title}>
                <td>{job.title}</td>
                <td>{job.area}</td>
                <td>{job.skill}</td>
                <td>{job.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </main>
  );
}
