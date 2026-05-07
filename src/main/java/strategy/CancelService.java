package strategy;

import model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelService {
    private final List<ICancelService> cancelService;

    public CancelService(List<ICancelService> cancelService) {
        this.cancelService = cancelService;
    }

    public void cancelTransactions(List<Transaction> transactions) {

        cancelService.forEach(service -> {
            System.out.println("Processando serviço " + service.getClass().getName());
            List<Transaction> transactionsToCancel = service.canCancel(transactions);
            if (!transactionsToCancel.isEmpty())
                service.cancelTransaction(transactionsToCancel);

        });
    }

}
