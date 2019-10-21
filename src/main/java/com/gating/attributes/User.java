package com.gating.attributes;

import com.gating.enums.AccountType;
import com.gating.enums.Gender;
import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
    private String emailId;
    private AccountType accountType;
    private Gender gender;
    private Address address;
}
