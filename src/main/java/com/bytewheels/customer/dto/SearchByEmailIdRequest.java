package com.bytewheels.customer.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class SearchByEmailIdRequest implements Serializable {

    private static final long serialVersionUID = 8332506467484614378L;

    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

    @NotEmpty
    @Pattern(regexp = EMAIL_VERIFICATION,message = "Email-ID not valid")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
