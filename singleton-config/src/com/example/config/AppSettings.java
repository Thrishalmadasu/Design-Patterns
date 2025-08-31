package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public final class AppSettings implements Serializable {
    private final Properties props = new Properties();
    private static volatile AppSettings instance;
    
    private AppSettings() { } // made it private for true singleton

    public static AppSettings getInstance() {
        if(instance == null) {
            synchronized(AppSettings.class) {
                if(instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
