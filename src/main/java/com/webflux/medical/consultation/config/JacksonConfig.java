package com.webflux.medical.consultation.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import com.webflux.medical.consultation.enums.Gender;
import com.webflux.medical.consultation.enums.MaritalStatus;
import com.webflux.medical.consultation.enums.MedicalSpeciality;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@AllArgsConstructor
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper(){

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);


        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);


        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(SpecialityModuleMapper());
        objectMapper.registerModule(StatusModuleMapper());
        objectMapper.registerModule(GenderModuleMapper());
        return objectMapper;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-==-=--

    public SimpleModule SpecialityModuleMapper(){
        SimpleModule dateModule = new SimpleModule("JsonSpecialityTypeModule", PackageVersion.VERSION);
        dateModule.addSerializer(MedicalSpeciality.class,new SpecialitySerialize());
        dateModule.addDeserializer(MedicalSpeciality.class,new SpecialityDeserialize());
        return dateModule;
    }
    static class SpecialitySerialize extends StdSerializer<MedicalSpeciality> {

        public SpecialitySerialize(){
            super(MedicalSpeciality.class);
        }

        @Override
        public void serialize(MedicalSpeciality speciality, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(speciality.getSpeciality());
        }
    }
    static class SpecialityDeserialize extends StdDeserializer<MedicalSpeciality> {


        protected SpecialityDeserialize() {
            super(MedicalSpeciality.class);
        }

        @Override
        public MedicalSpeciality deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return MedicalSpeciality.of(jsonParser.getText());
        }
    }

    //-=-=-=-=-=-===--=-=-=--=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-==-=-

    public SimpleModule StatusModuleMapper(){
        SimpleModule dateModule = new SimpleModule("JsonMaritalStatusTypeModule", PackageVersion.VERSION);
        dateModule.addSerializer(MaritalStatus.class,new StatusSerialize());
        dateModule.addDeserializer(MaritalStatus.class,new StatusDeserialize());
        return dateModule;
    }
    class StatusSerialize extends StdSerializer<MaritalStatus> {

        public StatusSerialize(){
            super(MaritalStatus.class);
        }

        @Override
        public void serialize(MaritalStatus status, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(status.getStatus());
        }
    }
    static class StatusDeserialize extends StdDeserializer<MaritalStatus> {


        protected StatusDeserialize() {
            super(MedicalSpeciality.class);
        }

        @Override
        public MaritalStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return MaritalStatus.of(jsonParser.getText());
        }
    }


    //-=-=-==-=-=-=-=--=-=-==-=-=-=-=-==--=-=-=-=-===-=-=-=-=-=-=-=-=--=-=-=-=-=-=-==-==

    public SimpleModule GenderModuleMapper(){
        SimpleModule dateModule = new SimpleModule("JsonGenderTypeModule", PackageVersion.VERSION);
        dateModule.addSerializer(Gender.class,new GenderSerialize());
        dateModule.addDeserializer(Gender.class,new GenderDeserialize());
        return dateModule;
    }
    static class GenderSerialize extends StdSerializer<Gender> {

        public GenderSerialize(){
            super(Gender.class);
        }

        @Override
        public void serialize(Gender gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(gender.getGender());
        }
    }
    static class GenderDeserialize extends StdDeserializer<Gender> {


        protected GenderDeserialize() {
            super(Gender.class);
        }

        @Override
        public Gender deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return Gender.ofGender(jsonParser.getText());
        }
    }
}
