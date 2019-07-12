package com.dvd.Dvd.servises;

import org.springframework.beans.factory.annotation.Value;

public interface ActorName {

    String getName();
    String getLastName();

//    @Value("#{target.name + ' ' + target.lastName}")
//    String getFullName();
}
