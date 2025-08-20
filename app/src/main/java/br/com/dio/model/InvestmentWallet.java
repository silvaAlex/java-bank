package br.com.dio.model;

import static br.com.dio.model.BankService.INVESTMENT;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import lombok.Getter;

@Getter
public class InvestmentWallet extends Wallet    {

    private final Investment investment;
    private final AccountWallet accountWallet;

    public InvestmentWallet(final Investment investment, final AccountWallet accountWallet, final long amount) {
        super(INVESTMENT);
        this.investment = investment;
        this.accountWallet = accountWallet;
        addMoney(accountWallet.reduceMoney(amount), getBankService(), "Investimento realizado");
    }

    public void updateAmount(final long percent) {
        var amount = getFunds() * percent / 100;
        var history = new MoneyAudit(UUID.randomUUID(), getBankService(),"rendimentos", OffsetDateTime.now());

        var newMoney  = Stream.generate(() -> new Money(history))
            .limit(amount)
            .toList();
        this.money.addAll(newMoney);
    }

    @Override
    public String toString() {
        return super.toString() + "InvestmentWallet {" +
            "investment=" + investment +
            ", account=" + accountWallet +
            "}";
    }
}
