package com.example.factura.repository

import com.example.factura.model.Client
import com.example.factura.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ClientRepository:JpaRepository<Client, Long> {
    fun findById(id: Long?): Client?

    @Query(nativeQuery = true)
    fun findClient(@Param("id") id: Long?):List<Client>?
}

