# AwesomeGIC Bank

A simple banking system that handles operations on bank accounts.

## Table of Contents

- [Features](#features)
- [Quick start](#Quickstart)
- [Known Bugs](#usage)

## Features

Currently, the bank system is capable of three features:

- Depositing an amount
- Withdrawing an amount
- Printing account statement

When depositing or withdrawing money, I have made it such that users are only able to deposit / withdraw positive amount with 2 decimal place precision.

## Quick start

The following steps are similar for all operating systems(OS) such as Windows, macOS and Linux.

1. Ensure you have Java `11` or above installed in your computer.
2. Download the latest Jar release, in this case it should be in the base directory with the name `GicBankAccount.jar`
2. In the project base direction, use the command
   - `java -jar GicBankAccount.jar`
3. You should see a welcome message from the application.

Or you can compile all the required classes and run directly from the entry point at `src/main/java/bank/BankAccount.java`


## Known Bugs

- Due to size limitation of Java's [`Double`](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html) class, when representing very large or small number, you may encounter issues such as loss of precision or unexpected behaviors.
  - When the bank balance has a very large or small number, further deposit / withdrawal commands may encounter unexpected behaviour.
  - Possible consideration, use Java's `BigDecimal`
