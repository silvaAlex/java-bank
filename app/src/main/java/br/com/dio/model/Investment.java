package br.com.dio.model;

public record Investment(
    long investmentId,
    long tax,
    long initialFunds
) {
    @Override
    public final String toString() {
        return "Investment{" + 
            "investmentId=" + investmentId +
            "tax=" + tax +"%" +
            "initialFunds=" + (initialFunds / 100) + "," + (initialFunds % 100) + "}"
        ;
    }
}
