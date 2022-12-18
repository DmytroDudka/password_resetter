package com.pr.util;

import com.pr.util.service.PasswordResetterImplementation;
import com.pr.util.service.ResetterService;

import java.io.IOException;

public class PREXECUTOR {

  public static void main(String[] args) throws IOException {
    PasswordResetterImplementation dropper = new PasswordResetterImplementation();
    ResetterService executor = ResetterService.initializeComponent(dropper);
    executor.start();
  }
}

