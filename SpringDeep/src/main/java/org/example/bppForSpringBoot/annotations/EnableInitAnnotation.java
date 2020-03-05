package org.example.bppForSpringBoot.annotations;

import org.example.bppForSpringBoot.config.InitAnnotationConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(InitAnnotationConfig.class)
public @interface EnableInitAnnotation {
}
