# Dataset benchmark

- Date: 2026-02-23T01:47:10
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 129.7 | 133.7 | 141.6 | 141.6 | OK |
| `seaf.company.ds.ta.all_objects` | 462 | 337808 | 2968.8 | 3188.9 | 3408.5 | 3447.2 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1264.8 | 1314.6 | 1354.2 | 1355.8 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 6 | 927 | 609.2 | 615.2 | 658.8 | 668.1 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 14 | 2547 | 359.7 | 363.7 | 384.8 | 387.5 | OK |
| `seaf.company.ds.ta.servers` | 33 | 30700 | 249.3 | 279.3 | 309.3 | 313.6 | OK |
| `seaf.company.ds.ta.network_components` | 105 | 85617 | 436.3 | 452.8 | 468.3 | 470.9 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 6437 | 3621.1 | 3702.1 | 3731.2 | 3732.2 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 585 | 2570.8 | 2641.0 | 2803.5 | 2813.6 | OK |
