package br.com.vininiceto.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String title, Integer totalSeasons,
                         @JsonAlias("imdbRating") String avaliation, List<DadosEpisodio> episodes) {
}
