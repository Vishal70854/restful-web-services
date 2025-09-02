package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// this annotation is used at class level and we can mention all the properties
// which we don't want to include in our response
//@JsonIgnoreProperties("v1")
public class SomeBean {
    private String v1;

    //implementing static filtering
    @JsonIgnore
    private String v2;      // after adding @JsonIgnore this field v2 will not be a part of the response
    private String v3;

    public SomeBean(String v1, String v2, String v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "v1='" + v1 + '\'' +
                ", v2='" + v2 + '\'' +
                ", v3='" + v3 + '\'' +
                '}';
    }
}
