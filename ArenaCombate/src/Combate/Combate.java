package Combate;

import java.util.Scanner;

class Campeao {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    // Construtor da classe Campeao
    public Campeao(String nome, int vida, int ataque, int armadura) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    // Método para receber dano
    public void takeDamage(int ataqueInimigo) {
        int dano = ataqueInimigo - this.armadura;
        if (dano < 1) {
            dano = 1; // Dano mínimo é 1
        }
        this.vida = Math.max(this.vida - dano, 0); // Vida não pode ser negativa
    }

    // Método para obter o status do campeão
    public String status() {
        if (this.vida > 0) {
            return this.nome + ": " + this.vida + " de vida";
        } else {
            return this.nome + ": 0 de vida (morreu)";
        }
    }

    // Método para verificar se o campeão ainda está vivo
    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Getter para ataque
    public int getAtaque() {
        return this.ataque;
    }
}

public class Combate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação do primeiro campeão
        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String nome1 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida1 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque1 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura1 = scanner.nextInt();
        Campeao campeao1 = new Campeao(nome1, vida1, ataque1, armadura1);

        // Criação do segundo campeão
        scanner.nextLine(); // Limpar buffer
        System.out.println("Digite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String nome2 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida2 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque2 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura2 = scanner.nextInt();
        Campeao campeao2 = new Campeao(nome2, vida2, ataque2, armadura2);

        // Solicita o número de turnos
        System.out.print("Quantos turnos você deseja executar? ");
        int turnos = scanner.nextInt();

        // Loop de combate
        for (int i = 1; i <= turnos; i++) {
            System.out.println("\nResultado do turno " + i + ":");
            
            // Campeões atacam um ao outro
            campeao1.takeDamage(campeao2.getAtaque());
            campeao2.takeDamage(campeao1.getAtaque());

            // Exibir status de cada campeão
            System.out.println(campeao1.status());
            System.out.println(campeao2.status());

            // Verifica se algum campeão morreu
            if (!campeao1.estaVivo() || !campeao2.estaVivo()) {
                System.out.println("\n### FIM DO COMBATE ###");
                break;
            }
        }

        if (campeao1.estaVivo() && campeao2.estaVivo()) {
            System.out.println("\n### FIM DO COMBATE ###");
        }

        scanner.close();
    }
}
