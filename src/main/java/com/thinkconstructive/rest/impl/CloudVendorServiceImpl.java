package com.thinkconstructive.rest.impl;

import com.thinkconstructive.rest.exception.CloudVendorNotFoundException;
import com.thinkconstructive.rest.model.CloudVendor;
import com.thinkconstructive.rest.repository.CloudVendorRepository;
import com.thinkconstructive.rest.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;


    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {

        cloudVendorRepository.save(cloudVendor); // data will be saved via the repository interface

        return "Created Successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {

        cloudVendorRepository.save(cloudVendor);

        return "Updated Successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {

        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
            if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            {
                throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist");

            }
        return cloudVendorRepository.findById(cloudVendorId).get();

    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {

        return cloudVendorRepository.findAll();
    }
}
