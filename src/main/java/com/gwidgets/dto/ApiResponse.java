package com.gwidgets.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ws.rs.core.Response;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private Response status;
    private String message;
    private Object data;
}