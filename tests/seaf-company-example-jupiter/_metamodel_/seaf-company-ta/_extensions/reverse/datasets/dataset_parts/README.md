# Reverse TA dataset_parts

This folder groups reverse datasets by source type. The entry point is `root.yaml` which imports all dataset parts.

Structure:
- `advanced/` — reverse datasets for cloud/advanced reverse (SEAF1 reverse models).
- `vmware_onprem/` — reverse datasets for VMware On‑Prem.

Datasets and purpose:

advanced
- `clusters.yaml` — reverse clusters (DMSS/RDSS) mapping to SEAF2 compute services.
- `dc_az.yaml` — reverse AZ mapping to SEAF2 dc_azs.
- `dc_regions.yaml` — reverse regions mapping to SEAF2 dc_regions.
- `dcs.yaml` — reverse datacenters mapping to SEAF2 dcs.
- `elb_network_components.yaml` — reverse ELB network components mapping to SEAF2 network components.
- `elbs.yaml` — reverse ELB services mapping to SEAF2 compute services.
- `k8s.yaml` — reverse Kubernetes services mapping to SEAF2 k8s.
- `logical_links.yaml` — reverse logical links mapping to SEAF2 logical_links.
- `monitoring.yaml` — reverse monitoring services mapping to SEAF2 monitoring.
- `nat_gateways.yaml` — reverse NAT gateways mapping to SEAF2 network components.
- `network_components.yaml` — reverse network devices mapping to SEAF2 network components.
- `network_segments.yaml` — reverse network segments mapping to SEAF2 network_segments.
- `networks.yaml` — reverse networks mapping to SEAF2 networks.
- `servers.yaml` — reverse servers mapping to SEAF2 servers.
- `storage.yaml` — reverse storage services mapping to SEAF2 storages/hw_storages.
- `virtualization.yaml` — reverse virtualization clusters mapping to SEAF2 cluster_virtualizations.
- `vpn_gateways.yaml` — reverse VPN gateways mapping to SEAF2 network components.

vmware_onprem
- `vmware_cluster_virtualizations.yaml` — VMware cluster (single) mapping to SEAF2 cluster_virtualizations.
- `vmware_dcs.yaml` — VMware DCs mapping to SEAF2 dcs (deduped at seaf1 ID).
- `vmware_network_components.yaml` — VMware vSwitches mapping to SEAF2 network components.
- `vmware_network_segments.yaml` — default VMware segments per DC mapping to SEAF2 network_segments.
- `vmware_networks.yaml` — VMware networks mapping to SEAF2 networks.
- `vmware_servers.yaml` — VMware VMs and hosts mapping to SEAF2 servers.
