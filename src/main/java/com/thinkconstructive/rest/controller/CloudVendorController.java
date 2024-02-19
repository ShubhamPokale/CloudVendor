package com.thinkconstructive.rest.controller;


import com.thinkconstructive.rest.model.CloudVendor;
import com.thinkconstructive.rest.response.ResponseHandler;
import com.thinkconstructive.rest.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.thinkconstructive.rest.response.ResponseHandler.responseBuilder;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    // Service layer instance.
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // Read specific CloudVendor
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here ", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));


    }
    //Get all Cloud Vendor

    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails()
    {
        return cloudVendorService.getAllCloudVendors();

    }


    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

//        this.cloudVendor = cloudVendor;
        cloudVendorService.createCloudVendor(cloudVendor);

        return "Cloud Vendor Created Succesfully";

    }


    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

       // this.cloudVendor = cloudVendor;

        cloudVendorService.updateCloudVendor(cloudVendor);


        return "Cloud Vendor Updated Succesfully";

    }


    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){

        //this.cloudVendor = null;
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";

    }


}
