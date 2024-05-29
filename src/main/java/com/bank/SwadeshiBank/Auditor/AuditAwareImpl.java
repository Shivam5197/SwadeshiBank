package com.bank.SwadeshiBank.Auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component(value = "AuditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {


    /**
     * @return
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Customer");
    }
}
