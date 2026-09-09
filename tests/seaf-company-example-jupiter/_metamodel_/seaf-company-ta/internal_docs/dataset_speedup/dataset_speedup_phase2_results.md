# Dataset benchmark

- Date: 2026-02-22T22:09:14
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 2469.5 | 2915.7 | 3190.8 | 3203.7 | OK |
| `seaf.company.ds.ta.all_objects` | 510 | 388462 | 2975.2 | 3093.4 | 3669.3 | 3740.1 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1626.5 | 1749.4 | 1898.8 | 1924.4 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 40 | 5984 | 729.0 | 965.7 | 1036.5 | 1053.3 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 20 | 3592 | 422.0 | 438.9 | 450.2 | 450.9 | OK |
| `seaf.company.ds.ta.servers` | 33 | 30700 | 302.3 | 324.7 | 342.2 | 346.3 | OK |
| `seaf.company.ds.ta.network_components` | 115 | 94362 | 362.8 | 372.9 | 402.8 | 407.9 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 52435 | 1967.4 | 2255.3 | 2744.8 | 2786.0 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 9594 | 2219.8 | 2312.7 | 3009.6 | 3143.2 | OK |
