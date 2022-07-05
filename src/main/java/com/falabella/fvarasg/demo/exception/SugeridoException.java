package com.falabella.fvarasg.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

public class SugeridoException extends RuntimeException {

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class BusquedaItem extends RuntimeException {
        private final transient Map<String, Object> map;
    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class CrearSolicitud extends RuntimeException {
        public CrearSolicitud(Throwable cause) {
            super(cause);
        }
    }

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class ErrorSolicitud extends RuntimeException {
        private final transient Map<String, Object> map;
    }
}
