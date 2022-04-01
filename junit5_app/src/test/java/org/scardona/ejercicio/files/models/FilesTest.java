package org.scardona.ejercicio.files.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FilesTest {

    @Test
    void fixFiles() {
        List<String> files = Arrays.asList("photo", "postcard", "photo", "photo", "video");
        List<String> expected = Arrays.asList("photo", "postcard", "photo(1)", "photo(2)", "video");

        assertEquals(expected, Files.fixFiles(files));
    }
    @Test
    void fixFiles2() {
        List<String> files = Arrays.asList("file", "file", "file", "game", "game");
        List<String> expected = Arrays.asList("file", "file(1)", "file(2)", "game", "game(1)");

        assertEquals(expected, Files.fixFiles(files));
    }


    @Test
    void fixFiles3() {
        List<String> files = Arrays.asList("file", "file(1)", "icon", "icon(1)", "icon(1)");
        List<String> expected = Arrays.asList("file", "file(1)", "icon", "icon(1)", "icon(1)(1)");

        assertEquals(expected, Files.fixFiles(files));
    }
}