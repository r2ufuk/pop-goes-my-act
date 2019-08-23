# pop-goes-my-act

'Pop! Goes My Act' is an Android app which lists actors/actresses from [The Movie Database(TMDb)](https://www.themoviedb.org/?language=en-US).

## Features
- Popularity-based sorting
- Search by actor/actress name

*Currently first 40 (hardcoded) pages from the [TMDb API](https://www.themoviedb.org/documentation/api?language=en-US) are processed.*

## Architecture
[Clean Architecture](https://medium.com/@dmilicic/a-detailed-guide-on-developing-android-apps-using-the-clean-architecture-pattern-d38d71e94029) is adopted for the main scope of this project.


[MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) (or MVP with a basic ViewModel) pattern is followed for presentation.

## Dependencies
- RxJava
- Butterknife
- Gson
- Volley
- Glide
- Dagger2 (TODO)
