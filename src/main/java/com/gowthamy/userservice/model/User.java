package com.gowthamy.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User  {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("UserID")
    private long userId;
    @JsonProperty("EmployeeID")
    @NotBlank(message = "Employee Id should not be empty")
    private String employeeId;
    @JsonProperty("SiteName")
    private String siteName;
    @JsonProperty("BusinessUnitName")
    private String businessUnitName;
    @JsonProperty("AccountName")
    private String accountName;
    @JsonProperty("GroupName")
    private String groupName;
    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("TypeName")
    private String typeName;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Duration")
    private String duration;
    @JsonProperty("IsProcessed")
    private boolean isProcessed;
}
