package com.smartpay.account.repository;

import com.smartpay.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // You can add custom queries here later
}
