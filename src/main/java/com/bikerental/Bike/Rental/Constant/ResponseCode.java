package com.bikerental.Bike.Rental.Constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS("200"), BAD_REQUEST("400"),
    UN_AUTHENTICATE("401"), UN_AUTHORIZED("403"),
    ERROR("001");

    private final String code;
}
