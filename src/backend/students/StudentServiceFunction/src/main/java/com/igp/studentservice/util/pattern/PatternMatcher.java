package com.igp.studentservice.util.pattern;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * PROBLEM: We wanna be more specific about the HTTP Request (ie. We want to check that the request is 1) going to the
 * correct path and 2, that its of a certain type of HTTP request. For example, /students/1. We need to check that it
 * follows the structure /students/{id} AND that it's a GET Request.
 *
 * SOLUTION:
 * An extremely btec version of scala's pattern matching. I wanted to use scala itself but AWS wouldn't let me :(
 *
 * This allows you to define a switch statement in one line, with additional conditionals (in the form of Guards
 * {@link Guard}. It can then match a string at the end.
 *
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
