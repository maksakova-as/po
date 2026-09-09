# Dataset benchmark

- Date: 2026-02-22T21:53:36
- Backend: `http://127.0.0.1:8080`
- Warmup: `1`
- Runs: `5`

| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |
|---|---:|---:|---:|---:|---:|---:|---|
| `seaf.company.ds.ta.schema_r41_plural` | 40 | 381672 | 4316.1 | 4359.7 | 5196.1 | 5402.5 | OK |
| `seaf.company.ds.ta.all_objects` | 969 | 1190042 | 5123.6 | 5383.9 | 5746.3 | 5813.5 | OK |
| `seaf.company.ds.ta.kb_links` | 45 | 8355 | 4407.9 | 4552.8 | 5052.0 | 5113.4 | OK |
| `seaf.company.ds.ta.k8s_infra_objects` | 40 | 5984 | 927.7 | 979.6 | 1042.5 | 1050.5 | OK |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 20 | 3592 | 837.9 | 873.3 | 915.1 | 920.5 | OK |
| `seaf.company.ds.ta.servers` | 305 | 712269 | 697.1 | 710.5 | 890.4 | 899.8 | OK |
| `seaf.company.ds.ta.network_components` | 117 | 97951 | 424.7 | 455.5 | 498.4 | 501.3 | OK |
| `seaf.company.ds.app.systems_dependency_graph` | 17 | 56523 | 5418.3 | 5575.2 | 5883.9 | 5941.8 | OK |
| `seaf.company.ds.app.systems_deployment_topology` | 17 | 9594 | 5956.6 | 6172.1 | 6511.6 | 6578.3 | OK |
