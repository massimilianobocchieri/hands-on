package clients;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import api.builder.QueryBuilder;
import json.JacksonJavaToJsonConverter;
import json.JavaToJsonConverter;

public class Test {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		// Use Dependency Inversion/Injection to avoid tight coupling
		JavaToJsonConverter javaToJsonConverter = new JacksonJavaToJsonConverter();
		QueryBuilder builder = new QueryBuilder();


		System.out.println("JAVA version...");
		System.out.println("builder.bool().mustMatch(\"item\", \"Milk\").mustMatch(\"item_type\", \"Dairy\")");
		System.out.println("builder.bool().shouldMatch(\"product_location\", \"New Mexico\").shouldMatch(\"warehouse_number\", 37);");

		builder.bool().mustMatch("item", "Milk").mustMatch("item_type", "Dairy");
		builder.bool().shouldMatch("product_location", "New Mexico").shouldMatch("warehouse_number", 37);

		System.out.println();
		System.out.println("JSON version...");
		System.out.println(builder.toJSON(javaToJsonConverter));

		System.out.println();
		builder.clean();

		System.out.println("JAVA version...");
		System.out.println("builder.bool().shouldMatch(\"lot_number\", 307).bool().mustMatch(\"expiry_date\", \"Jan 2020\");");

		builder.bool().shouldMatch("lot_number", 307).bool().mustMatch("expiry_date", "Jan 2020");

		System.out.println();
		System.out.println("JSON version...");
		System.out.println(builder.toJSON(javaToJsonConverter));
		
	}

}
