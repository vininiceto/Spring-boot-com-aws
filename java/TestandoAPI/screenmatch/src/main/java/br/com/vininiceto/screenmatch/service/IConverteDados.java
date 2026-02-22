package br.com.vininiceto.screenmatch.service;

public interface IConverteDados {

    <T> T converteDados(String json, Class<T> classe);
}
