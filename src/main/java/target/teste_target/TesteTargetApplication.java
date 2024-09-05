package target.teste_target;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TesteTargetApplication {

	public static void main(String[] args) {
		String file = "/home/everton/Documentos/faturamentoMensal.json";

		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			Gson gson = new Gson();
			List<Faturamento> faturamentoList = gson.fromJson(bf, new TypeToken<List<Faturamento>>() {
			}.getType());


			Faturamento diaMenorValor = faturamentoList.stream().filter(f -> f.getValor() > 0)
					.min(Comparator.comparingDouble(Faturamento::getValor)).get();

			Faturamento diaMaiorValor = faturamentoList.stream().max(Comparator.comparingDouble(Faturamento::getValor))
					.get();

			double mediaMensal = faturamentoList.stream().map(f -> f.getValor()).reduce(0.0, (a, b) -> a + b)
					/ faturamentoList.stream().filter(f -> f.getValor() > 0).count();
			
			long diasAcimaDaMedia = faturamentoList.stream().filter(f -> f.getValor() > mediaMensal).count();

			System.out.println("O menor valor foi no dia " + diaMenorValor.getDia() + " e o valor foi R$"
					+ diaMenorValor.getValor());
			
			System.out.println("O maior valor foi no dia " + diaMaiorValor.getDia() + " e o valor foi R$"
					+ diaMaiorValor.getValor());
			
			System.out.println("A quantidade de dias acima da media foi: " + diasAcimaDaMedia);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
