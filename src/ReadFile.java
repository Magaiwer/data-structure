import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Magaiver Santos
 */
public class ReadFile {
    public static void main(String[] args) {

        System.out.println("Informe o nome de arquivo texto:");
        String nome = "zips.txt";

        System.out.println("Conteúdo do arquivo texto:");
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha

            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
