package com.ducat.springboot20.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
        private int userId;
        private int id;
        private String title;
        private String body;
}
