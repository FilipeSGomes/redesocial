package com.tangerino.redesocial.dto;

import com.tangerino.redesocial.constraints.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
