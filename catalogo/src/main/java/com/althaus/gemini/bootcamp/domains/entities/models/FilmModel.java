package com.althaus.gemini.bootcamp.domains.entities.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.althaus.gemini.bootcamp.domains.entities.Category;
import com.althaus.gemini.bootcamp.domains.entities.Film;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Value;

@Schema(name = "Pelicula (Detalles)", description = "Versión completa de las películas")
@Value
public class FilmModel {

    @Schema(description = "Identificador de la película", accessMode = AccessMode.READ_ONLY)
    private int filmId;

    @Schema(description = "Una breve descripción o resumen de la trama de la película")
    private String description;

    @Schema(description = "La duración de la película, en minutos")
    private Integer length;

    @Schema(description = "La clasificación por edades asignada a la película", allowableValues = {"G", "PG", "PG-13", "R", "NC-17"})
    private String rating;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    @Schema(description = "El año en que se estrenó la película")
    private Short releaseYear;

    @Schema(description = "La duración del período de alquiler, en días")
    private Byte rentalDuration;

    @Schema(description = "El coste de alquilar la película por el período establecido")
    private BigDecimal rentalRate;

    @Schema(description = "El importe cobrado al cliente si la película no se devuelve o se devuelve en un estado dañado")
    private BigDecimal replacementCost;

    @Schema(description = "El título de la película")
    private String title;

    @Schema(description = "El idioma de la película")
    private String language;

    @Schema(description = "El idioma original de la película")
    private String languageVO;

    @Schema(description = "Contenido Adicional")
    private List<String> specialFeatures;

    @Schema(description = "La lista de actores que participan en la película")
    private List<String> actors;

    @Schema(description = "La lista de categorías asignadas a la película")
    private List<String> categories;

    public static FilmModel from(Film source) {
        return new FilmModel(
                source.getFilmId(),
                source.getDescription(),
                source.getLength(),
                source.getRating() == null ? null : source.getRating().getValue(),
                source.getReleaseYear(),
                source.getRentalDuration(),
                source.getRentalRate(),
                source.getReplacementCost(),
                source.getTitle(),
                source.getLanguage() == null ? null : source.getLanguage().getName(),
                source.getLanguageVO() == null ? null : source.getLanguageVO().getName(),
                source.getSpecialFeatures().stream().map(Film.SpecialFeature::getValue).sorted().collect(Collectors.toList()),
                source.getActors().stream().map(actor -> actor.getFirstName() + " " + actor.getLastName()).sorted().collect(Collectors.toList()),
                source.getCategories().stream().map(Category::getName).sorted().collect(Collectors.toList())
        );
    }

    public static Film from(FilmModel source) {
        Film film = new Film();
        film.setFilmId(source.getFilmId());
        film.setDescription(source.getDescription());
        film.setLength(source.getLength());
        film.setRating(source.getRating() == null ? null : Film.Rating.getEnum(source.getRating()));
        film.setReleaseYear(source.getReleaseYear());
        film.setRentalDuration(source.getRentalDuration());
        film.setRentalRate(source.getRentalRate());
        film.setReplacementCost(source.getReplacementCost());
        film.setTitle(source.getTitle());
        film.setSpecialFeatures(source.getSpecialFeatures().stream().map(Film.SpecialFeature::getEnum).collect(Collectors.toSet()));
        return film;
    }
}