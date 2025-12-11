package com.example.carrito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carrito.model.dto.carrito;
import com.example.carrito.model.dto.detalleCarrito;
import com.example.carrito.repository.carritoRepositorio;

@Service
public class carritoService {

    @Autowired // para que se inicie junto con el repo y no se desconecten uno del otro
    private carritoRepositorio carritoRepo;

    @Autowired
    private com.example.carrito.client.ProductoClient productoClient;

    @Autowired
    private com.example.carrito.client.UsuarioClient usuarioClient;

    // no se por que alguien querria listar carritos, pero bueno, lo pongo por si acaso
    public List<carrito> listarCarritos() {
        return carritoRepo.findAll();
    }

    public carrito guardarCarrito(carrito carrito) {
        if (carrito.getItems() != null) {
            for (detalleCarrito item : carrito.getItems()) {
                item.setCarrito(carrito);
            }
        }
        return carritoRepo.save(carrito);
    }

    public void eliminarCarrito(Long id) {
        carritoRepo.deleteById(id);
    }

    public carrito buscarCarrito(Long id) {
        return carritoRepo.findById(id).orElse(null);
    }

    // ACTUALIZAR CARRITO
    public carrito actualizarCarrito(Long id, carrito carritoActualizado) {

        Optional<carrito> carritoExistenteOpt = carritoRepo.findById(id);

        if (carritoExistenteOpt.isPresent()) {

            carrito carritoExistente = carritoExistenteOpt.get();

            // limpiar items actuales del carrito existente
            carritoExistente.getItems().clear();

            // actualizar dueño del carrito
            carritoExistente.setIdUsuario(carritoActualizado.getIdUsuario());
            // actualizar fecha
            carritoExistente.setFechaCreacion(carritoActualizado.getFechaCreacion());

            // añadir items al carrito existente
            if (carritoActualizado.getItems() != null) {
                for (detalleCarrito item : carritoActualizado.getItems()) {
                    // para vincular el nuevo detalle al carrito existente
                    item.setCarrito(carritoExistente);
                    carritoExistente.getItems().add(item);
                }
            }

            // para guardar los cambios
            return carritoRepo.save(carritoExistente);

        } else {
            return null; // en caso de que el carrito no exista;
        }
    }

    public List<com.example.carrito.model.dto.ProductoDTO> listarProductosExternos() {
        return productoClient.listarProductos();
    }

    public List<com.example.carrito.model.dto.UsuarioDTO> listarUsuariosExternos() {
        return usuarioClient.listarUsuarios();
    }


    
    public carrito finalizarCompra(Long idCarrito) {
        Optional<carrito> carritoOpt = carritoRepo.findById(idCarrito);

        if (carritoOpt.isPresent()) {
            carrito carritoAComprar = carritoOpt.get();
            
            // 1. Verificar si ya fue comprado
            if (carritoAComprar.isComprado()) {
                throw new RuntimeException("El carrito con ID " + idCarrito + " ya fue finalizado/comprado.");
            }
            
            // 2. Marcar como comprado
            carritoAComprar.setComprado(true); 
            
            
            // 3. Guardar el estado actualizado en la base de datos
            return carritoRepo.save(carritoAComprar);
            
        } else {
            throw new RuntimeException("Carrito con ID " + idCarrito + " no encontrado para finalizar compra.");
        }
    }


}
