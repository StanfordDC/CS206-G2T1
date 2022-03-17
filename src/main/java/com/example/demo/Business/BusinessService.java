package com.example.demo.Business;

import java.util.List;
import java.util.UUID;

public interface BusinessService {
    List<Business> getAllBusinesses();

    Business getBusiness(UUID businessId) throws BusinessNotFoundException;

    Business getBusiness(String UEN) throws BusinessNotFoundException;

    Business addBusiness(Business business) throws BusinessAlreadyRegisteredException;
}
