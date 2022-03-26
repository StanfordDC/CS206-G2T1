package com.example.demo.Business;

import java.util.List;

public interface BusinessService {
    List<Business> getAllBusinesses();

    List<Business> getBusinessesByMid(Long mid);

    Business getBusinessById(Long businessId) throws BusinessNotFoundException;

    Business getBusinessByUEN(String UEN) throws BusinessNotFoundException;

    Business addBusiness(Business business) throws BusinessAlreadyRegisteredException;
}
