package com.gating.testcases;

import com.gating.attributes.Address;
import com.gating.attributes.User;
import com.gating.enums.AccountType;
import com.gating.enums.Gender;
import org.testng.annotations.Test;

public class UserCreationTest {

    @Test
    public void createUser() {
        final User user = new User();
        user.setName("Arshu");
        user.setAge(25);
        user.setEmailId("arshu@gmail.com");
        user.setAccountType(AccountType.FREE);
        user.setGender(Gender.MALE);

        final Address arshuAddress = new Address();
        arshuAddress.setZipCode("34567");
        arshuAddress.setState("Bangalore");
        arshuAddress.setCountry("India");

        user.setAddress(arshuAddress);

        System.out.println(user);
    }

}
