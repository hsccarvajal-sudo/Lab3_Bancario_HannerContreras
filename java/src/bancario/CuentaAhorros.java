public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;
    private double comisionMensual;

    public CuentaAhorros(String numeroCuenta, String titular, double saldoInicial,
                         double tasaInteres, double comisionMensual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.comisionMensual = comisionMensual;
    }

    @Override
    public void aplicarComisionMensual() {
        double nuevoSaldo = (getSaldo() * (1 + tasaInteres)) - comisionMensual;
        setSaldo(Math.max(nuevoSaldo, 0));
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        if (getSaldo() < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente en Cuenta de Ahorros.");
        }
        setSaldo(getSaldo() - monto);
    }
}
