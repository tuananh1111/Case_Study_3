package model;

public class TypeOfSupplement {
    private String typeId;
    private String typeName;
    private String taste;
    private String status;

    public TypeOfSupplement() {
    }

    public TypeOfSupplement(String typeName, String taste, String status) {
        this.typeName = typeName;
        this.taste = taste;
        this.status = status;
    }

    public TypeOfSupplement(String typeId, String typeName, String taste, String status) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.taste = taste;
        this.status = status;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
