import java.io.IOException;
import java.util.Scanner;

public class Calculadora {

    private static final Scanner input = new Scanner(System.in);
    private static final Operacao[] operacaoList = new Operacao[4];
    private static final String[] operString = new String[4];
    static {
        operacaoList[0] = (a1,a2) -> a1+a2;
        operString[0] = "+";
        operacaoList[1] = (a1,a2) -> a1-a2;
        operString[1] = "-";
        operacaoList[2] = (a1,a2) -> a1*a2;
        operString[2] = "X";
        operacaoList[3] = (a1,a2) -> a1/a2;
        operString[3] = "/";
    }
    public static void main(String[] args) throws IOException {
        int op;
        System.out.println("Informe a operação:");
        System.out.println(" 01-soma \n 02-sub \n 03-mult \n 04-div \n 05-sair");
        System.out.print("digite uma opção: ");
        op = input.nextInt();
        if(op == 5) return;
        resultadoOperacao(operString[op-1],operacaoList[op-1]);
        System.in.read();
        Calculadora.main(null);
    }
    private static float pegarNumeros(int posicao){
        System.out.print("digite o " + posicao + "º: ");
        return input.nextFloat();
    }
    private static void resultadoOperacao(String operacao,Operacao calculo){
        float n1 = pegarNumeros(1);
        float n2 = pegarNumeros(2);
        System.out.println("---------------------------");
        System.out.println("| " + n1 + " " + operacao + " " + n2 + " " +
                " = " + calculo.teste(n1,n2) + "  |");
        System.out.println("---------------------------");
    }
}
interface Operacao{
    float teste(float n1, float n2);
}

