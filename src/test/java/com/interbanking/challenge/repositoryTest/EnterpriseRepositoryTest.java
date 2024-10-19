package com.interbanking.challenge.repositoryTest;

import com.interbanking.challenge.domain.model.Enterprise;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseRepositoryTest {

    public static Enterprise createEnterprise() {

        return Enterprise.builder()
                .companyName("test")
                .cuit("302399988801")
                .build();
    }

    public static List<Enterprise> listEnterprises() {
        List<Enterprise> enterprises = new ArrayList<>();
        enterprises.add(createEnterprise());
        return enterprises;
    }
}
