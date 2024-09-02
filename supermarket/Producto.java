public class Producto {
  private String nombre;
  private double precio;
  private int cantidad;
  private int stock;
  private String medida;

  public Producto() {
  }

  public Producto(String nombre, double precio, int stock, String medida) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
    this.medida = medida;
  }

  public String toString() {
    return this.nombre + " $" + this.precio + " - cantidad disponible " + this.stock + " " + this.medida;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return this.precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getStock() {
    return this.stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getMedida() {
    return this.medida;
  }

  public void setMedida(String medida) {
    this.medida = medida;
  }
}
