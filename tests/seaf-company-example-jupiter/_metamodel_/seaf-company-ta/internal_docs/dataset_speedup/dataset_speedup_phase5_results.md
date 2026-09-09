# Dataset benchmark

- Date: 2026-02-22T23:56:12
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 2471.5 | 2479.0 | 2560.8 | 2562.6 | OK |
| `seaf.company.ds.ta.all_objects` | 510 | 388462 | 2387.8 | 2475.2 | 2605.9 | 2610.8 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1044.0 | 1092.5 | 1131.8 | 1132.9 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 40 | 5984 | 591.3 | 615.6 | 632.3 | 635.1 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 20 | 3592 | 342.0 | 361.3 | 391.5 | 398.0 | OK |
| `seaf.company.ds.ta.servers` | 33 | 30700 | 253.9 | 260.9 | 281.8 | 283.3 | OK |
| `seaf.company.ds.ta.network_components` | 115 | 94362 | 273.0 | 313.1 | 325.3 | 326.4 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 52435 | 1653.0 | 1717.3 | 1760.4 | 1762.0 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 9594 | 1948.8 | 2004.8 | 2074.1 | 2077.5 | OK |
