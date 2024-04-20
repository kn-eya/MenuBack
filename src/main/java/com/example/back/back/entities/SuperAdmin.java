package com.example.back.back.entities;

import com.example.back.back.security.entities.AppUser;
import javax.persistence.*;


@Entity
@DiscriminatorValue("1")
public class SuperAdmin  extends AppUser {


    public SuperAdmin() {
    }

}
