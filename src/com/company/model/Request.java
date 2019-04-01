package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Request {
    private boolean takeMoney;
    private boolean takeCommission;
}
