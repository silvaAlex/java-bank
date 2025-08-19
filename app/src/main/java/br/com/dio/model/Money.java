package br.com.dio.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Money {
    private final List<MoneyAudit> histories = new ArrayList<>();

    public Money(final MoneyAudit history) {
        this.histories.add(history);
    }

    public void addHistory(final MoneyAudit history) {
        this.histories.add(history);
    }
}
