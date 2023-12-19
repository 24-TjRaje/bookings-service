package com.trex.micro.Bookings.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Idols {
    
    private Integer idolId;

    private String idolName;

    private Integer idolHeight;

    private String notes;

}
