package strategy;

import model.Transaction;
import model.TransactionStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorizationCancelStrategy implements ICancelService {
    @Override
    public List<Transaction> canCancel(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.status().equals(TransactionStatus.AUTORIZACAO_CARTAO_PROCESSADA))
                .collect(Collectors.toList());
    }

    @Override
    public void cancelTransaction(List<Transaction> transactions) {
        transactions.forEach(transaction ->
            System.out.println("cancelando autorização no cartão de crédito do id " + transaction.id()));

    }
}
