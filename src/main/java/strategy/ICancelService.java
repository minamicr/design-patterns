package strategy;

import model.Transaction;

import java.util.List;

public interface ICancelService {
    List<Transaction> canCancel(List<Transaction> transactions);
    void cancelTransaction(List<Transaction> transactions);
}
