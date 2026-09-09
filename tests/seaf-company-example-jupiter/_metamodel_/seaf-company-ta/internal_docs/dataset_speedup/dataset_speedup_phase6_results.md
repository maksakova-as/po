# Dataset benchmark

- Date: 2026-02-23T00:28:58
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 2252.3 | 2432.2 | 2486.9 | 2487.6 | OK |
| `seaf.company.ds.ta.all_objects` | 510 | 388462 | 2442.7 | 2539.6 | 2585.7 | 2589.9 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1012.4 | 1063.9 | 1074.9 | 1075.6 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 40 | 5984 | 621.5 | 635.4 | 653.6 | 658.1 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 20 | 3592 | 353.6 | 359.1 | 369.2 | 370.5 | OK |
| `seaf.company.ds.ta.servers` | 33 | 30700 | 247.7 | 275.9 | 292.1 | 294.5 | OK |
| `seaf.company.ds.ta.network_components` | 115 | 94362 | 288.1 | 292.0 | 304.4 | 307.2 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 52435 | 1553.1 | 1634.4 | 1681.5 | 1685.9 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 9594 | 1883.7 | 1911.2 | 2003.7 | 2013.2 | OK |
