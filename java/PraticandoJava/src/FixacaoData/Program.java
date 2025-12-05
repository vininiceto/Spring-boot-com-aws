package FixacaoData;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Program {

    public static void main(String[] args) {

        LocalDate dataAtual = LocalDate.now();

        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");


        System.out.println(dataAtual.format(dtm));
        System.out.println(dataAtual);
        System.out.println();

        String dataString = "2023-01-17";
        String stringData = "17-01-2023";


        LocalDate dataConcreta = LocalDate.parse(dataString, formatter);
        LocalDate dataTeste = LocalDate.parse(stringData, dtm);


        System.out.println(dataConcreta.isBefore(dataAtual));


        System.out.println(dataConcreta.format(formatter));
        System.out.println(dataTeste.format(formatter));


        LocalTime horaAtual = LocalTime.now();

        System.out.println(horaAtual.format(timeFormatter));

        LocalTime horaAtualTeste = horaAtual.plusMinutes(60);

        System.out.println(horaAtualTeste);


        // Suponha que você recebeu uma data em GMT
        String dataGMT = "2023-01-17T14:00:00";
        DateTimeFormatter tester = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // Interpreta como GMT
        ZonedDateTime gmtDateTime = ZonedDateTime.of(
                java.time.LocalDateTime.parse(dataGMT, tester),
                ZoneId.of("GMT")
        );

        // Converte para UTC
        ZonedDateTime utcDateTime = gmtDateTime.withZoneSameInstant(ZoneId.of("UTC"));

        System.out.println("GMT: " + gmtDateTime);
        System.out.println("UTC: " + utcDateTime);

    }




}
