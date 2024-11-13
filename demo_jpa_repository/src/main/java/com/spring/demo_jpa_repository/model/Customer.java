package com.spring.demo_jpa_repository.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2, max = 30, message = "nhỏ nhất 2 ký tự, lớn nhất 30 ký tự")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z0-9]{3}", message = "độ dài 3 ký tự")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
