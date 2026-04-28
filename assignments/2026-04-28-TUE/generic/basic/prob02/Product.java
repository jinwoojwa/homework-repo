package day0428.generic.basic.prob02;

public class Product<K> {
    private K kind;
    private String model;

    public K getKind() {
        return kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
