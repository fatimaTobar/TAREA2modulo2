package com.distribuida.entities;

public class FacturaDetalle {

	
	private int idFacturaDetalle;
	private int cantidad;
	private double subtotal;
	
	private int factura; //private int idFactura;
	private Libro libro;     //private int idLibro;
	
	
	public FacturaDetalle(int i, String string, int j, double d) {
		// TODO Auto-generated constructor stub
	}

	public FacturaDetalle(int i, Object string, int j, int d) {
		// TODO Auto-generated constructor stub
	}

	public int getIdFacturaDetalle() {
		return idFacturaDetalle;
	}

	public void setIdFacturaDetalle(int idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public int getFactura() {
		return factura;
	}

	public void setFactura(int i) {
		this.factura = i;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [idFacturaDetalle=" + idFacturaDetalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + ", factura=" + factura + ", libro=" + libro + "]";
	}

	public void setProducto(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPrecioUnitario(double d) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
