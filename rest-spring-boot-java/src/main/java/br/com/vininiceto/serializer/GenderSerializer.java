package br.com.vininiceto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        // Converte para M ou F
        switch (value.toLowerCase()) {
            case "male":
                gen.writeString("M");
                break;
            case "female":
                gen.writeString("F");
                break;
            default:
                gen.writeString(value); // fallback: mantém o valor original
        }
    }
}
