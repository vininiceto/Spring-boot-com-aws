package br.com.vininiceto.exception;

import java.time.LocalDateTime;
import java.util.Date;

public record ExpcetionResponse(String timestamp, String message, String details) {

}
