package com.nouradine.springgestion.Dto;

import com.nouradine.springgestion.Model.Client;
import com.nouradine.springgestion.Model.CommandeClient;
import com.nouradine.springgestion.Model.EtatCommande;
import com.nouradine.springgestion.Model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {
    private  Long id;


    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;

    private Integer idEntreprise;


    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;


    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                .build();

    }

    public static CommandeClient toEntity(CommandeClientDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(dto.getId());
        commandeClient.setCode(dto.getCode());
        commandeClient.setClient(ClientDto.toEntity(dto.getClient()));
        commandeClient.setDateCommande(dto.getDateCommande());
        commandeClient.setEtatCommande(dto.getEtatCommande());
        commandeClient.setIdEntreprise(dto.getIdEntreprise());
        return commandeClient;
    }



}
