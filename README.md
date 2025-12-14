# Knowledge Hub Android App

Welcome to the official repository for the Knowledge Hub, a modern Android application designed to be a central place for information on various technologies. This app showcases a modern, animated user interface and is built using best practices in Android development.

## Project Overview

This project was developed incrementally, focusing on creating a visually appealing and interactive user experience. It starts with a dynamic splash screen and navigates to a technology selection screen, which then leads to detailed information pages for each technology.

## Features Implemented

1.  **Animated Splash Screen (`MainActivity`)**
    *   A visually engaging entry point to the app.
    *   Uses `MotionLayout` to create a smooth, automated animation for the welcome text and a "Let's Go" button.
    *   Features a modern, dark-themed background with subtle, decorative shapes that also animate in.

2.  **Technology Selection Screen (`TechnologiesActivity`)**
    *   A grid of six `CardView`s, each representing a different technology field:
        *   Android App Dev
        *   iOS App Dev
        *   Web Dev
        *   ML (Machine Learning)
        *   Blockchain
        *   Web3
    *   The cards are styled with semi-transparent backgrounds and a ripple effect, providing clear visual feedback that they are clickable.
    *   Includes a "Call Us" button that initiates a direct phone call using an implicit intent.
    *   Implements runtime permission requests to safely handle the `CALL_PHONE` permission on modern Android versions.

3.  **Detail Screens (`DetailActivity`)**
    *   A single, reusable activity that serves as a template for displaying detailed information for each technology.
    *   Features a prominent, rainbow-colored title `TextView` for an eye-catching effect.
    *   Displays a `ScrollView` containing a list of technology stacks, each with a placeholder logo and a one-liner description.
    *   This screen is dynamically populated based on the technology card the user clicks, demonstrating a flexible and efficient single-activity architecture.

## Technical Details & Architecture

*   **Language**: Kotlin
*   **UI Toolkit**: Android Views with Material Components.
*   **Layouts**: `ConstraintLayout` is used for complex screen arrangements. `MotionLayout` is used for sophisticated animations on the main screen.
*   **Architecture**: Follows a multi-activity architecture, using `Intent`s to pass data and navigate between screens. A single-activity approach is adopted for the detail screens to promote code reuse and maintainability.
*   **Styling**: The app uses a consistent dark theme. Styles are centralized in `themes.xml` for `CardView`s and `TextView`s to ensure a uniform design language.
*   **Permissions**: The app correctly requests the `CALL_PHONE` permission at runtime, following modern Android best practices.

## How to Use

1.  Clone the repository to your local machine.
2.  Open the project in Android Studio.
3.  Build and run the app on an Android emulator or a physical device.

This README provides a good overview of the project's current state. As the project grows, you can continue to update this file with more details on new features, libraries, and setup instructions.
