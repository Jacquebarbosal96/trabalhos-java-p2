package estoque;

import java.util.Scanner; //sempre q precisar ler tem q ter isso 

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in); //criei um objeto dessa classe scanner

        Product produto = new Product();

        //recebendo os dados do teclado
        System.out.println("Enter product data: ");

        System.out.print("Name: ");
        produto.name = scan.nextLine();

        System.out.print("Price: ");
        produto.price = scan.nextDouble();

        scan.nextLine();

        System.out.print("Quantity in stock: ");
        produto.qtdestoque = scan.nextInt();

        //mostrando primeiro os dados "iniciais" do produto
        System.out.println(produto);
        
        //pra eu adicionar produtos novos ao estoque
        System.out.println("Enter the number of products to be added in stock: ");
        int produtosadd = scan.nextInt();
        produto.addprodutos(produtosadd);

        //agora exibo os dados atualizados
        System.out.println("Updated data: " + produto);

        //agora removerei os produtos
        System.out.println("Enter the number of products to be removed from stock: ");
        int produtosremoved = scan.nextInt();
        produto.removerprodutos(produtosremoved);

        //mostro de novo os dados, agora atualizados de novo
        System.out.println("Updated Data: " + produto);

        scan.close();

}
}