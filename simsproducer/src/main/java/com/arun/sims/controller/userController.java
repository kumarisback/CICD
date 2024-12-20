package com.arun.sims.controller;

import com.arun.sims.model.Client;
import com.arun.sims.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    ClientService clientService;

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "fetched Client successfully")
    })
    @GetMapping("/clients")
    public ResponseEntity<?> getClient(){
        try {
            List<Client> clients=clientService.getAllClients();
            return new ResponseEntity<>(clients,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Create a new client",
            description = "This API saves a new client to the database",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Client object that needs to be added",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            mediaType = "application/json",
                            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = Client.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Client created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Client.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid client data provided",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "{\"message\": \"Invalid input data\"}")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "{\"message\": \"An unexpected error occurred\"}")
                            )
                    ) }


    )
    @PostMapping("/client")
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client){
        try {
            clientService.createClient(client);
            return new ResponseEntity<>("saved successfully",HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<?> updateClient( @RequestBody Client client, @PathVariable Long id){
        try {
            clientService.updateClient(id,client);
            return new ResponseEntity<>("updated successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        try {
            clientService.deleteClient(id);
            return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
