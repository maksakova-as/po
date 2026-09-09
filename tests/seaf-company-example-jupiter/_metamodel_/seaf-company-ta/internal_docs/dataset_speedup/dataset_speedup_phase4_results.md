# Dataset benchmark

- Date: 2026-02-22T23:35:33
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 2374.8 | 2483.2 | 2545.6 | 2551.4 | OK |
| `seaf.company.ds.ta.all_objects` | 510 | 388462 | 2435.6 | 2572.7 | 2784.3 | 2793.7 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1146.7 | 1206.2 | 1276.0 | 1282.3 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 40 | 5984 | 596.6 | 675.8 | 715.4 | 721.8 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 20 | 3592 | 357.6 | 362.4 | 379.3 | 380.7 | OK |
| `seaf.company.ds.ta.servers` | 33 | 30700 | 267.6 | 272.9 | 307.6 | 314.7 | OK |
| `seaf.company.ds.ta.network_components` | 115 | 94362 | 290.5 | 296.5 | 321.7 | 322.0 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 52435 | 1581.0 | 1709.0 | 1823.8 | 1830.5 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 9594 | 2053.6 | 2083.2 | 2145.0 | 2159.2 | OK |
