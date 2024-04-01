package com.bikerental.Bike.Rental.dto;

import com.bikerental.Bike.Rental.Constant.ResponseCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {

    private ResponseCode responseCode;
    private String responseMessage;
    private T data;
}
