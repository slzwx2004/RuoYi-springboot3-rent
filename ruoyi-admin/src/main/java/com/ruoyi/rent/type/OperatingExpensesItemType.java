package com.ruoyi.rent.type;

public enum OperatingExpensesItemType {

    WARTER_FEE("1", "水费", 6),//6元/吨
    ELECTRICITY_FEE("2", "电费", 1);//1元/度

    private String value;
    private String name;

    private double fee;

    OperatingExpensesItemType(String value, String name, double fee) {
        this.value = value;
        this.name = name;
        this.fee = fee;
    }


    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }
}
