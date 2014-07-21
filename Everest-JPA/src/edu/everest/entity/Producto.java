package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idProducto;

	private int cantidad;

	private String descripcion;

	private String fecVec;

	private String marca;

	private String nombre;

	private String precio;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to TipoProducto
	@ManyToOne
	@JoinColumn(name="idTipoProducto")
	private TipoProducto tipoProducto;

	//bi-directional many-to-one association to DetalleCobro
	@OneToMany(mappedBy="producto")
	private List<DetalleCobro> detalleCobros;

	public Producto() {
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecVec() {
		return this.fecVec;
	}

	public void setFecVec(String fecVec) {
		this.fecVec = fecVec;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public TipoProducto getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public List<DetalleCobro> getDetalleCobros() {
		return this.detalleCobros;
	}

	public void setDetalleCobros(List<DetalleCobro> detalleCobros) {
		this.detalleCobros = detalleCobros;
	}

	public DetalleCobro addDetalleCobro(DetalleCobro detalleCobro) {
		getDetalleCobros().add(detalleCobro);
		detalleCobro.setProducto(this);

		return detalleCobro;
	}

	public DetalleCobro removeDetalleCobro(DetalleCobro detalleCobro) {
		getDetalleCobros().remove(detalleCobro);
		detalleCobro.setProducto(null);

		return detalleCobro;
	}

}