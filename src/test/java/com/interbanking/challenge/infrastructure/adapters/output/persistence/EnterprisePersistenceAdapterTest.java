package com.interbanking.challenge.infrastructure.adapters.output.persistence;

import com.interbanking.challenge.domain.model.Enterprise;
import com.interbanking.challenge.repositoryTest.EnterpriseRepositoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class EnterprisePersistenceAdapterTest {


    @Mock
    private EnterprisePersistenceAdapter enterpriseRepository;

    @Test
    void givenEnterprisePersistenceAdapter_whenAddEnterpriseEntity_thenOK() {
        // given
        String name = "test";

       Mockito.when(enterpriseRepository.membership(any())).thenReturn(EnterpriseRepositoryTest.createEnterprise());

        // when
        Enterprise found = enterpriseRepository.membership(EnterpriseRepositoryTest.createEnterprise());

        // then
        // AssertJ
        assertThat(found.getCompanyName()).isEqualTo(name);
    }

    @Test
    void givenEnterprisePersistenceAdapter_whenLatestAdditionsEnterpriseEntity_thenOK() {
        // given
        String name = "test";

        Mockito.when(enterpriseRepository.latestAdditions()).thenReturn(EnterpriseRepositoryTest.listEnterprises());

        List<Enterprise> enterpriseList = enterpriseRepository.latestAdditions();

        // then
        // AssertJ
        assertThat(enterpriseList.get(0).getCompanyName()).isEqualTo(name);
    }

    @Test
    void givenEnterprisePersistenceAdapter_whenLatestTransfersEnterpriseEntity_thenOK() {
        // given
        String name = "test";

        Mockito.when(enterpriseRepository.latestTransfers()).thenReturn(EnterpriseRepositoryTest.listEnterprises());

        List<Enterprise> enterpriseList = enterpriseRepository.latestTransfers();

        // then
        // AssertJ
        assertThat(enterpriseList.get(0).getCompanyName()).isEqualTo(name);
    }
}
