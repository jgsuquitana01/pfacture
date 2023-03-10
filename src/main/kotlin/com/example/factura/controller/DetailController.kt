package com.example.factura.controller


import com.example.factura.model.Detail
import com.example.factura.model.Product
import com.example.factura.service.DetailService
import com.example.factura.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/detail")
class DetailController {

    @Autowired
    lateinit var detailService: DetailService


    @GetMapping
    fun list():List<Detail>{
        return detailService.list()
    }

    @PostMapping
    fun save(@RequestBody detail: Detail): Detail?{
        return detailService.save(detail)
    }
    @PutMapping
    fun update(@RequestBody detail: Detail): ResponseEntity<Detail> {
        return ResponseEntity(detailService.update(detail), HttpStatus.ACCEPTED)
    }

    @PatchMapping
    fun updateTotal(@RequestBody detail: Detail): ResponseEntity<Detail> {
        return ResponseEntity(detailService.updateTotal(detail), HttpStatus.ACCEPTED)
    }

}

