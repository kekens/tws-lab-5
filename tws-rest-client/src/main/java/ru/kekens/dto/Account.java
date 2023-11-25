package ru.kekens.dto;


import java.util.Objects;

/**
 * Счет
 */
public class Account {

    /**
     * Идентификатор счета
     */
    private Long id;

    /**
     * Наименование счета
     */
    private String label;

    /**
     * Код счета
     */
    private String code;

    /**
     * Категория
     */
    private String category;

    /**
     * Остаток счета
     */
    private String amount;

    /**
     * Дата открытия
     */
    private String openDate;

    public Account() {}

    public Account(Long id, String label, String code, String category, String amount, String openDate) {
        this.id = id;
        this.label = label;
        this.code = code;
        this.category = category;
        this.amount = amount;
        this.openDate = openDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(label, account.label) &&
                Objects.equals(code, account.code) &&
                Objects.equals(category, account.category) &&
                Objects.equals(amount, account.amount) &&
                Objects.equals(openDate, account.openDate);
    }

}
