# Simple App Kotlin using MVP Architecture

## Looking for the old code ?
If you are looking for the old code, you can checkout to the [v1 branch](https://github.com/eminartiys/simple-app-kotlin/tree/v1)

_Last Updated: October 02nd 2018_

## Introduction
Welcome to an example implementation of Android Application in Kotlin with TDD. MVP is based on uncle bob's clean architecture. Details of Clean Architecture by Uncle Bob can be seen on this [link](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)

This project using MVP, Repository Pattern and RxJava2 + TDD.

## TDD
TDD, in short `a development environment where you write test cases first of your code first, not implementation`. You can find more [here](https://www.tutorialspoint.com/software_testing_dictionary/test_driven_development.htm).

## Folder Structure
The main source folder with structure below:
- `model/` – contains models/entities that exist in the app.
- `presenter/` – contains presenter of each related view that manages events that translates into routing, inputs or output
- `repository/` – contains all business logic, API and local data managements.
- `ui/` – . contains main UI (activity and fragment) and related contract for the related view
- `widget/` – contains view that exist in the app like viewholder, custom view, and etc.

## Environment
This code is built on `Android Studio` with minSdkVersion 19 is `19`, and written in `Kotlin

## Author
Created by [Eminarti Sianturi](https://www.linkedin.com/in/eminarti-sianturi/). Contact me at eminartiys@gmail.com