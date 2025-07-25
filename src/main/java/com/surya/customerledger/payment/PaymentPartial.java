package com.surya.customerledger.payment;

import com.surya.customerledger.basePack.BasePackPartial;

import java.time.Instant;

public interface PaymentPartial {
  Integer getId();

  BasePackPartial getCurrentPack();

  Boolean getIsMigration();

  BasePackPartial getTo();

  Integer getLcoPrice();

  Integer getCustomerPrice();

  Instant getDate();
}
