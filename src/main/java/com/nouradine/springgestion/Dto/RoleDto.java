package com.nouradine.springgestion.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nouradine.springgestion.Model.Role;
import com.nouradine.springgestion.Model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Builder
public class RoleDto {
    private  Long id;


    private String roleName;

    @JsonIgnore
    private UtilisateurDto utilisateur;

    public static RoleDto fromEntity(Role roles) {
        if (roles == null) {
            return null;
        }
        return RoleDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Role toEntity(RoleDto dto) {
        if (dto == null) {
            return null;
        }
        Role roles = new Role();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateur()));
        return roles;
    }
}
