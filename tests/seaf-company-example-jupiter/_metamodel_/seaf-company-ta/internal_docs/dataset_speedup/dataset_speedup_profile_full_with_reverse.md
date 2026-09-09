# Dataset benchmark

- Date: 2026-02-23T02:05:56
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 90.6 | 93.3 | 115.7 | 120.9 | OK |
| `seaf.company.ds.ta.all_objects` | 510 | 388462 | 3304.3 | 3660.6 | 3764.4 | 3770.6 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1646.3 | 1801.3 | 1803.8 | 1804.1 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 6 | 927 | 678.7 | 735.5 | 796.9 | 803.2 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 14 | 2547 | 431.7 | 450.3 | 714.8 | 747.3 | OK |
| `seaf.company.ds.ta.servers` | 33 | 30700 | 313.3 | 323.0 | 362.0 | 365.7 | OK |
| `seaf.company.ds.ta.network_components` | 115 | 94362 | 518.1 | 578.4 | 597.0 | 598.1 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 6437 | 4290.9 | 4778.2 | 4987.6 | 5013.3 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 585 | 2980.5 | 3176.8 | 3339.2 | 3340.9 | OK |
