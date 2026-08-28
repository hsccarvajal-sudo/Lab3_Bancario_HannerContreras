public class CuentaCorriente extends CuentaBancaria {
    private double cupoSobregiro;
    private double comisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           double cupoSobregiro, double comisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
        this.comisionSobregiro = comisionSobregiro;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        double nuevoSaldo = getSaldo() - monto;
        
        if (getSaldo() < 0) {
            double interesMora = Math.abs(getSaldo()) * comisionSobregiro;
            nuevoSaldo -= interesMora;
        }

        if (nuevoSaldo < -cupoSobregiro) {
            throw new SaldoInsuficienteException("Cupo de sobregiro excedido.");
        }
        setSaldo(nuevoSaldo);
    }

    @Override
    public void aplicarComisionMensual() {
        if (getSaldo() < 0) {
            double interesAcumulado = Math.abs(getSaldo()) * comisionSobregiro * 30;
            double nuevoSaldo = getSaldo() - interesAcumulado;
            setSaldo(Math.max(nuevoSaldo, -cupoSobregiro));
        }
    }
}
