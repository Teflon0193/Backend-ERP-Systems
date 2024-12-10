package com.ERPsystem.miningcompany.service.finance;

import com.ERPsystem.miningcompany.Entity.finance.GeneralLedger;
import com.ERPsystem.miningcompany.Repository.finance.GeneralLedgerRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
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

    public GeneralLedger getGeneralLedgerById(Long id) {
        return generalLedgerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("General Ledger not found with id " + id));
    }

    public GeneralLedger saveGeneralLedger(GeneralLedger generalLedger) {
        return generalLedgerRepository.save(generalLedger);
    }

    public GeneralLedger updateGeneralLedger(Long id, GeneralLedger generalLedgerDetails) {
        GeneralLedger existingGeneralLedger = generalLedgerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("General Ledger not found with id " + id));

        existingGeneralLedger.setAccountName(generalLedgerDetails.getAccountName());
        existingGeneralLedger.setAccountCode(generalLedgerDetails.getAccountCode());
        existingGeneralLedger.setDebit(generalLedgerDetails.getDebit());
        existingGeneralLedger.setCredit(generalLedgerDetails.getCredit());
        existingGeneralLedger.setNetMovement(generalLedgerDetails.getNetMovement());


        return generalLedgerRepository.save(existingGeneralLedger);
    }

    public void deleteGeneralLedger(Long id) {
        GeneralLedger generalLedger = generalLedgerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("General Ledger not found with id " + id));
        generalLedgerRepository.delete(generalLedger);
    }

    // Calculate the Grand Total of Debit
    public Double getGrandTotalDebit() {
        return generalLedgerRepository.findAll()
                .stream()
                .mapToDouble(ledger -> ledger.getDebit() != null ? ledger.getDebit() : 0.0)
                .sum();
    }

    // Calculate the Grand Total of Credit
    public Double getGrandTotalCredit() {
        return generalLedgerRepository.findAll()
                .stream()
                .mapToDouble(ledger -> ledger.getCredit() != null ? ledger.getCredit() : 0.0)
                .sum();
    }
}
