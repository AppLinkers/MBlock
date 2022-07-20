package com.example.MBlock.repository;

import com.example.MBlock.domain.CurrencyInfo;
import com.example.MBlock.domain.type.TradingSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyInfoRepository extends JpaRepository<CurrencyInfo, Long> {

    List<CurrencyInfo> getAllByTradingSiteIs(TradingSite tradingSite);
}