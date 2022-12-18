package com.pr.util.service;

import com.pr.util.utility.InterfaceUtility;
import java.io.IOException;
import java.util.Scanner;

public final class ResetterService {

  private static PasswordResetterImplementation dropper;
  private final Scanner scanner = new Scanner(System.in);
  private final Scanner usernameScanner = new Scanner(System.in);
  private final Scanner passwordScanner = new Scanner(System.in);
  private final Scanner agreeScanner = new Scanner(System.in);

  private ResetterService() {

  }

  private ResetterService(PasswordResetterImplementation dropper) {
    ResetterService.dropper = dropper;
  }

  public static ResetterService initializeComponent(PasswordResetterImplementation dropper) {
    return new ResetterService(dropper);
  }

  public void start() throws IOException {

    System.out.println(InterfaceUtility.LOGO);
    System.out.println(InterfaceUtility.MENU);
    System.out.print(InterfaceUtility.ENTER);
    int categorySelector = scanner.nextInt();

    switch (categorySelector) {
      case 1:
        System.out.print(InterfaceUtility.USERS);
        dropper.getAllUsers().forEach(System.out::println);

        System.out.print(InterfaceUtility.USER_INFO_QUEST);
        String usernameChecker = agreeScanner.nextLine();

        switch (usernameChecker) {
          case InterfaceUtility.YES:

            System.out.print(InterfaceUtility.ENTER_USERNAME);
            String additionalUsername = usernameScanner.nextLine();

            dropper.getCurrentUserInfo(additionalUsername);

            System.out.print(InterfaceUtility.CONFIRMATION);
            String agreeChecker = agreeScanner.nextLine();

            switch (agreeChecker) {
              case InterfaceUtility.YES:
                System.out.print(InterfaceUtility.ENTER_NEW_PASSWORD);
                String newPassword = passwordScanner.nextLine();

                dropper.refreshCurrentUserPassword(additionalUsername, newPassword);
                break;
              case InterfaceUtility.NO:
                System.out.println(InterfaceUtility.LOGGING_OUT);
                break;
              default:
                System.out.println(InterfaceUtility.DEFAULT_ERROR);
                break;

            }

            break;
          case InterfaceUtility.NO:
            System.out.println(InterfaceUtility.LOGGING_OUT);
            break;
          default:
            System.out.println(InterfaceUtility.DEFAULT_ERROR);
            break;
        }

        break;

      case 2:
        System.out.print(InterfaceUtility.ENTER_USERNAME);
        String username = usernameScanner.nextLine();

        dropper.getCurrentUserInfo(username);

        System.out.print(InterfaceUtility.CONFIRMATION);

        String agreeChecker = agreeScanner.nextLine();

        switch (agreeChecker) {
          case InterfaceUtility.YES:
            System.out.print(InterfaceUtility.ENTER_NEW_PASSWORD);
            String password = passwordScanner.nextLine();

            dropper.refreshCurrentUserPassword(username, password);
            break;
          case InterfaceUtility.NO:
            System.out.println(InterfaceUtility.LOGGING_OUT);
            break;
          default:
            System.out.println(InterfaceUtility.DEFAULT_ERROR);
            break;
        }

        break;
      case 3:
        System.out.print(InterfaceUtility.ENTER_USERNAME);
        String username2 = usernameScanner.nextLine();
        System.out.print(InterfaceUtility.ENTER_NEW_PASSWORD);
        String newPassword = passwordScanner.nextLine();

        dropper.refreshCurrentUserPassword(username2, newPassword);
        break;
      case 4:
        break;
      default:
        System.out.print(InterfaceUtility.DEFAULT_ERROR);
        break;
    }
  }

}
