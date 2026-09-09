# Dataset benchmark

- Date: 2026-02-22T21:48:36
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 4095.0 | 4168.5 | 4173.9 | 4174.5 | OK |
| `seaf.company.ds.ta.all_objects` | 969 | 1190042 | 4195.3 | 4278.0 | 4443.4 | 4483.8 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 4137.9 | 4203.7 | 4362.4 | 4371.9 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 40 | 5984 | 831.0 | 858.8 | 875.7 | 876.6 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 20 | 3592 | 779.0 | 813.2 | 832.2 | 833.8 | OK |
| `seaf.company.ds.ta.servers` | 305 | 712269 | 739.5 | 762.0 | 781.1 | 782.3 | OK |
| `seaf.company.ds.ta.network_components` | 117 | 97951 | 428.0 | 445.9 | 464.3 | 467.9 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 56523 | 4376.0 | 4612.8 | 4849.0 | 4892.2 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 9594 | 4695.5 | 5060.3 | 5181.0 | 5185.3 | OK |
