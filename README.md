Android TV Sample app made with Jetpack Compose
==================

This is a fully functional Android app built entirely with Kotlin and Jetpack Compose. It
follows Android design and multi-module best practices

# Architecture

The app follows the [official architecture guidance](https://developer.android.com/topic/architecture) 
with the following layers:
- Data. Contains the movies repository and is connected directly with the Network module which has an implementation of the repository to fetch data using Retrofit
- Domain. Connects to the Data layer using use cases to fetch different types of data from the repository
- Model. This is the data models used by the app.
- App. This is the actual android application, uses Jetpack Compose to present the data and viewmodels to call the usecases

# Modularization

The app has been fully modularized where each layer has its own module for better isolation
