# Dataset benchmark

- Date: 2026-02-22T22:48:53
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 2464.5 | 2578.9 | 2989.4 | 2999.2 | OK |
| `seaf.company.ds.ta.all_objects` | 510 | 388462 | 2456.1 | 2994.4 | 3200.6 | 3203.3 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1125.1 | 1140.5 | 1209.4 | 1225.5 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 40 | 5984 | 617.4 | 657.8 | 699.7 | 704.5 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 20 | 3592 | 391.3 | 420.1 | 438.1 | 441.9 | OK |
| `seaf.company.ds.ta.servers` | 33 | 30700 | 268.3 | 283.6 | 291.9 | 292.6 | OK |
| `seaf.company.ds.ta.network_components` | 115 | 94362 | 307.8 | 312.0 | 339.6 | 342.7 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 52435 | 1691.1 | 1738.8 | 1815.2 | 1823.6 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 9594 | 2175.2 | 2436.5 | 2564.3 | 2586.0 | OK |
