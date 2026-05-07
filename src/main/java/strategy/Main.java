package strategy;

import model.Transaction;
import model.TransactionStatus;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CancelService cancelService = new CancelService(Arrays.asList(
                new AuthorizationCancelStrategy(),
                new EffectedCancelStrategy()
        ));

        List<Transaction> transactions = createTransactions();
        cancelService.cancelTransactions(transactions);

    }

    private static List<Transaction> createTransactions() {
        return Arrays.asList(
                new Transaction(323L, TransactionStatus.AUTORIZACAO_CARTAO_REJEITADA),
                new Transaction(324L, TransactionStatus.EFETIVACAO_REJEITADA),
                new Transaction(324L, TransactionStatus.ORQUESTRACAO_ERRO),
                new Transaction(703L, TransactionStatus.AUTORIZACAO_CARTAO_PROCESSADA),
                new Transaction(703L, TransactionStatus.EFETIVACAO_REJEITADA),
                new Transaction(703L, TransactionStatus.ORQUESTRACAO_ERRO),
                new Transaction(905L, TransactionStatus.AUTORIZACAO_CARTAO_PROCESSADA),
                new Transaction(905L, TransactionStatus.EFETIVACAO_PROCESSADA),
                new Transaction(905L, TransactionStatus.ORQUESTRACAO_FINALIZADA)
        );
    }
}
