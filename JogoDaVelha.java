public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int[][] tabuleiro;
    protected int jogador;
    protected int tamanho;

    public JogoDaVelha(int tamanho) {
        this.tamanho = tamanho;
        tabuleiro = new int[tamanho][tamanho];
        limpaTabuleiro();
    }

    public void limpaTabuleiro() {
        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < tamanho; j++)
                tabuleiro[i][j] = VAZIO;
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i < 0 || i >= tamanho || j < 0 || j >= tamanho)
            throw new IllegalArgumentException("Posição Inválida");
        if (tabuleiro[i][j] != VAZIO)
            throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j] = jogador;
        jogador = -jogador;
    }

    public int vencedor() {
        for (int i = 0; i < tamanho; i++) {
            int somaLinha = 0;
            int somaColuna = 0;
            for (int j = 0; j < tamanho; j++) {
                somaLinha += tabuleiro[i][j];
                somaColuna += tabuleiro[j][i];
            }
            if (somaLinha == X * tamanho || somaColuna == X * tamanho)
                return 1;
            if (somaLinha == O * tamanho || somaColuna == O * tamanho)
                return -1;
        }


        int diagonalPrincipal = 0;
        int diagonalSecundaria = 0;
        for (int i = 0; i < tamanho; i++) {
            diagonalPrincipal += tabuleiro[i][i];
            diagonalSecundaria += tabuleiro[i][tamanho - 1 - i];
        }
        if (diagonalPrincipal == X * tamanho || diagonalSecundaria == X * tamanho)
            return 1;
        if (diagonalPrincipal == O * tamanho || diagonalSecundaria == O * tamanho)
            return -1;

        return 0; 
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); // usei esse string builder porque é melhor pra mostrar o resultado
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                switch (tabuleiro[i][j]) {
                    case X: sb.append(" X "); break;
                    case O: sb.append(" O "); break;
                    default: sb.append("   ");
                }
                if (j < tamanho - 1) sb.append("|");
            }
            sb.append("\n");
            if (i < tamanho - 1) {
                for (int k = 0; k < tamanho; k++) {
                    sb.append("---");
                    if (k < tamanho - 1) sb.append("+");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
