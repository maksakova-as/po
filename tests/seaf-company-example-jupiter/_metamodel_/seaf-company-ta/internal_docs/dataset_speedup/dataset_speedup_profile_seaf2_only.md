# Dataset benchmark

- Date: 2026-02-23T01:38:48
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 87.5 | 94.7 | 117.0 | 118.9 | OK |
| `seaf.company.ds.ta.all_objects` | 262 | 205748 | 2289.6 | 2409.2 | 2497.8 | 2501.2 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 1073.5 | 1088.1 | 1133.2 | 1134.3 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 6 | 927 | 557.5 | 592.6 | 604.4 | 606.8 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 14 | 2547 | 341.1 | 360.7 | 379.0 | 382.4 | OK |
| `seaf.company.ds.ta.servers` | 18 | 17310 | 222.8 | 237.7 | 244.7 | 244.9 | OK |
| `seaf.company.ds.ta.network_components` | 53 | 48115 | 358.6 | 362.3 | 387.6 | 392.3 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 6437 | 3128.8 | 3297.7 | 3335.3 | 3338.7 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 585 | 2373.3 | 2590.0 | 2680.4 | 2700.0 | OK |
