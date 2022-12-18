package com.pr.util.service;

import static com.pr.util.utility.InterfaceCMD.*;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class PasswordResetterImplementation {

    private static ProcessBuilder commandsExecutor;

    public List<String> getAllUsers() throws IOException {

        commandsExecutor = new ProcessBuilder(
                CMD_EXE, SEPARATOR, CHANGE_CODING);

        Process netUserProcess = commandsExecutor.start();

        BufferedReader r = new BufferedReader(new InputStreamReader(netUserProcess.getInputStream()));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while (true) {
            line = r.readLine();

            if (line == null) {
                break;
            }

            if (line.contains(ADMINISTRATOR)) {
                String clearedString = StringUtils.normalizeSpace(line);

                stringBuilder.append(clearedString);
            }

        }

        return Arrays.asList(
            stringBuilder.toString().split(SPACE)
        );
    }

    public void getCurrentUserInfo(String userName) throws IOException {

        commandsExecutor = new ProcessBuilder(
                CMD_EXE, SEPARATOR, CHANGE_CODING + SPACE + userName);

        Process netUserProcess = commandsExecutor.start();

        BufferedReader r = new BufferedReader(new InputStreamReader(netUserProcess.getInputStream()));

        String line;

        while (true) {
            line = r.readLine();

            if (line == null || line.contains(MEMBERSHIP)) {
                break;
            }

            System.out.println(line);

        }
    }

    public void refreshCurrentUserPassword(String userName, String newPassword) throws IOException {
        commandsExecutor = new ProcessBuilder(
                CMD_EXE, SEPARATOR, CHANGE_CODING + SPACE + userName + SPACE + newPassword);

        Process netUserProcess = commandsExecutor.start();

        BufferedReader r = new BufferedReader(new InputStreamReader(netUserProcess.getInputStream()));

        String line;

        while (true) {
            line = r.readLine();

            if (line == null || line.contains(MEMBERSHIP)) {
                break;
            }

            System.out.println(line);

        }
    }
}
