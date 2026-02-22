package br.com.vininiceto.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String title, @JsonAlias("Episode") Integer numEpisode, @JsonAlias("imdbRating") String avaliation, @JsonAlias("Released") String launchDate) {
}
