package com.igp.studentservice.util.pattern;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * An extremely btec version of scala's pattern matching. I wanted to use scala itself but AWS wouldn't let me :(
 */
@SuppressWarnings("unchecked") // this is safe bc the only input allowed into Case is enforced to be the correct type in the methods.
public class PatternMatcher<T, R> {

    private final Set<Case<T, R>> cases;

    private Case<T, R> defaultCase;

    public PatternMatcher() {
        this.cases = new HashSet<>();
    }

    public PatternMatcher<T, R> defineCase(T input, R output, Guard... guards) {
        return defineCase((Case<T, R>) Case.constant(input).then(output).withGuards(guards));
    }

    public PatternMatcher<T, R> defineCase(Predicate<T> matcher, R output, Guard... guards) {
        return defineCase((Case<T, R>) Case.of(matcher).then(output).withGuards(guards));
    }

    public PatternMatcher<T, R> defineCase(Case<T, R> _case) {
        cases.add(_case);
        return this;
    }

    public PatternMatcher<T, R> defaultCase(R output) {
        this.defaultCase = Case.defaultCase(output);
        return this;
    }

    public R match(T input) {
        Objects.requireNonNull(defaultCase, "Default case can't be null");


        return cases.stream()
                .filter(c -> c.test(input))
                .findFirst()
                .orElse(defaultCase).getOutput();
    }
}
