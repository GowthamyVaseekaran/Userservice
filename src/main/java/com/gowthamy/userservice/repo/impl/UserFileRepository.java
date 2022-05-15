package com.gowthamy.userservice.repo.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gowthamy.userservice.error.UserServiceExceptionFactory;
import com.gowthamy.userservice.model.User;
import com.gowthamy.userservice.repo.UserRepo;
import com.gowthamy.userservice.util.SequenceNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Repository
@Slf4j
public class UserFileRepository implements UserRepo {

    private static final Logger logger = LoggerFactory.getLogger(UserFileRepository.class);

    @Value("${user.repo.file.path}")
    private String userRepositoryPath;

    private static final char SPLITTER = '_';

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private final SequenceNumberGenerator sequenceNumberGenerator;

    public UserFileRepository(SequenceNumberGenerator sequenceNumberGenerator) {
        this.sequenceNumberGenerator = sequenceNumberGenerator;
    }


    @Override
    public void save(List<User> users) {
        Path path = Paths.get(userRepositoryPath);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            log.error("Error while creating directory", e);
            throw UserServiceExceptionFactory.genericError("");
        }

        String filePath = userRepositoryPath + getFileName() + ".json";

        try (FileWriter writer = new FileWriter(filePath)) {
            GSON.toJson(users, writer);
            log.info("Successfully written file path {}", filePath);
        } catch (Exception e) {
            logger.error("Error occurred while saving request", e);
            throw UserServiceExceptionFactory.genericError("");
        }
    }

    private String getFileName() {
        long count = sequenceNumberGenerator.getSequenceNumber();
        LocalDate currentDate = LocalDate.now();
        return String.valueOf(currentDate.getYear()) +
                SPLITTER +
                currentDate.getMonthValue() +
                SPLITTER +
                currentDate.getDayOfMonth() +
                SPLITTER +
                count;
    }

}
