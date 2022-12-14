package arcadia.domainobjects;

public class JunctionPartComponentDB {
    private String partNumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierPN;
    private String colour;
    private String controltype;
    private String material;
    private String wallthickness;
    public JunctionPartComponentDB() {

    }

    public JunctionPartComponentDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String controltype, String material, String wallthickness) {
        this.partNumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierPN = supplierPN;
        this.colour = colour;
        this.controltype = controltype;
        this.material = material;
        this.wallthickness = wallthickness;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierPN() {
        return supplierPN;
    }

    public void setSupplierPN(String supplierPN) {
        this.supplierPN = supplierPN;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getControltype() {
        return controltype;
    }

    public void setControltype(String controltype) {
        this.controltype = controltype;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getWallthickness() {
        return wallthickness;
    }

    public void setWallthickness(String wallthickness) {
        this.wallthickness = wallthickness;
    }
}