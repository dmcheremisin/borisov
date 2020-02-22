package org.example.puzzler3.genre;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Comedy @Action @Melodrama
public @interface AnyGenre {
}
