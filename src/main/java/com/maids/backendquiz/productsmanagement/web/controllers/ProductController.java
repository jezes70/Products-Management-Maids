package com.maids.backendquiz.productsmanagement.web.controllers;

import com.maids.backendquiz.productsmanagement.domain.model.response.APIResponse;
import com.maids.backendquiz.productsmanagement.domain.model.response.DataResponse;
import com.maids.backendquiz.productsmanagement.domain.model.resquest.ProductRequest;
import com.maids.backendquiz.productsmanagement.web.services.ProductService;
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
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Create a new product")
    @ApiResponse(responseCode = "200", description = "Product created successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @PostMapping("/create-product")
    public ResponseEntity<APIResponse<DataResponse>> createProduct(@RequestBody @Valid ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @Operation(summary = "Fetch a product by ID")
    @ApiResponse(responseCode = "200", description = "Product retrieved successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @GetMapping("/fetch-product/{id}")
    public ResponseEntity<APIResponse<DataResponse>> fetchProduct(@PathVariable("id") Long id){
        return productService.fetchProduct(id);
    }

    @Operation(summary = "Delete a product by ID")
    @ApiResponse(responseCode = "200", description = "Product deleted successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<APIResponse<DataResponse>> deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

    @Operation(summary = "Update a product by ID")
    @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content(schema = @Schema(implementation = APIResponse.class)))
    @PutMapping("/update-product/{id}")
    public ResponseEntity<APIResponse<DataResponse>> updateProduct(@RequestBody @Valid ProductRequest productRequest, @PathVariable("id") Long id){
        return productService.updateProduct(productRequest, id);
    }
}
