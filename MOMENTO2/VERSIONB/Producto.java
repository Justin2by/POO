package MOMENTO2.VERSIONB;

public class Producto {
// Defina los atributos privados
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

// Constructor por defecto    
    public Producto() {
        this.codigo = "0000";
        this.descripcion = "Sin descripción";
        this.cantidad = 1;
        this.precioUnitario = 0.0;
    }

// "Impuesto del 8%""
    //public double calcularTotalConImpuesto() {
    //double subtotal = calcularSubtotal();
    //double impuesto = subtotal * 0.08; // 8%
    //return subtotal + impuesto;
    //}

// Constructor parametrizado    
    public Producto(String codigo, String descripcion, int cantidad, double precioUnitario) {
        if (codigo != null && !codigo.isEmpty()) {
            this.codigo = codigo;
        } else {
            this.codigo = "0000";
        }

        if (descripcion != null && !descripcion.isEmpty()) {
            this.descripcion = descripcion;
        } else {
            this.descripcion = "Sin descripción";
        }

        this.cantidad = (cantidad > 0) ? cantidad : 1;
        this.precioUnitario = (precioUnitario >= 0) ? precioUnitario : 0.0;
    }

// Getters y Setters con validaciones    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty()) {
            this.codigo = codigo;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.isEmpty()) {
            this.descripcion = descripcion;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        }
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario >= 0) {
            this.precioUnitario = precioUnitario;
        }
    }

// M todo calcularSubtotal    
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

// M todo aplicarDescuento    
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 50) {
            double descuento = (precioUnitario * porcentaje) / 100;
            precioUnitario -= descuento;
        }
    }

// M todo incrementarCantidad    
    public void incrementarCantidad(int valor) {
        if (valor > 0) {
            cantidad += valor;
        }
    }

// M todo toString  
    public String toString() {
        return "Código: " + codigo + ", Descripción: " + descripcion + ", Cantidad: " + cantidad + ", Precio unitario: $" + precioUnitario + ", Subtotal: $" + calcularSubtotal();
    }
}