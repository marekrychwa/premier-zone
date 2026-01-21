package com.pl.premier_zone.network;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/network")
public class DnsController {

    @GetMapping("/dns/{domain}")
    public List<String> resolveDomain(@PathVariable String domain) throws Exception {
        InetAddress[] addresses = InetAddress.getAllByName(domain);

        return Arrays.stream(addresses)
                .map(InetAddress::getHostAddress)
                .collect(Collectors.toList());
    }
}