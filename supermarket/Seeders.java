import java.util.ArrayList;

public class Seeders {
  public ArrayList<Producto> productos() {
    ArrayList<Producto> productos = new ArrayList<>();

    Producto azucar = new Producto("Azucar", 25, 100, "Kg");
    productos.add(azucar);
    Producto huevos = new Producto("Huevos", 30, 100, "U");
    productos.add(huevos);
    Producto leche = new Producto("Leche", 30, 100, "L");
    productos.add(leche);
    Producto harina = new Producto("Harina", 20, 100, "Kg");
    productos.add(harina);
    Producto pan = new Producto("Pan", 10, 100, "Kg");
    productos.add(pan);
    Producto carne = new Producto("Carne", 35, 100, "Kg");
    productos.add(carne);
    Producto pollo = new Producto("Pollo", 30, 100, "Kg");
    productos.add(pollo);

    return productos;
  }
}
