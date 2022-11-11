package com.everest.dating.services.general;

import com.everest.dating.models.entity.Contract;
import com.everest.dating.models.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ServiceGeneral<Contract> {

    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public Contract save(Contract contract) {
        try {
            if (!contractRepository.findById(contract.getId()).isEmpty())
                throw new SQLIntegrityConstraintViolationException("Contract Already Exists");
            return contractRepository.save(contract);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
