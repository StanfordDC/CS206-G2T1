package com.example.demo.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService{
    private BusinessRepository businessRepository;

    @Autowired
    @Lazy
    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Business getBusinessById(Long businessId) throws BusinessNotFoundException {
        return businessRepository.findById(businessId)
                                 .orElseThrow(() -> new BusinessNotFoundException(businessId));
    }

    @Override
    public Business getBusinessByUEN(String UEN) throws BusinessNotFoundException {
        return businessRepository.findByUEN(UEN)
                                 .orElseThrow(() -> new BusinessNotFoundException(UEN));
    }

    @Override
    public List<Business> getBusinessesByMid(Long mid) {
        return businessRepository.findByMid(mid);
    }

    @Override
    public Business addBusiness(Business business) throws BusinessAlreadyRegisteredException {
        String UEN = business.getUEN();
        if (businessRepository.existsByUEN(UEN)) {
            throw new BusinessAlreadyRegisteredException(UEN);
        }

        return businessRepository.save(business);
    }
}
