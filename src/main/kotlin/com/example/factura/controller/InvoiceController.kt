package com.example.factura.controller


import com.example.factura.model.Invoice
import com.example.factura.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/invoice")
class InvoiceController {

    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list():List<Invoice>{
        return invoiceService.list()
    }

    @GetMapping("/totals/{total}")
    fun listTotals(@PathVariable("total") total:Double):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listTotalMoreThan(total), HttpStatus.ACCEPTED)
    }

//    @GetMapping("/updatetotal/{invoiceId}")
//    fun listTotals(@PathVariable("invoiceId") invoiceId:Long):ResponseEntity<*>{
//        return ResponseEntity(invoiceService.updateFromDetails(invoiceId), HttpStatus.ACCEPTED)
//    }

    @PostMapping
    fun save(@RequestBody @Valid invoice: Invoice): Invoice?{
        return invoiceService.save(invoice)

    }

    @PutMapping
    fun update(@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.ACCEPTED)
    }

    @PatchMapping
    fun updateTotal(@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.updateTotal(invoice), HttpStatus.ACCEPTED)
    }

}