import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class RegistroAuditoriaBancaria implements AutoCloseable {
    private PrintWriter writer;

    public RegistroAuditoriaBancaria(String archivo) throws IOException {
        this.writer = new PrintWriter(new FileWriter(archivo, true));
    }

    public void registrar(String operacion, String cuenta, double monto, double saldoFinal) {
        writer.printf("[%s] %s | Cuenta: %s | Monto: $%.2f | Saldo: $%.2f%n",
                LocalDateTime.now(), operacion, cuenta, monto, saldoFinal);
        writer.flush();
    }

    public void registrarMensaje(String mensaje) {
        writer.printf("[%s] %s%n", LocalDateTime.now(), mensaje);
        writer.flush();
    }

    @Override
    public void close() {
        if (writer != null) {
            writer.close();
            System.out.println(">>> Recurso de auditoría cerrado (RAII simulado en Java).");
        }
    }
}
