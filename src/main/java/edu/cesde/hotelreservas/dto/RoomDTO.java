package edu.cesde.hotelreservas/dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private String number;
    private String type;
    private Double price;
    private Boolean available;
}
