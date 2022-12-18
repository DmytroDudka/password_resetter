package com.pr.util.service;

import com.pr.util.utility.InterfaceUI;
import java.io.IOException;
import java.util.Scanner;

public final class ResetterService {

  private static PasswordResetterImplementation dropper;
  private final Scanner scanner = new Scanner(System.in);
  private final Scanner usernameScanner = new Scanner(System.in);
  private final Scanner passwordScanner = new Scanner(System.in);
  private final Scanner confirmationScanner = new Scanner(System.in);

  private ResetterService() {

  }

  private ResetterService(PasswordResetterImplementation dropper) {
    ResetterService.dropper = dropper;
  }

  public static ResetterService initializeComponent(PasswordResetterImplementation dropper) {
    return new ResetterService(dropper);
  }

  public void start() throws IOException {

    System.out.println(InterfaceUI.LOGO);
    System.out.println(InterfaceUI.MENU);
    System.out.print(InterfaceUI.ENTER);
    int categorySelector = scanner.nextInt();

    switch (categorySelector) {
      case 1:
        System.out.print(InterfaceUI.USERS);
        dropper.getAllUsers().forEach(System.out::println);

        System.out.print(InterfaceUI.USER_INFO_QUEST);
        String usernameChecker = confirmationScanner.nextLine();

        switch (usernameChecker) {
          case InterfaceUI.YES:

            System.out.print(InterfaceUI.ENTER_USERNAME);
            String additionalUsername = usernameScanner.nextLine();

            dropper.getCurrentUserInfo(additionalUsername);

            System.out.print(InterfaceUI.CONFIRMATION);
            String confirmation = confirmationScanner.nextLine();

            switch (confirmation) {
              case InterfaceUI.YES:
                System.out.print(InterfaceUI.ENTER_NEW_PASSWORD);
                String newPassword = passwordScanner.nextLine();

                dropper.refreshCurrentUserPassword(additionalUsername, newPassword);
                break;
              case InterfaceUI.NO:
                System.out.println(InterfaceUI.LOGGING_OUT);
                break;
              default:
                System.out.println(InterfaceUI.DEFAULT_ERROR);
                break;

            }

            break;
          case InterfaceUI.NO:
            System.out.println(InterfaceUI.LOGGING_OUT);
            break;
          default:
            System.out.println(InterfaceUI.DEFAULT_ERROR);
            break;
        }

        break;

      case 2:
        System.out.print(InterfaceUI.ENTER_USERNAME);
        String username = usernameScanner.nextLine();

        dropper.getCurrentUserInfo(username);

        System.out.print(InterfaceUI.CONFIRMATION);

        String confirmation = confirmationScanner.nextLine();

        switch (confirmation) {
          case InterfaceUI.YES:
            System.out.print(InterfaceUI.ENTER_NEW_PASSWORD);
            String password = passwordScanner.nextLine();

            dropper.refreshCurrentUserPassword(username, password);
            break;
          case InterfaceUI.NO:
            System.out.println(InterfaceUI.LOGGING_OUT);
            break;
          default:
            System.out.println(InterfaceUI.DEFAULT_ERROR);
            break;
        }

        break;
      case 3:
        System.out.print(InterfaceUI.ENTER_USERNAME);
        String username2 = usernameScanner.nextLine();
        System.out.print(InterfaceUI.ENTER_NEW_PASSWORD);
        String newPassword = passwordScanner.nextLine();

        dropper.refreshCurrentUserPassword(username2, newPassword);
        break;
      case 4:
        break;
      default:
        System.out.print(InterfaceUI.DEFAULT_ERROR);
        break;
    }
  }

}
