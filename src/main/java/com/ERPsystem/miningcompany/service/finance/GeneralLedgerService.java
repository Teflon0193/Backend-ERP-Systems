package com.ERPsystem.miningcompany.service.finance;

import com.ERPsystem.miningcompany.Entity.finance.GeneralLedger;
import com.ERPsystem.miningcompany.Repository.finance.GeneralLedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralLedgerService {
    @Autowired
    private GeneralLedgerRepository generalLedgerRepository;

    public List<GeneralLedger> getAllGeneralLedgers() {
        return generalLedgerRepository.findAll();
    }

    public Optional<GeneralLedger> getGeneralLedgerById(Long id) {
        return generalLedgerRepository.findById(id);
    }

    public GeneralLedger saveGeneralLedger(GeneralLedger generalLedger) {
        return generalLedgerRepository.save(generalLedger);
    }

    public GeneralLedger updateGeneralLedger(Long id, GeneralLedger generalLedgerDetails) {
        GeneralLedger existingGeneralLedger = generalLedgerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("General Ledger not found with id " + id));
        existingGeneralLedger.setAccountName(generalLedgerDetails.getAccountName());
        existingGeneralLedger.setAccountType(generalLedgerDetails.getAccountType());
        existingGeneralLedger.setBalance(generalLedgerDetails.getBalance());
        return generalLedgerRepository.save(existingGeneralLedger);
    }

    public void deleteGeneralLedger(Long id) {
        generalLedgerRepository.deleteById(id);
    }
}
