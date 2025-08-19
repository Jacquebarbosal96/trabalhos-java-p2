package taxes;

public class Company extends Person {
    private int worker;

    public Company(String name, double rendaAnual, int worker) {
        super(name, rendaAnual);
        this.worker = worker;
    }

    public void calcularTaxa() {
        if (this.worker > 10) { 
            super.setTax(super.getRendaAnual() * 0.14); 
        } else { 
            super.setTax(super.getRendaAnual() * 0.16); 
        }
        if (super.getTax() <= 0) { 
            super.setTax(0); 
        }
    }
}