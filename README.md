# Design-patterns
## Strategy pattern
O objetivo do serviço é cancelar transações com status AUTORIZACAO_CARTAO_REJEITADA e EFETIVACAO_REJEITADA.
* A interface ICancelService contém os métodos:
  - canCancel: identifica se a transação deve ser cancelada de acordo com o status
  - cancelTransaction: realiza o cancelamento da transação
* As classes AuthorizationCancelStrategy e EffectedCancelStrategy implementam a interface ICancelService. A primeira
cancela uma autorização em cartão de crédito, e a segunda cancelala uma efetivação.
* O serviço CancelService contém o método cancelTransactions, que recebe um lote de transações e identifica quais 
delas devem ser canceladas (status AUTORIZACAO_CARTAO_REJEITADA e EFETIVACAO_REJEITADA). Após a identificação, 
realiza o cancelamento destas transações.
* A classe Main cria um pool de transações e executa o CancelService para verificar quais devem ser canceladas.
