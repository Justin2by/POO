package MOMENTO2.VERSIONA;

public class CuentaBancaria {
// Defina los atributos privados
    private String titular;
    private String numeroCuenta;
    private double saldo;

// Constructor por defecto
public CuentaBancaria(){;
    this.titular = "Sin titular";
    this.numeroCuenta = "000000";
    this.saldo = 0.0;
}

// Constructor parametrizado
public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        } else {
            this.titular = "Sin titular";
        }

        if (numeroCuenta != null && numeroCuenta.length() >= 6) {
            this.numeroCuenta = numeroCuenta;
        } else {
            this.numeroCuenta = "000000";
        }

        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0.0;
        }
    }

// Getters y Setters con validaciones

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta != null && numeroCuenta.length() >= 6) {
            this.numeroCuenta = numeroCuenta;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

// M todo depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
// M todo retirar
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }
// "sobregiro máximo de-50"    
    //public void retirar(double monto) {
    //if (monto > 0 && (saldo - monto) >= -50) {
    //    saldo -= monto;
    //}
    
// M todo toString
    public String toString() {
        return "Titular: " + titular + ", Cuenta: " + numeroCuenta + ", Saldo: $" + saldo;
    }
}