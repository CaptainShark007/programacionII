import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static Scanner scan = new Scanner(System.in);
  private static Seeders seeders = new Seeders();
  private static ArrayList<Producto> productos = seeders.productos();
  private static ArrayList<Producto> carrito = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println("----------------------------------------");
    System.out.println("Supermarket le da la bienvenida");
    System.out.println("----------------------------------------");
    System.out.println("¿Qué quieres hacer hoy?");

    menu();

    // System.out.println("Ingrese su nombre:");
    // String nombre = scan.nextLine();
    // System.out.println("Ingrese su apellido:");
    // String apellido = scan.nextLine();
    // System.out.println("Ingrese su DNI:");
    // int dni = scan.nextInt();
    // System.out.println("¿Realiza compra mayorista?(true/false)");
    // boolean mayorista = scan.nextBoolean();
    // System.out.println();

    // Cliente cliente = new Cliente(nombre, apellido, dni, mayorista);

  }

  public static void menu() {
    int opcion;

    do {
      System.out.println();
      System.out.println("1: Ver la lista de productos");
      System.out.println("2: Armar un carrito de compras");
      if (carrito.size() >= 1) {
        System.out.println("3: Ir a la caja a pagar");
      }
      System.out.println("0: Salir");

      opcion = scan.nextInt();

      switch (opcion) {
        case 1:
          listarProductos();
          break;
        case 2:
          System.out.println("\nArme su carrito de compras");
          armarCarrito();
          break;
        default:
          break;
      }
    } while (opcion != 0);

    System.out.println("Gracias por su visita, hasta luego!");
  }

  public static void listarProductos() {
    System.out.println("\nAquí tiene la lista de productos disponibles");

    for (int i = 0; i < productos.size(); i++) {
      Producto producto = productos.get(i);
      System.out.println((i + 1) + ": " + producto.toString() + (producto.getStock() == 0 ? "(Sin stock)" : ""));
    }
  }

  public static void armarCarrito() {
    int opcion;

    do {
      System.out.println();
      System.out.println("1: Cargar un producto");
      if (carrito.size() >= 1) {
        System.out.println("2: Ver carrito");
        System.out.println("3: Sacar un producto");
      }
      System.out.println("0: Volver");

      opcion = scan.nextInt();

      switch (opcion) {
        case 1:
          cargarProducto();
          break;
        case 2:
          if (carrito.size() >= 1) {
            verCarrito();
          }
          break;
        case 3:
          if (carrito.size() >= 1) {
            sacarProducto();
          }
          break;
        default:
          break;
      }
    } while (opcion != 0);
  }

  public static void cargarProducto() {
    Producto producto = seleccionarProducto();
    int cantidad = seleccionarCantidadProducto(producto);

    if (!carrito.contains(producto)) {
      carrito.add(producto);
    }

    producto.setCantidad(producto.getCantidad() + cantidad);
    producto.setStock(producto.getStock() - cantidad);

    System.out.println("\nProducto cargado!");
    System.out.println(producto.getNombre() + " - " + producto.getCantidad() + producto.getMedida());
  }

  public static Producto seleccionarProducto() {
    int opcion;

    do {
      System.out.println("\nSeleccione un producto,ingresando el nº de indice:");

      opcion = scan.nextInt();

      if (opcion <= 0 || opcion >= productos.size() + 1) {
        System.out.println("Producto inexistente");
      }

    } while (opcion <= 0 || opcion >= productos.size() + 1);

    return productos.get(opcion - 1);
  }

  public static int seleccionarCantidadProducto(Producto producto) {
    int cantidad;

    do {
      System.out.println("\nIngrese la cantidad a llevar:");

      cantidad = scan.nextInt();

      if (cantidad < 0 || cantidad > producto.getStock()) {
        System.out.println("Cantidad ingresada no disponible");
      }

    } while (cantidad < 0 || cantidad > producto.getStock());

    return cantidad;
  }

  public static void verCarrito() {
    for (int i = 0; i < carrito.size(); i++) {
      Producto producto = carrito.get(i);
      System.out.println(
          "\n" + (i + 1) + ": " + producto.getNombre() + " - " + producto.getCantidad() + producto.getMedida());
    }
  }

  public static void sacarProducto() {
    int opcion;

    do {
      System.out.println("Ingrese el nº de indice del producto a sacar:");

      opcion = scan.nextInt();

      if (opcion <= 0 || opcion >= carrito.size() + 1) {
        System.out.println("Producto inexistente");
      }
    } while (opcion <= 0 || opcion >= carrito.size() + 1);

    Producto producto = carrito.get(opcion - 1);
    producto.setCantidad(0);
    producto.setStock(100);
    carrito.remove(opcion - 1);
  }
}