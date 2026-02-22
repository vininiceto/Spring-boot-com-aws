package br.com.vininiceto.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadas(@JsonAlias("totalSeasons") Integer seasons, @JsonAlias("Episodes") List<DadosEpisodio> episodios) {
}
