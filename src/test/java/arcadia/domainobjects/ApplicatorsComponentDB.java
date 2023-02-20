package arcadia.domainobjects;

public class ApplicatorsComponentDB {

    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String applicatorusage;
    private String forsealorterminal;
    private String applicatorinservice;
    private String applicatorsite;
    public ApplicatorsComponentDB() {
    }
    public ApplicatorsComponentDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String applicatorUsage, String forSealOrTerminal, String inService, String applicatorSite) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierpn = supplierPN;
        this.colour = colour;
        this.applicatorusage = applicatorUsage;
        this.forsealorterminal = forSealOrTerminal;
        this.applicatorinservice = inService;
        this.applicatorsite = applicatorSite;
    }

    public String getPartNumber() {
        return partnumber;
    }

    public void setPartNumber(String partNumber) {
        this.partnumber = partNumber;
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
        return supplierpn;
    }

    public void setSupplierPN(String supplierPN) {
        this.supplierpn = supplierPN;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getApplicatorUsage() {
        return applicatorusage;
    }

    public void setApplicatorUsage(String applicatorUsage) {
        this.applicatorusage = applicatorUsage;
    }

    public String getForSealOrTerminal() {
        return forsealorterminal;
    }

    public void setForSealOrTerminal(String forSealOrTerminal) {
        this.forsealorterminal = forSealOrTerminal;
    }

    public String getInService() {
        return applicatorinservice;
    }

    public void setInService(String inService) {
        this.applicatorinservice = inService;
    }

    public String getApplicatorSite() {
        return applicatorsite;
    }

    public void setApplicatorSite(String applicatorSite) {
        this.applicatorsite = applicatorSite;
    }
}