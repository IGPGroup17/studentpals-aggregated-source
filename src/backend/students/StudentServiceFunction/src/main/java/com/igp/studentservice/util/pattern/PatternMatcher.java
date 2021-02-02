package com.igp.studentservice.util.pattern;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * An extremely btec version of scala's pattern matching. I wanted to use scala itself but AWS wouldn't let me :(
 */
@SuppressWarnings("unchecked") // warning - this isn't safe! honestly i cba to fix it bc type erasures a bitch - please dont fuck it up kthanks
public class PatternMatcher<I, O> {

    private final Set<Case<I, O>> cases;

    private Case<I, O> defaultCase;

    public PatternMatcher() {
        this.cases = new HashSet<>();
    }

    public PatternMatcher<I, O> defineCase(I input, O output, Guard... guards) {
        return defineCase((Case<I, O>) Case.constant(input).then(output).withGuards(guards));
    }

    public PatternMatcher<I, O> defineCase(Predicate<I> matcher, O output, Guard... guards) {
        return defineCase((Case<I, O>) Case.of(matcher).then(output).withGuards(guards));
    }

    public PatternMatcher<I, O> defineCase(Case<I, O> caze) {
        cases.add(caze);
        return this;
    }

    public PatternMatcher<I, O> defaultCase(O output) {
        this.defaultCase = Case.defaultCase(output);
        return this;
    }

    public O match(I input) {
        Objects.requireNonNull(defaultCase, "Default case can't be null");
        return cases.stream()
                .filter(c -> c.test(input))
                .findFirst()
                .orElse(defaultCase).getOutput();
    }
}
