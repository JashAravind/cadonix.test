package arcadia.constants;

public enum EndPoint {
    TRAINING("mercury1_21_1/"),
    PROJECT("/index.lp?app=projects2&appoption=10&project=2&projName=projectName"),
    PROFILE("/index.lp??app=generaledit&profilecode=profileName"),
    SLEEVETUBE("/index.lp?app=componentsv2&form=sleevetube&company=CADONIX&database=databaseName"),
    HARNESSBUNDLEDISPLAY("/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=profileName"),
    SETTINGS("/index.lp?menu=settings"),
    COMPONENTDB("/index.lp?app=componentsv2&database=databaseName"),
    AutomationCompanyProfile("/index.lp?app=generaledit&profilecode=Automation"),
    BUNDLEDEFAULTDISPLAY("/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=Automation");
    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}