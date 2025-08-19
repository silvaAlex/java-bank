package br.com.dio.model;

import static br.com.dio.model.BankService.ACCOUNT;

import java.util.List;

import lombok.Getter;
@Getter
public class AccountWallet extends Wallet {

    private final List<String> pix;

    public AccountWallet(final List<String> pix) {
        super(ACCOUNT);
        this.pix = pix; 
    }

    public AccountWallet(final List<String> pix, final long amount) {
        super(ACCOUNT);
        this.pix = pix;
        addMoney(amount, "valor de criação da carteira");
    }
   
    public void addMoney(final long amount, final String description) {
        var money = generateMoney(amount, description);
        this.money.addAll(money);
    }
}
