## MVP-Dagger-Retrofit-Sample-App
This project demonstrates Model-View-Presenter pattern + Dagger + Retrofit usage in android. 

***Model–view–presenter (MVP)*** is a derivation of the model–view–controller (MVC) architectural pattern which mostly used for building user interfaces.
In MVP, the presenter assumes the functionality of the “middle-man”. In MVP, all presentation logic is pushed to the presenter. MVP advocates separating business and persistence logic out of the Activity and Fragment.

***Dagger 2*** is dependency injection framework. It is based on the Java Specification Request (JSR) 330. It uses code generation and is based on annotations. The generated code is very relatively easy to read and debug.

***Retrofit*** is type-safe REST client for Android and Java which aims to make it easier to consume RESTful web services.

Following notable libraries have been used in this project
  1. [Retrofit 2](http://square.github.io/retrofit/) for API interaction
  2. [Dagger 2](https://github.com/google/dagger) for dependency injection.
  
I have used Dagger `SubComponents` to pass dependencies down in dependency graph.

Some nice articles for learning `Dagger 2` :
 
 1. [Dependency Injection with Dagger 2- CodePath](https://guides.codepath.com/android/dependency-injection-with-dagger-2)
 2. [Dependency injection with Dagger 2 - the API](http://frogermcs.github.io/dependency-injection-with-dagger-2-the-api/)
 3. [Introduction to Dagger 2, Using Dependency Injection in Android: Part 2](https://blog.mindorks.com/introduction-to-dagger-2-using-dependency-injection-in-android-part-2-b55857911bcd)
 4. [An Introduction to Dagger 2 (Android DI) – Part 1](https://dzone.com/articles/an-introduction-to-dagger-2-android-di-part-1-3)

Happy Coding!!

