import java.util.Random;
import java.util.Scanner;

public class JogaJogoDaVelha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao teste do Jogo da Velha!");
        System.out.println("Digite 1 para jogar ou 0 para sair: ");
        int opcao = scanner.nextInt();
        while (opcao!=0) {
            
            int tamanho;
  
            System.out.print("Digite o tamanho do tabuleiro ");
            tamanho = scanner.nextInt();
                

            JogoDaVelha jogo = new JogoDaVelha(tamanho);

            while (jogo.vencedor() == 0 && !empate(jogo)) {
                int linha, coluna;
                do {
                    linha = random.nextInt(tamanho);
                    coluna = random.nextInt(tamanho);
                } while (jogo.tabuleiro[linha][coluna] != JogoDaVelha.VAZIO);

                jogo.poePeca(linha, coluna);
               
            }

            System.out.println(jogo);

            int vencedor = jogo.vencedor();
            if (vencedor == 1) System.out.println("1");
            else if (vencedor == -1) System.out.println("-1");
            else System.out.println("0");

            System.out.println("Deseja jogar novamente? (1-sim, 0-nao): ");
            opcao = scanner.nextInt();
        } 
    }
    
    public static boolean empate(JogoDaVelha jogo) {
        for (int i = 0; i < jogo.tabuleiro.length; i++)
            for (int j = 0; j < jogo.tabuleiro.length; j++)
                if (jogo.tabuleiro[i][j] == JogoDaVelha.VAZIO)
                    return false;
        return jogo.vencedor() == 0;
    }
}
