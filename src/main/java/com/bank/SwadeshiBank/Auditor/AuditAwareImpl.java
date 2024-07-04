package com.bank.SwadeshiBank.Auditor;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;


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
