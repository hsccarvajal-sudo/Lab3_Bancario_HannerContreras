public class Main {
    public static void main(String[] args) {
        CuentaAhorros ahorros = new CuentaAhorros("AH-001", "Carlos Pérez", 1000.0, 0.02, 5.0);
        CuentaCorriente corriente = new CuentaCorriente("CC-001", "María Gómez", 500.0, 1000.0, 0.001);

        try (RegistroAuditoriaBancaria log = new RegistroAuditoriaBancaria("auditoria.log")) {
            
            log.registrarMensaje("=== INICIO JORNADA ===");
            
            ahorros.depositar(200);
            log.registrar("DEPOSITO", ahorros.getNumeroCuenta(), 200, ahorros.getSaldo());

            try { ahorros.retirar(1500); } 
            catch (SaldoInsuficienteException e) {
                log.registrarMensaje("ERROR: " + e.getMessage());
            }

            ahorros.aplicarComisionMensual();
            log.registrar("COMISION", ahorros.getNumeroCuenta(), 0, ahorros.getSaldo());

            corriente.depositar(300);
            log.registrar("DEPOSITO", corriente.getNumeroCuenta(), 300, corriente.getSaldo());

            try { corriente.retirar(1200); } 
            catch (SaldoInsuficienteException e) {
                log.registrarMensaje("ERROR: " + e.getMessage());
            }

            corriente.aplicarComisionMensual();
            log.registrar("COMISION", corriente.getNumeroCuenta(), 0, corriente.getSaldo());

            log.registrarMensaje("=== FIN JORNADA ===");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Saldo Ahorros: " + ahorros.getSaldo());
        System.out.println("Saldo Corriente: " + corriente.getSaldo());
    }
}
