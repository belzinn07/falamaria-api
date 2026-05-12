package com.falamaria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

//qual é o tipo de dado de data_envio de denuncia? no banco de dados, data_envio é do tipo timestamp, mas no código Java, o tipo de dado utilizado para representar data e hora é geralmente java.util.Date ou java.time.LocalDateTime. A escolha entre esses tipos depende do contexto e das necessidades específicas do projeto.
// mas qual o mais compativel com o tipo timestamp do banco de dados? O tipo mais compatível para representar um timestamp do banco de dados em Java é o java.time.LocalDateTime, que foi introduzido no Java 8 como parte da API de data e hora. Ele oferece uma representação mais precisa e rica de data e hora em comparação com java.util.Date, que é considerado obsoleto. LocalDateTime é recomendado para uso em projetos modernos, especialmente quando se trabalha com bancos de dados que utilizam timestamps	
// e o  `status` varchar(20) DEFAULT 'pendente'? O campo `status` do tipo `varchar(20) DEFAULT 'pendente'` no banco de dados é uma string que pode conter até 20 caracteres. Ele tem um valor padrão de 'pendente', o que significa que, se nenhum valor for fornecido ao inserir um registro, ele será automaticamente definido como 'pendente'.
// No código Java, o tipo de dado mais adequado para representar esse campo seria `String`, já que ele é usado para armazenar texto. Você pode definir o campo `status` em sua classe Java como uma variável do tipo `String` e, ao criar um novo objeto, pode atribuir o valor 'pendente' como padrão, se necessário. Por exemplo:
// private String status = "pendente";
// mas e se eu quiser usar enum para representar os status? Se você quiser usar um enum para representar os status, pode criar um enum em Java que contenha os valores possíveis para o campo `status`. Isso ajuda a garantir que apenas valores válidos sejam atribuídos ao campo e torna o código mais legível. Aqui está um exemplo de como você pode fazer isso:	
// Definindo o enum para os status
public enum Status {
	PENDENTE,	
	APROVADO,
	REJEITADO
}
// Em seguida, você pode usar esse enum em sua classe para representar o campo `status`
public class Denuncia {
	private Status status = Status.PENDENTE; // Valor padrão	
	// outros campos e métodos
}
// Com essa abordagem, você pode atribuir os valores do enum diretamente ao campo `status`, garantindo que apenas os valores definidos no enum sejam usados. Por exemplo:
// Denuncia denuncia = new Denuncia();
// denuncia.setStatus(Status.APROVADO); // Atribuindo um valor do enum
//`avaliacao` tinyint(3) UNSIGNED NOT NULL, o campo `avaliacao` do tipo `tinyint(3) UNSIGNED NOT NULL` no banco de dados é um número inteiro pequeno que pode armazenar valores de 0 a 255. Ele é usado para representar uma avaliação ou classificação, onde cada valor pode ter um significado específico (por exemplo, 0 para "ruim", 1 para "regular", 2 para "bom", etc.).
// No código Java, o tipo de dado mais adequado para representar esse campo seria `int`, já que ele é usado para armazenar números inteiros. Você pode definir o campo `avaliacao` em sua classe Java como uma variável do tipo `int`. Por exemplo:
// private int avaliacao;
// Certifique-se de validar os valores atribuídos a `avaliacao` para garantir que eles estejam dentro do intervalo permitido (0 a 255) para evitar erros de banco de dados. Você pode fazer isso usando uma lógica de validação em seus métodos de definição (setters) ou durante a inserção de dados. Por exemplo:
// public void setAvaliacao(int avaliacao) {
//	 if (avaliacao < 0 || avaliacao > 255) {
//         throw new IllegalArgumentException("A avaliação deve estar entre 0 e 255.");
//     }
//     this.avaliacao = avaliacao;
// }

//  `arquivo` varchar(255) DEFAULT NULL, o campo `arquivo` do tipo `varchar(255) DEFAULT NULL` no banco de dados é uma string que pode conter até 255 caracteres. Ele é usado para armazenar o caminho ou nome de um arquivo associado à denúncia. O valor padrão é `NULL`, o que significa que, se nenhum valor for fornecido ao inserir um registro, ele será definido como `NULL` (sem valor).
// No código Java, o tipo de dado mais adequado para representar esse campo seria `String`, já que ele é usado para armazenar texto. Você pode definir o campo `arquivo` em sua classe Java como uma variável do tipo `String`. Por exemplo:
// private String arquivo;
// Certifique-se de que, ao atribuir um valor a `arquivo`, ele seja uma string válida que represente o caminho ou nome do arquivo, e que possa ser `null` se não houver um arquivo associado à denúncia.
 