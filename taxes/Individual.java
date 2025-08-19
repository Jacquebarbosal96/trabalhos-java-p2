package taxes;

public class Individual extends Person {
    private double health;

    public Individual (String name, double rendaAnual, double health) {
        super(name, rendaAnual);
        this.health = health;
    }

    public void calcularTaxa() {
        if (super.getRendaAnual() < 20000) { 
            super.setTax(super.getRendaAnual() * 0.15); 
        } else { 
            super.setTax(super.getRendaAnual() * 0.25); 
        }
        super.setTax(super.getTax() - health * 0.5);
        if (super.getTax() <= 0) { 
            super.setTax(0); 
        }
    }
}