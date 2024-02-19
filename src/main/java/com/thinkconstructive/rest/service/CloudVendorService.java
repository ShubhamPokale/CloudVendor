package com.thinkconstructive.rest.service;

import com.thinkconstructive.rest.model.CloudVendor;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CloudVendorService {

    //methods that you want to have in your business layer

    public String createCloudVendor(CloudVendor cloudVendor);

    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();

}
