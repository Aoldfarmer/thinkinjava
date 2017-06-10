package com.koou.annotation;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by yunqiangdi on 3/17/2017.
 */
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {
    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment env) {
        return new InterfaceExtractorProcessor(env);
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotation.ExtractInterface");
    }

    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }
}
