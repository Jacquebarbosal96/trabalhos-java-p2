package estoque;

public class Product {
    String name;
    double price;
    int qtdestoque;

double valortotal() {
    return price * qtdestoque;
}

void addprodutos(int produtosadd){
    this.qtdestoque += produtosadd;
}

void removerprodutos(int produtosremoved){
    this.qtdestoque -= produtosremoved;
}

//agora pra exibir os dados 
public String toString(){
    return String.format("Product data: %s, $ %.2f, %d units, Total: $ %.2f", name, price, qtdestoque, valortotal());
}

}

