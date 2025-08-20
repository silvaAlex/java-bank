package br.com.dio.repository;

import static br.com.dio.repository.CommonsRepository.checkFundsForTransaction;

import java.util.ArrayList;
import java.util.List;

import br.com.dio.exception.AccountWithInvestmentException;
import br.com.dio.exception.InvestmentNotFoundException;
import br.com.dio.exception.WalletNotFoundException;
import br.com.dio.model.AccountWallet;
import br.com.dio.model.Investment;
import br.com.dio.model.InvestmentWallet;

public class InvestmentRepository {
    private long nextId = 0;
    private final List<Investment> investments = new ArrayList<>();
    private final List<InvestmentWallet> wallets = new ArrayList<>();

    public Investment create(final long tax, final long initialFunds) {
        this.nextId++;
        var investment = new Investment(this.nextId, tax, initialFunds);
        investments.add(investment);
        return investment;
    }

    public InvestmentWallet findWalletByAccountPix(final String pix) {
        return wallets.stream()
                .filter(w -> w.getAccountWallet().getPix().contains(pix))
                .findFirst()
                .orElseThrow(
                    () -> new WalletNotFoundException("A carteira não foi encontrada")
                );
    }

    public InvestmentWallet deposit(final String pix, final long funds) {
        var wallet = findWalletByAccountPix(pix);
        wallet.addMoney(wallet.getAccountWallet().reduceMoney(funds),wallet.getBankService(), "Investimento");
        return wallet;
    }

    public InvestmentWallet withdraw(final String pix, final long funds){
        var wallet = findWalletByAccountPix(pix);
        checkFundsForTransaction(wallet, funds);
        wallet.getAccountWallet().addMoney(wallet.reduceMoney(funds), wallet.getBankService(), "saque de investimento");
        if(wallet.getFunds() == 0){
            wallets.remove(wallet);
        }
        return wallet;
    }

    public Investment findById(final long id){
        return investments.stream()
                .filter(a -> a.investmentId() == id)
                .findFirst()
                .orElseThrow(
                    () -> new InvestmentNotFoundException("O investimento '" + id + "' não foi encontrado")
                );
    }

    public InvestmentWallet initInvestment(final AccountWallet account, final long id) {
        if(!wallets.isEmpty()){
            var accountsInUse = wallets.stream()
                .map(InvestmentWallet::getAccountWallet)
                .toList();
            if(accountsInUse.contains(account)){
                throw new AccountWithInvestmentException("A conta '" + account + "' já possui um investimento");
            }
        }
        var investment = findById(id);
        checkFundsForTransaction(account, investment.initialFunds());
        var wallet = new InvestmentWallet(investment, account, investment.initialFunds());
        wallets.add(wallet);
        return wallet;
    }

    public void updateAmount() {
        wallets.forEach(w -> w.updateAmount(w.getInvestment().tax()));
    }

    public List<InvestmentWallet> listWallets(){
        return this.wallets;
    }

    public List<Investment> list(){
        return this.investments;
    } 
}
