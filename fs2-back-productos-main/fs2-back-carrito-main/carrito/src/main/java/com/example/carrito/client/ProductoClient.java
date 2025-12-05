package com.example.carrito.client;

import com.example.carrito.model.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductoClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${producto.service.url}")
    private String url;

    public List<ProductoDTO> listarProductos() {
        ProductoDTO[] productos = restTemplate.getForObject(url + "/api/v1/productos/all", ProductoDTO[].class);
        return Arrays.asList(productos);
    }
}
