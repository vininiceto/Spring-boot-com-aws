package br.com.alura.screenmatch.models;

public class Series extends Titulo {

    private Integer seasons;
    private Integer episodesPerSeasons;
    private Boolean active;
    private Integer minutesPerEpisode;

    public Series(String name, Integer releaseYear, Boolean includedPlan, Double someAvaliation, Integer totalAvaliation, Integer durationMinutes, Integer seasons, Boolean active, Integer episodesPerSeasons, Integer minutesPerEpisode) {
        super(name, releaseYear, includedPlan, someAvaliation, totalAvaliation, durationMinutes);
        this.seasons = seasons;
        this.active = active;
        this.episodesPerSeasons = episodesPerSeasons;
        this.minutesPerEpisode = minutesPerEpisode;
    }

    public Series() {
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Integer getEpisodesPerSeasons() {
        return episodesPerSeasons;
    }

    public void setEpisodesPerSeasons(Integer episodesPerSeasons) {
        this.episodesPerSeasons = episodesPerSeasons;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(Integer minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public Integer getDurationMinutes() {
        return seasons * episodesPerSeasons * minutesPerEpisode;
    }


}
