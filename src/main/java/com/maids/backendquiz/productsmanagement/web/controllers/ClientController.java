package com.maids.backendquiz.productsmanagement.web.controllers;


import com.maids.backendquiz.productsmanagement.domain.model.response.APIResponse;
import com.maids.backendquiz.productsmanagement.domain.model.response.DataResponse;
import com.maids.backendquiz.productsmanagement.domain.model.resquest.ClientRequest;
import com.maids.backendquiz.productsmanagement.web.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/client")
public class ClientController {
    private final ClientService clientService;

    @Operation(summary = "Create a new client")
    @ApiResponse(responseCode = "201", description = "Client created successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @PostMapping("/create-client")
    public ResponseEntity<APIResponse<DataResponse>> createClient(@RequestBody @Valid ClientRequest clientRequest){
        return clientService.createClient(clientRequest);
    }

    @Operation(summary = "Fetch a client by ID")
    @ApiResponse(responseCode = "200", description = "Client retrieved successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @GetMapping("/fetch-client/{id}")
    public ResponseEntity<APIResponse<DataResponse>> fetchClient(@PathVariable("id") Long id){
        return clientService.fetchClient(id);
    }

    @Operation(summary = "Delete a client by ID")
    @ApiResponse(responseCode = "200", description = "Client deleted successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @DeleteMapping("/delete-client/{id}")
    public ResponseEntity<APIResponse<DataResponse>> deleteClient(@PathVariable("id") Long id){
        return clientService.deleteClient(id);
    }

    @Operation(summary = "Update a client by ID")
    @ApiResponse(responseCode = "200", description = "Client updated successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @PutMapping("/update-client/{id}")
    public ResponseEntity<APIResponse<DataResponse>> updateClient(@RequestBody @Valid ClientRequest clientRequest, @PathVariable("id") Long id){
        return clientService.updateClient(clientRequest,id);
    }
}
