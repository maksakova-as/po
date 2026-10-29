package helpers;

public enum RegistersPages{
    BACKUP_FIND_PAGE("Backup Policies"),
    CLOUD_FIND_PAGE("Cloud Container Engines"),
    DISTRIBUTED_FIND_PAGE("Distributed Message Services"),
    ELASTIC_CLOUD_FIND_PAGE("Elastic Cloud Servers"),
    ELASTIC_IPs_FIND_PAGE("Elastic IPs"),
    ELASTIC_LOAD_FIND_PAGE("Elastic Load Balancers"),
    NAT_GATEWAYS_FIND_PAGE("NAT Gateways"),
    PEERING_FIND_PAGE("Peerings"),
    RELATIONAL_DB_FIND_PAGE("Relational Database Services"),
    SECURITY_GROUPS_FIND_PAGE("Security Groups"),
    VPC_FIND_PAGE("VPC Subnets"),
    VPN_FIND_PAGE("VPN Gateways"),

    BACKUP_PAGE("//*[text()[normalize-space(.)='Backup Policies']]"),
    CLOUD_PAGE("//*[text()[normalize-space(.)='Cloud Container Engines']]"),
    DISTRIBUTED_PAGE("//*[text()[normalize-space(.)='Distributed Message Services']]"),
    ELASTIC_CLOUD_PAGE("//*[text()[normalize-space(.)='Elastic Cloud Servers']]"),
    ELASTIC_IPs_PAGE("//*[text()[normalize-space(.)='Elastic IPs']]"),
    ELASTIC_LOAD_PAGE("//*[text()[normalize-space(.)='Elastic Load Balancers']]"),
    NAT_GATEWAYS_PAGE("//*[text()[normalize-space(.)='NAT Gateways']]"),
    PEERING_PAGE("//*[text()[normalize-space(.)='Peerings']]"),
    RELATIONAL_DB_PAGE("//*[text()[normalize-space(.)='Relational Database Services']]"),
    SECURITY_GROUPS_PAGE("//*[text()[normalize-space(.)='Security Groups']]"),
    VPC_PAGE("//*[text()[normalize-space(.)='VPC Subnets']]"),
    VPN_PAGE("//*[text()[normalize-space(.)='VPN Gateways']]"),

    POLICY_NAME("//td[text()[normalize-space(.)='Weekly_Backups']]"),
    POLICY_GOAL("//td[text()[normalize-space(.)='backup']]"),
    POLICY_STATUS("//td[text()[normalize-space(.)='true']]"),

    CLOUD_CLUSTER_NAME("//*[text()[normalize-space(.)='cce-test']]"),
    CLOUD_FLAVOR("//td[text()[normalize-space(.)='cce.s1.small']]"),
    CLOUD_AUTH("//td[text()[normalize-space(.)='rbac']]"),

    DISTRIBUTED_CLUSTER_NAME("//*[text()[normalize-space(.)='dms-rabbitmq-test']]"),
    DISTRIBUTED_SPECIFICATION("//td[text()[normalize-space(.)='2vCPUs 4GB']]"),
    DISTRIBUTED_VPC("//td[text()[normalize-space(.)='vpc-internal']]"),

    ELASTIC_SERVER_NAME("//*[text()[normalize-space(.)='ecs-prod-someserver1']]"),
    ELASTIC_OS("//td[text()[normalize-space(.)='Linux']]"),
    ELASTIC_SUBNET("//td[text()[normalize-space(.)='subnet-Prod']]"),

    ELASTIC_PERFOMANCE("//td[text()[normalize-space(.)='5_bgp']]"),
    ELASTIC_PORT_ID("//td[text()[normalize-space(.)='964279e7-a83a-4555-a944-e357699a1b10']]"),
    ELASTIC_TENANT_ID("//td[text()[normalize-space(.)='9f7dcs8823ed23e9cwe223ecwe22236']]"),

    ELASTIC_NAME("//*[text()[normalize-space(.)='elb-ingress-test']]"),
    ELASTIC_LISTENERS("//td[text()[normalize-space(.)='listener-1b3e-TCP80']]"),
    ELASTIC_POOL("//td[text()[normalize-space(.)='server_group-1 ()']]"),

    NAT_NAME("//*[text()[normalize-space(.)='nat-gateway']]"),
    NAT_SUBNET("//td[text()[normalize-space(.)='subnet-Prod']]"),
    NAT_VPC("//td[text()[normalize-space(.)='vpc-internal']]"),

    PEERING_NAME("//*[text()[normalize-space(.)='peering-Internal-External']]"),
    PEERING_VPC_ID("//td[text()[normalize-space(.)='d48e294f-eb6a-4352-8d73-275b7a966e90']]"),
    PEERING_STATUS("//td[text()[normalize-space(.)='ACTIVE']]"),

    RELATIONAL_DB_NAME("//*[text()[normalize-space(.)='rds-prod-postgre']]"),
    RELATIONAL_STATUS("//td[text()[normalize-space(.)='ACTIVE']]"),
    REGISTERS_TYPE("//td[text()[normalize-space(.)='PostgreSQL']]"),

    SECURITY_GROUP_NAME("//*[text()[normalize-space(.)='sg-prod']]"),
    SECURITY_GROUP_DESCRIPTION("//td[text()[normalize-space(.)='blazing fast sg']]"),
    SECURITY_GROUP_ID("//td[text()[normalize-space(.)='0fdb3e4f-c7a6-42eb-9531-552ac5006202']]"),

    VPC_ID("//td[text()[normalize-space(.)='ecogroup.berezka.ecss.e5e60a69-0653-4297-8799-ea0df4f0cacc']]"),
    VPC_NAME("//*[text()[normalize-space(.)='ecs-prod-someserver1']]"),
    VPC_SUBNET("//td[text()[normalize-space(.)='subnet-Prod']]"),

    VPN_NAME("//*[text()[normalize-space(.)='vpngw-offices']]"),
    VPN_SUBNET("//td[text()[normalize-space(.)='subnet-internet']]"),
    VPN_VPC("//td[text()[normalize-space(.)='vpc-external']]");

    private String locator;

    RegistersPages(String locator) {
        this.locator = locator;
    }

    public String getLocator(){
        return locator;
    }
}
