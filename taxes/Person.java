package taxes;

abstract class Person {
    private String name;
    private double rendaAnual;
    private double tax;

    public Person (String name, double rendaAnual) {
        this.name = name;
        this.rendaAnual = rendaAnual;
        this.tax = 0;
    }

    public String getName () {
        return this.name;
    }

    public double getRendaAnual () {
        return this.rendaAnual;
    }

    public double getTax () {
        return this.tax;
    }

    public void setTax (double tax) {
        this.tax = tax;
    }
}