package com.idat.idatapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.ProductRequestDTO;
import com.idat.idatapirest.dto.ProductResponseDTO;
import com.idat.idatapirest.model.Products;
import com.idat.idatapirest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public void guardarProducto(ProductRequestDTO p) {
		Products producto = new Products();
		producto.setIdProducto(p.getIdRequest());
		producto.setNombreProducto(p.getNombreProducto());
		producto.setDescripcion(p.getDescripcionProducto());
		producto.setPrecio(p.getPrecioProducto());
		producto.setStock(p.getStockProducto());
		repository.save(producto);

	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void editarProducto(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		Products producto = new Products();
		producto.setIdProducto(p.getIdRequest());
		producto.setNombreProducto(p.getNombreProducto());
		producto.setDescripcion(p.getDescripcionProducto());
		producto.setPrecio(p.getPrecioProducto());
		producto.setStock(p.getStockProducto());
		repository.saveAndFlush(producto);

	}

	@Override
	public List<ProductResponseDTO> listarProducto() {
		List<Products> producto = repository.findAll();
		List<ProductResponseDTO> dto = new ArrayList<ProductResponseDTO>();
		ProductResponseDTO productoDTO = null;
		
		for (Products products : producto) {
			productoDTO = new ProductResponseDTO();
			productoDTO.setIdResponse(products.getIdProducto());
			productoDTO.setNombreProducto(products.getNombreProducto());
			productoDTO.setPrecioProducto(products.getPrecio());
			productoDTO.setDescripcionProducto(products.getDescripcion());
			productoDTO.setStockProducto(products.getStock());
			dto.add(productoDTO);
		}
		
		return dto; 
	}

	@Override
	public ProductResponseDTO productById(Integer id) {
		Products producto = repository.findById(id).orElse(null);
		ProductResponseDTO productoDTO = new ProductResponseDTO();
		productoDTO = new ProductResponseDTO();
		productoDTO.setIdResponse(producto.getIdProducto());
		productoDTO.setNombreProducto(producto.getNombreProducto());
		productoDTO.setPrecioProducto(producto.getPrecio());
		productoDTO.setDescripcionProducto(producto.getDescripcion());
		productoDTO.setStockProducto(producto.getStock());
		return productoDTO;
	}

}
