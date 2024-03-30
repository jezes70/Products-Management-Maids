package com.maids.backendquiz.productsmanagement.web.controllers;

import com.maids.backendquiz.productsmanagement.domain.model.response.APIResponse;
import com.maids.backendquiz.productsmanagement.domain.model.response.DataResponse;
import com.maids.backendquiz.productsmanagement.domain.model.response.SalesReport;
import com.maids.backendquiz.productsmanagement.domain.model.resquest.SaleRequest;
import com.maids.backendquiz.productsmanagement.web.services.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sales")
public class SalesController {
    private final SaleService saleService;

    @Operation(summary = "Create a new sale")
    @ApiResponse(responseCode = "200", description = "Sale created successfully")
    @PostMapping("/create")
    public ResponseEntity<APIResponse<DataResponse>> sale(@RequestBody @Valid SaleRequest saleRequest){
        return saleService.createSale(saleRequest);
    }

    @Operation(summary = "Get sales report by date range")
    @ApiResponse(responseCode = "200", description = "Sales report retrieved successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @GetMapping("/report")
    public ResponseEntity<APIResponse<SalesReport>> getSalesReportByDateRange(
            @Parameter(description = "Start date of the report") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @Parameter(description = "End date of the report") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        if (startDate.isAfter(endDate)) {
            return ResponseEntity.badRequest().build();
        }
        return saleService.getSalesByDateRange(startDate, endDate);
    }
}
