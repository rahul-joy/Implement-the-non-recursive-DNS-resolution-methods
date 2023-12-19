package nonrecursivednsquery;

import java.util.List;
import java.util.ArrayList;

class DNSRecord {
    private String domain;
    private String ipAddress;

    public DNSRecord(String domain, String ipAddress) {
        this.domain = domain;
        this.ipAddress = ipAddress;
    }

    String getDomain() {
        return domain;
    }

    String getIpAddress() {
        return ipAddress;
    }
}

public class NonRecursiveDNSQuery {
    private List<DNSRecord> dnsRecords;

    public NonRecursiveDNSQuery() {
        dnsRecords = new ArrayList<>();

        dnsRecords.add(new DNSRecord("example.com", "192.168.10.1"));
        dnsRecords.add(new DNSRecord("sample.com", "192.168.10.2"));
    }

    public String findIpAddress(String domain) {
        for (DNSRecord record : dnsRecords) {
            if (record.getDomain().equals(domain)) {
                return record.getIpAddress();
            }
        }

        return "Not found!";
    }

    public static void main(String[] args) {
        NonRecursiveDNSQuery query = new NonRecursiveDNSQuery();

        System.out.println("example.com: " + query.findIpAddress("example.com"));
        System.out.println("\ngreen.com: " + query.findIpAddress("green.com"));
    }
}
